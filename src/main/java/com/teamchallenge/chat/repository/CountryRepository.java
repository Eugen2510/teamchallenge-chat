package com.teamchallenge.chat.repository;

import com.teamchallenge.chat.dto.CountryDTO;
import com.teamchallenge.chat.entities.Country;
import com.teamchallenge.chat.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {
    Country findByCountryName(String countryName);//Создаю метод поиска по имени, реализацию JpaRepository возьмет на себя сам
}
