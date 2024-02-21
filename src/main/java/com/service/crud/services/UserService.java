package com.service.crud.services;

import java.util.List;
import java.util.UUID;

import com.service.crud.entities.User;

public interface UserService {
    User createUser(User user);

    User getUserById(UUID userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(UUID userId);
    
}
