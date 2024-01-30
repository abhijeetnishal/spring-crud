package com.gamehok.crud.controllers;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gamehok.crud.entities.User;
import com.gamehok.crud.repositories.userRepository;

@RestController
public class userController {
    @Autowired
    private userRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable("id") Long id) {
        return userRepository.findById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/users/{id}")
    public User  updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        Optional<User> employee1 = userRepository.findById(id);

        if (employee1.isPresent()) {
            User originalEmployee = employee1.get();

            if (Objects.nonNull(user.getName()) && !"".equalsIgnoreCase(user.getName())) {
                originalEmployee.setName(user.getName());
            }
            if (Objects.nonNull(user.getEmail()) && user.getEmail() != "") {
                originalEmployee.setEmail(user.getEmail());
            }
            
            return userRepository.save(originalEmployee);
        }
        return null;
    }

    @DeleteMapping("/users/{id}")
    public void deleteStudent(@PathVariable(value = "id") Long id) {
        userRepository.deleteById(id);
    }
}
