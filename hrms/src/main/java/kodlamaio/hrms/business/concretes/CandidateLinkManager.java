package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateLinkService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateLinkDao;
import kodlamaio.hrms.entities.concretes.CandidateLink;

@Service
public class CandidateLinkManager implements CandidateLinkService {

    private CandidateLinkDao candidateLinkDao;

    @Autowired
    public CandidateLinkManager(CandidateLinkDao candidateLinkDao) {
        this.candidateLinkDao = candidateLinkDao;
    }

	@Override
	public Result add(CandidateLink candidateLink) {
        this.candidateLinkDao.save(candidateLink);
        return new SuccessResult();
	}

	@Override
	public DataResult<List<CandidateLink>> getAll() {
		 return new SuccessDataResult<List<CandidateLink>>(this.candidateLinkDao.findAll());
	}

	@Override
	public DataResult<List<CandidateLink>> getAllByCandidateId(int candidateId) {
		return new SuccessDataResult<List<CandidateLink>>(this.candidateLinkDao.getAllByCandidateId(candidateId));
	}

}
