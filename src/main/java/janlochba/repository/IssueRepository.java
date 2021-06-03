package janlochba.repository;

import janlochba.dto.IssueDTO;
import janlochba.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface IssueRepository extends JpaRepository<Issue,String> {

    //Alle finden
    List<IssueDTO> findIssueByIdNotNull();
    //Aufsteigende Liste
    List<IssueDTO> findAllByOrderByMaxValueAsc();
    //Absteigende Liste
    List<IssueDTO> findAllByOrderByMaxValueDesc();
    //nur die Top X finden
    List<IssueDTO> findTop15ByOrderByMaxValueDesc();

}
