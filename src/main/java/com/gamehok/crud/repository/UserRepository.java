package com.gamehok.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gamehok.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
