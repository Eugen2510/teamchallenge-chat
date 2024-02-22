package com.teamchallenge.chat.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Country {

    @Id
    @Column(name = "id_country")
    private int idCountry;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "region_id")
    private Region region;
}
