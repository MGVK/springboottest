package ru.mgvk;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileController {
    // ...
    @DeleteMapping("/detelefile")
    ResponseEntity<String> deteleFile(@RequestParam String filename) {
        try {
            String path = "/path/to/trusted/dir/" + filename;
            Files.delete(Paths.get(path));
        } catch (IOException e) {
            return new ResponseEntity<>(
                    "Error while removing file!",
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(
                "File deleted successfully! ",
                HttpStatus.OK);
//  ...
    }
}







//
//class FileController {
//    //  …
//    @DeleteMapping("/detelefile")
//    ResponseEntity<String> deteleFile(@RequestParam String filename) {
//        try {
//            ProcessBuilder      pb  = new ProcessBuilder("rm", filename);
//            Map<String, String> env = pb.environment();
//            pb.directory(new File("path/to/files/where/you/want/to/rm"));
//            Process p = pb.start();
//        } catch (IOException e) {
//            return new ResponseEntity<>("Error while removing file!", HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<>("File deleted successfully! ", HttpStatus.OK);
////  ...
//    }
//}
//
//


//public class FileController {
//    @DeleteMapping("/detelefile")
//    ResponseEntity<String> deteleFile(@RequestParam String filename) throws IOException {
//        try {
//            Runtime.getRuntime().exec(new String[]{"bash", "-c", "rm " + filename});
//        } catch (IOException e) {
//            return new ResponseEntity<>("Error while removing file!", HttpStatus.BAD_REQUEST);
//        }
////  ...
//
//        class Form {
//            String data;
//        }
//        Form form = new Form();
//
//
//
//
//        Runtime.getRuntime().exec(new String[]{"bash","-c",
//                String.format("curl http://example.org/search/?text=%s", form.data)});
//
//
//
//
//
//
//
//
//
//        String a = form.data;
//        a = a.replace("\\","\\\\");
//        a = a.replace("\"","\\\"");
//        a = a.replace("","\\");
//        a = a.replace("$","\\$");
//        a = a.replace(";","\\;");
//        a = a.replace("&","\\&");
//        Runtime.getRuntime().exec(new String[]{"bash","-c",
//                String.format("curl http://example.org/search/?text=%s",form.data)});
//
//
//
//
//
//
//
//
//
//        ProcessBuilder b = new ProcessBuilder("rm -arg1 -arg2");
//
//
//
//
//
//
//
//
//        ProcessBuilder      pb  = new ProcessBuilder("TrustedCmd", "UserArg1", "UserArg2");
//        Map<String, String> env = pb.environment();
//        pb.directory(new File("TrustedDir"));
//        Process p = pb.start();
//
//
//
//
//
//
//
//
//
//
//
//        return new ResponseEntity<>("File deleted successfully! ", HttpStatus.OK);
//
//
//    }
//}
