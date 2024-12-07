package com.example.queue_app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class Urls {

    @GetMapping("/")
    public String login_page() {
        return "index";
    }

    @GetMapping("/login")
    public String main() {
        return "login";
    }

    @GetMapping("/error")
    public String error() {
        return "error";
    }

}
