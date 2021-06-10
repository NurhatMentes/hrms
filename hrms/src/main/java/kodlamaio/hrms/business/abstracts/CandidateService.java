package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.dtos.CandidateResumeDto;

public interface CandidateService {
	DataResult<List<Candidate>> getAll();
	DataResult<Candidate> getById(int id);
	DataResult<CandidateResumeDto> getCandidateWithCv(int candidateId);
	Result add(Candidate candidate, User user);
}
