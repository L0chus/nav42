package janlochba.repository;

import janlochba.dto.IssueDTO;
import janlochba.entity.Issue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface IssueRepository extends JpaRepository<Issue,String> {
   //@Autowired
    //Optional<IssueDTO> findById(); // Testdaten in IssueList eingeben
    @Query(" SELECT i.id, i.name, i.description, i.typ, i.minValue, i.maxValue " +
            " FROM Issue i ")

    List<IssueDTO> findIssueByIdNotNull();

}
