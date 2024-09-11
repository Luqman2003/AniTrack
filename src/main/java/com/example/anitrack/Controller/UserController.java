package com.example.anitrack.Controller;

import com.example.anitrack.Service.UserService;
import com.example.anitrack.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/users")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public String createUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        return userService.createUser(user);
    }

    @GetMapping("/get")
    public User getCrud(@RequestParam String document_id) throws InterruptedException, ExecutionException {
        return userService.getUser(document_id);
    }

    @PutMapping("/update")
    public String updateUser(@RequestBody User user) throws InterruptedException, ExecutionException {
        return userService.updateUser(user);
    }

    @PutMapping("/delete")
    public String deleteCrud(@RequestParam String document_id) {
        return userService.deleteUser(document_id);
    }
}
