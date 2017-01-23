package com.greenfox.jasper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by almasics on 2017.01.23..
 */
@Service
public class BuildingServices {

    private BuildingRepository buildingRepository;

    @Autowired
    public BuildingServices(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public Building saveBuilding(Building building) {
        return buildingRepository.save(building);
    }

    public Building findBuilding(Long id) {
        return buildingRepository.findOne(id);
    }

}
