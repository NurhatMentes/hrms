package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateEducation;

public interface CandidateEducationService {
	Result add(CandidateEducation candidateEducation);

	DataResult<List<CandidateEducation>> getAll();

	DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByGraduationYear(int candidateId);
}
