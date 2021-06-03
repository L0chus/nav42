package janlochba.repository;

import janlochba.dto.SolutionDTO;
import janlochba.entity.Solution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SolutionRepository extends JpaRepository<Solution,String> {

    List<SolutionDTO> findTop15ByOrderByMaxCostDesc();;
}
