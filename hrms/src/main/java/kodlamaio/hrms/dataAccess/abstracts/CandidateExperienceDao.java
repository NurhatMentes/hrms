package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceDao extends JpaRepository<CandidateExperience,Integer> {
    List<CandidateExperience> getAllByCandidateIdOrderByLeaveDateDesc(int candidateId);
}