package janlochba.dto.impl;

import janlochba.dto.IssueDTO;

public class IssueDTOImpl implements IssueDTO {

    private String id;
    private String name;
    private String description;
    private Long minValue;
    private Long maxValue;
    private String typ;

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
    public Long getMinValue() {
        return minValue;
    }

    @Override
    public Long getMaxValue() {
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

    public void setMinValue(Long minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(Long maxValue) {
        this.maxValue = maxValue;
    }

    public void setTyp(String typ){ this.typ = typ; }

}
