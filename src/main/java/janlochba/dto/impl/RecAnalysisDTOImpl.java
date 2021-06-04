package janlochba.dto.impl;

import janlochba.dto.RecAnalysisDTO;

public class RecAnalysisDTOImpl implements RecAnalysisDTO {

    private Integer id;
    private String name;
    private String description;
    private String typ;
    private String extra1;
    private String extra2;

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
    public String getTyp() {
        return typ;
    }

    @Override
    public String getExtra() {
        return extra1;
    }

    @Override
    public String getExtra2() {
        return extra2;
    }
}
