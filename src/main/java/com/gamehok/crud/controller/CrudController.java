package com.gamehok.crud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CrudController {
    public class Message {
        private String message;

        private Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public String setMessage(String message) {
            this.message = this.message + " " + message;
            return this.message;
        }
    }

    @GetMapping("/")
    public Message getMessage() {
        Message message = new Message("Hello from Spring Boot!");
        message.setMessage("Dev's");
        return message;
    }
}
