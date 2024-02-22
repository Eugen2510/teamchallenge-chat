package com.teamchallenge.chat.repository;

import com.teamchallenge.chat.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
