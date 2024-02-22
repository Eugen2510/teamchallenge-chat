package com.teamchallenge.chat.repository;

import com.teamchallenge.chat.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
