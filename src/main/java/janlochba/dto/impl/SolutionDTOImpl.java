package janlochba.dto.impl;

import janlochba.dto.IssueDTO;
import janlochba.dto.SolutionDTO;

import java.util.List;

public class SolutionDTOImpl implements SolutionDTO {

    private Integer id;
    private String name;
    private String description;
    private Double minCost;
    private Double maxCost;
    private List<IssueDTO> issues;

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

    @Override
    public List<IssueDTO> getIssues() {
        return issues;
    }

    //setter

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMinCost(Double minCost) {
        this.minCost = minCost;
    }

    public void setMaxCost(Double maxCost) {
        this.maxCost = maxCost;
    }

    public void setIssues(List<IssueDTO> issues) {
        this.issues = issues;
    }
}
