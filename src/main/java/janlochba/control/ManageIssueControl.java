package janlochba.control;

import janlochba.control.factory.IssueFactory;
import janlochba.dto.IssueDTO;
import janlochba.entity.Issue;
import janlochba.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ManageIssueControl {

    @Autowired
    private IssueRepository repository;

    public void createIssue(IssueDTO issueDTO) {

        Issue issueEntity = IssueFactory.createIssue(issueDTO);

        this.repository.save(issueEntity);
    }

    public List<IssueDTO> readAllIssues() {
        return repository.findTop15ByOrderByMaxValueDesc();
    }

    public void delete(Issue issue) {
        repository.delete(issue);
    }
}
