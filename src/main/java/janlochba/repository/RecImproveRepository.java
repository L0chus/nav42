package janlochba.repository;

import janlochba.dto.RecAnalysisDTO;
import janlochba.entity.RecImprove;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecImproveRepository extends JpaRepository<RecImprove,Integer> {

    //List<RecAnalysisDTO> findByTypAndExtra1AndExtra2(String typ, String extra1, String extra2);

}
