package com.greenfox.jasper;

import javax.persistence.*;

/**
 * Created by almasics on 2017.01.23..
 */
@Entity
@Table
public class Building {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int buildingLevel = 1;

    public Building() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBuildingLevel() {
        return buildingLevel;
    }

    public void setBuildingLevel(int buildingLevel) {
        this.buildingLevel = buildingLevel;
    }

    public String buildingTosTring() {
        return String.format("buildinglevel: %d", buildingLevel);
    }
}
