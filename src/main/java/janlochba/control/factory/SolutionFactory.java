package janlochba.control.factory;

import janlochba.dto.SolutionDTO;
import janlochba.entity.Solution;

public class SolutionFactory {
    public static Solution createSolution(SolutionDTO solutionDTO){

        Solution solution = new Solution();

        solution.setId(solutionDTO.getID());
        solution.setName(solutionDTO.getName());
        solution.setDescription(solutionDTO.getDescription());
        solution.setMinCost(solutionDTO.getMinCost());
        solution.setMaxCost(solutionDTO.getMaxCost());

        return solution;
    }
}
