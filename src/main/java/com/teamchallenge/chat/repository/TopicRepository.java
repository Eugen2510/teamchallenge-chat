package com.teamchallenge.chat.repository;

import com.teamchallenge.chat.entities.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
