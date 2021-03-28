package com.rafu.testes.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafu.testes.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
