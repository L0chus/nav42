package janlochba.control;

import janlochba.dto.RecImproveDTO;
import janlochba.repository.RecImproveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ManageRecImproveControl {

    @Autowired
    private RecImproveRepository repository;

    public List<RecImproveDTO> recImprovement(String typ, String extra1, String extra2) {
        return repository.findByTypAndExtra1AndExtra2(typ, extra1, extra2);
    }

}
