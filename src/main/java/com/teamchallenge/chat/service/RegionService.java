package com.teamchallenge.chat.service;

import com.teamchallenge.chat.dto.RegionDTO;
import com.teamchallenge.chat.entities.Region;
import com.teamchallenge.chat.repository.RegionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/*
Region - прописать методы:
1) для доставания всех регионов из БД
2) конкретного региона по id
3) региона по названию региона

 */
@Service
@RequiredArgsConstructor
public class RegionService {
    private final RegionRepository regionRepository;
    public List<RegionDTO> getAllRegions(){
        return regionRepository.findAll()
                .stream()
                .map(x->new RegionDTO(x.getRegionName()))
                .toList();
    }
    public RegionDTO getRegionById(long id){
        return new RegionDTO(regionRepository.findById(id).orElseThrow().getRegionName());
    }
    public Region getRegionByName(String nameOfRegion){
        return regionRepository.findByRegionName(nameOfRegion);
    }

}
