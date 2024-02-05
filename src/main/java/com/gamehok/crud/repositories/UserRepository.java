package com.gamehok.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamehok.crud.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
