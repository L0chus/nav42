package janlochba.repository;

import janlochba.dto.IssueDTO;
import janlochba.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface IssueRepository extends JpaRepository<Issue,String> {
   //@Autowired
    //Optional<IssueDTO> findById(); // Testdaten in IssueList eingeben
    //List<IssueDTO> findIssueByIdNotNull();
}
