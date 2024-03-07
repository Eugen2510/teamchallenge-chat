package com.teamchallenge.chat.repository;

import com.teamchallenge.chat.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Long> {
    Region findByRegionName(String regionName);//Создаю метод поиска по имени, реализацию JpaRepository возьмет на себя сам
}
