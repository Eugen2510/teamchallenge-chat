package com.teamchallenge.chat.controller;

import com.teamchallenge.chat.dto.CountryDTO;
import com.teamchallenge.chat.dto.RegionDTO;
import com.teamchallenge.chat.service.RegionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/region")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;
    @GetMapping("/get-All")
    public List<RegionDTO> getAllCountries(){
        return regionService.getAllRegions();
    }

    @GetMapping("/get-id/{id}")
    public RegionDTO getRegionById(@PathVariable Long id){
        return regionService.getRegionById(id);
    }
    @GetMapping("/get-name/{name}")
    public RegionDTO getCountryByName(@PathVariable String name){
        return new RegionDTO(regionService.getRegionByName(name).getRegionName());
    }

}
