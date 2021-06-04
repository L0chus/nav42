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

    /*public List<RecAnalysisDTO> readRecAnalysis(){
        return repository.findDistinctByExtra1();
    }*/

}
