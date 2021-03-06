package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;

public interface CandidateLanguageService {
	Result add(CandidateLanguage candidateLanguage);
    DataResult<List<CandidateLanguage>> getAll();
    DataResult<List<CandidateLanguage>> getAllByCandidateId(int candidateId);
}
