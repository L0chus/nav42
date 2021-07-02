package janlochba.dto;

import java.util.List;

public interface SolutionDTO {

    public Integer getId();

    public String getName();

    public String getDescription();

    public Double getMinCost();

    public Double getMaxCost();

    public List<IssueDTO> getIssues();

    // hierdurch werden die der Solution zugehörigen Issues hintereinander mit , getrennt angezeigt

    public default String getIssuesAsString() {
        List<IssueDTO> issues = getIssues();
        return String.join(", ", issues.stream().map(IssueDTO::getName).toList());
    }
}
