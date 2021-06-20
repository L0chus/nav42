package janlochba.control.factory;

import janlochba.dto.IssueDTO;
import janlochba.entity.Issue;
import janlochba.entity.Solution;

import java.util.ArrayList;
import java.util.List;

public class IssueFactory {
    public static Issue createIssue(IssueDTO issueDTO) {

        Issue issue = new Issue();

        issue.setName(issueDTO.getName());
        issue.setTyp(issueDTO.getTyp());
        issue.setDescription(issueDTO.getDescription());
        issue.setMinValue(issueDTO.getMinValue());
        issue.setMaxValue(issueDTO.getMaxValue());

        List<Solution> solutions = new ArrayList<>();

        /*for (SolutionDTO solutionDTO : issueDTO.getSolutions()) {
            solutions.add(SolutionFactory.createSolution(solutionDTO));
        }*/

        //issue.setSolutions(solutions);

        return issue;
    }
}