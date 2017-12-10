package ru.mgvk;

public interface UserService {
    void save(Users user);

    Users findByUsername(String username);
}
