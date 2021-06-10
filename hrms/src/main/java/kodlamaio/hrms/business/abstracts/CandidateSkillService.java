package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateSkill;

public interface CandidateSkillService {
	Result add(CandidateSkill candidateSkill);

	DataResult<List<CandidateSkill>> getAll();

	DataResult<List<CandidateSkill>> getAllByCandidateId(int candidateId);
}
