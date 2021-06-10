package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLink;

public interface CandidateLinkService {
	Result add(CandidateLink candidateLink);

	DataResult<List<CandidateLink>> getAll();

	DataResult<List<CandidateLink>> getAllByCandidateId(int candidateId);
}
