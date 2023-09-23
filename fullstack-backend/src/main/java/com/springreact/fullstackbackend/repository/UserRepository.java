package com.springreact.fullstackbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springreact.fullstackbackend.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
