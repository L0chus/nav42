package janlochba.repository;

import janlochba.dto.RecAnalysisDTO;
import janlochba.entity.RecAnalysis;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecAnalysisRepository extends JpaRepository<RecAnalysis,Integer> {



}
