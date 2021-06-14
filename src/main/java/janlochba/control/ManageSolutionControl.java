package janlochba.control;

import janlochba.control.factory.SolutionFactory;
import janlochba.dto.SolutionDTO;
import janlochba.entity.Solution;
import janlochba.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManageSolutionControl {

    @Autowired
    private SolutionRepository repository;

    public void createSolution(SolutionDTO solutionDTO) {

        Solution solutionEntity = SolutionFactory.createSolution(solutionDTO);
        this.repository.save(solutionEntity);
    }

    public List<SolutionDTO> readAllSolutions() {
        return repository.findTop15ByOrderByMaxCostDesc();
    }

    public List<SolutionDTO> delete(int id) {
        return repository.deleteById(id);
    }
}
