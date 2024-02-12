package com.gamehok.crud.services;

import java.util.List;
import java.util.UUID;

import com.gamehok.crud.entities.User;

public interface UserService {
    User createUser(User user);

    User getUserById(UUID userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(UUID userId);
    
}
