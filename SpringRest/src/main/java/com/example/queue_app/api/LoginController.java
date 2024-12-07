package com.example.queue_app.api;

import com.example.queue_app.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<String> login(
            @RequestParam String name,
            @RequestParam String password) {
        // Вызов метода аутентификации
        String token = userService.authenticateUser(name, password);
        return ResponseEntity.ok(token);
    }
}