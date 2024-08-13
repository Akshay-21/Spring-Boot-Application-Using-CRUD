package com.springboot.crud.application.repository;

import com.springboot.crud.application.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
