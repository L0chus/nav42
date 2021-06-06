package janlochba.control;

import janlochba.dto.RecAnalysisDTO;
import janlochba.repository.RecAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManageRecAnalysisControl {

    @Autowired
    private RecAnalysisRepository repository;

    public List<RecAnalysisDTO> recImprovement(String typ, String extra1){
        return repository.findByTypAndExtra1(typ, extra1);
    }

}
