package janlochba.control;

import janlochba.control.factory.SolutionFactory;
import janlochba.dto.SolutionDTO;
import janlochba.entity.Solution;
import janlochba.repository.SolutionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ManageSolutionControl {

    @Autowired
    private SolutionRepository repository;

    @Autowired
    private SolutionFactory solutionFactory;

    public void createSolution(SolutionDTO solutionDTO) {

        Solution solutionEntity = solutionFactory.createSolution(solutionDTO);
        this.repository.save(solutionEntity);
    }

    public List<SolutionDTO> readAllSolutions() {
        return repository.findTop15ByOrderByMaxCostDesc();
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public void delete1(Solution solution) {
        repository.delete(solution);
    }

}
