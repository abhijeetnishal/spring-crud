package com.gamehok.crud.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gamehok.crud.entities.User;

@Repository
public interface userRepository extends CrudRepository<User, Long> {
}
