package janlochba.control.factory;

import janlochba.dto.SolutionDTO;
import janlochba.entity.Issue;
import janlochba.entity.Solution;

import java.util.ArrayList;
import java.util.List;

public class SolutionFactory {
    public static Solution createSolution(SolutionDTO solutionDTO) {

        Solution solution = new Solution();

        solution.setId(solutionDTO.getId());
        solution.setName(solutionDTO.getName());
        solution.setDescription(solutionDTO.getDescription());
        solution.setMinCost(solutionDTO.getMinCost());
        solution.setMaxCost(solutionDTO.getMaxCost());

        List<Issue> issues = new ArrayList<>();

       /* for (IssueDTO issueDTO : solutionDTO.getIssues()) {
            issues.add(IssueFactory.createIssue(issueDTO));
        }*/

        solution.setIssues(issues);

        return solution;
    }
}
