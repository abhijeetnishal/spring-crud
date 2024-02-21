package com.service.crud.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.crud.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {
}
