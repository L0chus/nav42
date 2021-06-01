package janlochba.dto.impl;

import janlochba.dto.SolutionDTO;

public class SolutionDTOImpl implements SolutionDTO {

    private String id;
    private String name;
    private String description;
    private Long minCost;
    private Long maxCost;

    //getter
    @Override
    public String getID() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public Long getMinCost() {
        return minCost;
    }

    @Override
    public Long getMaxCost() {
        return maxCost;
    }

    //setter

    public void setId(String id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinCost(Long minValue) {
        this.minCost = minCost;
    }

    public void setMaxCost(Long maxValue) {
        this.maxCost = maxCost;
    }
}
