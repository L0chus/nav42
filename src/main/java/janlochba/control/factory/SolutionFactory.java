package janlochba.control.factory;

import janlochba.dto.IssueDTO;
import janlochba.dto.SolutionDTO;
import janlochba.entity.Issue;
import janlochba.entity.Solution;
import janlochba.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class SolutionFactory {

    @Autowired
    private IssueRepository issueRepository;

    public Solution createSolution(SolutionDTO solutionDTO) {

        Solution solution = new Solution();

        solution.setId(solutionDTO.getId());
        solution.setName(solutionDTO.getName());
        solution.setDescription(solutionDTO.getDescription());
        solution.setMinCost(solutionDTO.getMinCost());
        solution.setMaxCost(solutionDTO.getMaxCost());

        List<Issue> issues = new ArrayList<>();

        for (IssueDTO issueDTO : solutionDTO.getIssues()) {
            Optional<Issue> issueOptional = issueRepository.findById(issueDTO.getId());

            if (issueOptional.isPresent()) {
                issues.add(issueOptional.get());
            }
        }

        solution.setIssues(issues);

        return solution;
    }
}
