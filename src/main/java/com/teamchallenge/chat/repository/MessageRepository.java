package com.teamchallenge.chat.repository;

import com.teamchallenge.chat.entities.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
