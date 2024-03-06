package com.teamchallenge.chat.service;

import com.teamchallenge.chat.dto.CountryDTO;
import com.teamchallenge.chat.dto.RegionDTO;
import com.teamchallenge.chat.entities.Country;
import com.teamchallenge.chat.entities.Region;
import com.teamchallenge.chat.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/*
Country - методы:
1) получить все страны,
2) страну по id,
3) страну по названию,
4) метод для создания страны,
Также:
продумать логику, что если страна добавляется впервые, должен создаваться топик где id страны будет соответственно id этой страны, id города пустой

 */
@Service
@RequiredArgsConstructor
public class CountryService {
    private final CountryRepository countryRepository;
    public List<CountryDTO> getAllCountries(){
        return countryRepository.findAll()
                .stream()
                .map(x->new CountryDTO(x.getCountryName()))
                .toList();
    }
    public CountryDTO getCountryById(long id){
        return new CountryDTO(countryRepository.findById(id).orElseThrow().getCountryName());
    }

    public Country getCountryByName(String nameOfCountry){
        return countryRepository.findByCountryName(nameOfCountry);
    }

    /*
    Метод рабочий на половину, он ищет и сравнивает страны по имени и вернет страну с указаным именем если она есть.
    Но он не будет создавать топик. Потому как для этого нужен реализованый сервис топика, как я понимаю
     */
    public CountryDTO createCountry(String nameCountry){
        /*
        Тут наверено вызвать getAllCountries, и по имени сравнить если страна уже есть и если её нет.
        Если такой страны нет тогда создавать топик где id страны будет соответственно id этой страны, id города пустой
         */
        CountryDTO countryDTO = countryIsHere(nameCountry);
        if(countryDTO == null ){
            Country country = countryDTO.convertToCountry();
            country.setCountryName(nameCountry);

            countryRepository.save(country);//Добавление в БД
            return country.convertToDTO(country);
        }else{
            return countryDTO;
        }
    }

    //Метод поиска страны по имени
    private CountryDTO countryIsHere(String nameCountry){
        List<CountryDTO> countryDTOList = getAllCountries();
        for(CountryDTO i : countryDTOList){
            if(i.name().equals(nameCountry)){
               return i;
            }
        }
        return null;
    }


}
