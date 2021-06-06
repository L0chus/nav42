package janlochba.repository;

import janlochba.dto.RecImproveDTO;
import janlochba.entity.RecImprove;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecImproveRepository extends JpaRepository<RecImprove,Integer> {

    List<RecImproveDTO> findByTypAndExtra1AndExtra2(String typ, String extra1, String extra2);
    
}
