package janlochba.recommender;

import janlochba.dto.RecAnalysisDTO;
import janlochba.repository.RecAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class RecommendationAnalysis {

    @Autowired
    private RecAnalysisRepository repository;

    public List<RecAnalysisDTO> recAnalysis(String typ, String extra1) {
        return repository.findByTypAndExtra1(typ, extra1);
    }

}
