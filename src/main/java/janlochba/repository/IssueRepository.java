package janlochba.repository;

import janlochba.dto.IssueDTO;
import janlochba.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IssueRepository extends JpaRepository<Issue, Integer> {
    
    List<IssueDTO> findIssueByIdNotNull();

    List<IssueDTO> findTop15ByOrderByMaxValueDesc();


}
