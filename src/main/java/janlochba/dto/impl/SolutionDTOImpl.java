package janlochba.dto.impl;

import janlochba.dto.SolutionDTO;

public class SolutionDTOImpl implements SolutionDTO {

    private Integer id;
    private String name;
    private String description;
    private Double minCost;
    private Double maxCost;

    //getter
    @Override
    public Integer getId() {
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
    public Double getMinCost() {
        return minCost;
    }

    @Override
    public Double getMaxCost() {
        return maxCost;
    }

    //setter

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinCost(Double minCost) {
        this.minCost = minCost;
    }

    public void setMaxCost(Double maxCost) {
        this.maxCost=maxCost;
    }
}
