package com.example.queue_app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Autowired
    private UserRepository userRepository;

    public Message saveMessage(String content, String senderToken) {
        Optional<User> userOptional = userRepository.findByToken(senderToken);


        String senderName = userOptional
                .map(User::getUsername)
                .orElseThrow(() -> new RuntimeException("User not found for token: " + senderToken));

        Message message = new Message();
        message.setContent(content);
        message.setSenderName(senderName);
        return messageRepository.save(message);
    }

    // Метод для получения всех сообщений
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }



}