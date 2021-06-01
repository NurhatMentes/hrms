package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CandidateEducation;

import java.util.List;

public interface CandidateEducationDao extends JpaRepository<CandidateEducation,Integer> {
    List<CandidateEducation> getAllByCandidateIdOrderByGraduationYear(int candidateId);
}