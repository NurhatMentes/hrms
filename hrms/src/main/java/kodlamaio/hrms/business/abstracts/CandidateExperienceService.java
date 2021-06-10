package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateExperience;

public interface CandidateExperienceService {
	Result add(CandidateExperience candidateExperience);
    DataResult<List<CandidateExperience>> getAll();
    DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDate(int candidateId);
}
