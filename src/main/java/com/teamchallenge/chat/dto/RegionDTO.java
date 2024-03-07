package com.teamchallenge.chat.dto;

import com.teamchallenge.chat.entities.Country;
import com.teamchallenge.chat.entities.Region;

public record RegionDTO(String name) {
    public Region convertToRegion(){
        Region region = new Region();
        region.setRegionName(this.name);
        return region;
    }
}
