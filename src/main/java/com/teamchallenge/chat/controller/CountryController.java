package com.teamchallenge.chat.controller;

import com.teamchallenge.chat.dto.CountryDTO;
import com.teamchallenge.chat.dto.RegionDTO;
import com.teamchallenge.chat.entities.Country;
import com.teamchallenge.chat.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService countryService;
    @GetMapping("/get-all")
    public List<CountryDTO> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/get-id/{id}")
    public CountryDTO getCountryById(@PathVariable Long id){
        return countryService.getCountryById(id);
    }

    @GetMapping("/get-name/{name}")
    public CountryDTO getCountryByName(@PathVariable String name){
        return new CountryDTO(countryService.getCountryByName(name).getCountryName());
    }

    //контроллер не работает
    @PostMapping("/create/{nameCountry}")
    public CountryDTO createCountry(@PathVariable String nameCountry){
        return countryService.createCountry(nameCountry);
    }

}
