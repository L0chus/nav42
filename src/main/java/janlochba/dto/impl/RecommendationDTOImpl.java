package janlochba.dto.impl;

import janlochba.dto.RecommendationDTO;

public class RecommendationDTOImpl implements RecommendationDTO {

    private String id;

    private String name;

    private String description;

    private String typ;

    private String aoi;

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
    public String getType() {
        return typ;
    }

    @Override
    public String getAoi() {
        return aoi;
    }

}
