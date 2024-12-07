package com.example.queue_app.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public String authenticateUser(String username, String password) {

        String token = generateToken(username, password);


        Optional<User> userOptional = userRepository.findByToken(token);

        if (userOptional.isPresent()) {
            return token;
        } else {

            User newUser = new User();
            newUser.setUsername(username);
            newUser.setToken(token);
            userRepository.save(newUser);
            return token;
        }
    }

    public Boolean authenticateUserByToken(String token) {


        Optional<User> userOptional = userRepository.findByToken(token);

        if (userOptional.isPresent()) {
            return true;
        }
        return false;
    }

    public void deleteUserByToken(String token) {
        Optional<User> userOptional = userRepository.findByToken(token);
        userOptional.ifPresent(userRepository::delete);
    }

    private String generateToken(String username, String password) {
        String combined = username + password;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(combined.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}