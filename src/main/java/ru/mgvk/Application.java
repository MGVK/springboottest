package ru.mgvk;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping({"/hi", "/", "hello"})
    public String showHelloWorld() {
        return "hello_world";
    }

    @RequestMapping(value = "/ip", method = RequestMethod.GET, produces = {"text/html; "
                                                                           + "charset=UTF-8"})
    public @ResponseBody
    String getClientAddr() {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes()).getRequest();

        return request.getRemoteHost();
    }


    @GetMapping("/add")
    public @ResponseBody
    String addUser(@RequestParam String name, @RequestParam String pass,@RequestParam String role) {

        try {

            Users u = new Users();
            u.setUsername(name);
            u.setPassword(pass);
            u.setRole(role);

            repository.save(u);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
        return "Saved";

    }

    @GetMapping("/remove")
    public @ResponseBody
    String removeUser(@RequestParam String id) {

        try {
            repository.delete(Long.valueOf((id)));

        } catch (Exception e) {
            return "Error";
        }
        return "Removed";
    }

    @GetMapping("/all")
    public @ResponseBody
    Iterable<Users> getAllUsers() {
        return repository.findAll();
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            System.out.println(auth.getDetails());
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
    }

}
