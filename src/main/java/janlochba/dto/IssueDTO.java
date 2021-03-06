package janlochba.dto;

import java.util.List;

public interface IssueDTO {

    public Integer getId();

    public String getName();

    public String getDescription();

    public Double getMinValue();

    public Double getMaxValue();

    public String getTyp();

    public List<SolutionDTO> getSolutions();

}
