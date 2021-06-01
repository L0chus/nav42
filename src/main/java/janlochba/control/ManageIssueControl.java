package janlochba.control;


import janlochba.control.factory.IssueFactory;
import janlochba.dto.IssueDTO;
import janlochba.entity.Issue;
import janlochba.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManageIssueControl {

    @Autowired
    private IssueRepository repository;

    public void createIssue( IssueDTO issueDTO ){

        //Erzeuge einer neuen Issue-Entity über die Factory
        Issue issueEntity = IssueFactory.createIssue( issueDTO );

        // Abspeicherung des Entity in die DB
        this.repository.save(issueEntity);
    }

  /* public List<IssueDTO> readAllIssues(){
        return repository.findIssueByIdNotNull();
    }*/

}
