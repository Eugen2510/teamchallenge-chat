package com.teamchallenge.chat.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.teamchallenge.chat.dto.CountryDTO;
import com.teamchallenge.chat.dto.RegionDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Region {
    @Id
    @Column(name = "id_region")
    private int idRegion;

    @Column(name = "region_name")
    private String regionName;

    public RegionDTO convertToDTO(Region region){
        return new RegionDTO(region.getRegionName());
    }
}
