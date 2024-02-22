package com.teamchallenge.chat.repository;

import com.teamchallenge.chat.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
