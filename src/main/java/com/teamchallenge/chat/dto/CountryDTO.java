package com.teamchallenge.chat.dto;

import com.teamchallenge.chat.entities.Country;

import java.util.Objects;


public record CountryDTO(String name) {
    public Country convertToCountry(){
        Country country = new Country();
        country.setCountryName(this.name);
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryDTO that = (CountryDTO) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
