package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateResumeDto;


public interface CandidateDao extends JpaRepository<Candidate, Integer> {
	@Query(" From Candidate c "
            + "Inner Join c.candidateEducations ce "
            + "Inner join c.candidateExperiences cex"
            + "Inner Join c.candidateLanguages cl"
            + "Inner Join c.candidateLinks cli"
            + "Inner Join c.candidateSkills cs"
            + "Inner Join c.candidateImages ci")
    List<CandidateResumeDto> getCandidateWithCv();

}
