package com.example.queue_app.api;

import com.example.queue_app.data.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/api/del_user")
    public ResponseEntity<String> login(
            @RequestParam String token) {

        userService.deleteUserByToken(token);
        return ResponseEntity.ok(token); // Возвращаем токен
    }
}