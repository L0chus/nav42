package janlochba.dto.impl;

import janlochba.dto.IssueDTO;

public class IssueDTOImpl implements IssueDTO {

    private String id;
    private String name;
    private String description;
    private Double minValue;
    private Double maxValue;
    private String typ;

    //getter
    @Override
    public String getId() {
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
    public Double getMinValue() {
        return minValue;
    }

    @Override
    public Double getMaxValue() {
        return maxValue;
    }

    @Override
    public String getTyp() {
        return typ;
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

    public void setMinValue(Double minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(Double maxValue) {
        this.maxValue = maxValue;
    }

    public void setTyp(String typ){ this.typ = typ; }

}
