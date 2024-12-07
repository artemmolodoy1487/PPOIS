package com.example.queue_app.api;

import com.example.queue_app.data.MessageService;
import com.example.queue_app.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
@RequestMapping("/api/new_message")
public class NewMessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping
    public ResponseEntity<String> make_message(
            @RequestParam String token,
            @RequestParam String content) {

        messageService.saveMessage(content, token);
        return ResponseEntity.ok("save message");
    }

}