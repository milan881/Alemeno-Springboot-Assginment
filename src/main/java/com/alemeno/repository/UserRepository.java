package com.alemeno.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alemeno.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
