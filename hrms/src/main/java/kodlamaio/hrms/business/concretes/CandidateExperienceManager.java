package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Constants.Messages;
import kodlamaio.hrms.business.abstracts.CandidateExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateExperienceDao;
import kodlamaio.hrms.entities.concretes.CandidateExperience;

@Service
public class CandidateExperienceManager implements CandidateExperienceService{
	private CandidateExperienceDao experienceDao;

	@Autowired
	public CandidateExperienceManager(CandidateExperienceDao experienceDao) {
		this.experienceDao = experienceDao;
	}

	@Override
	public Result add(CandidateExperience candidateExperience) {
		this.experienceDao.save(candidateExperience);
		return new SuccessResult(Messages.candidateExperienceAdd);
	}

	@Override
	public DataResult<List<CandidateExperience>> getAll() {
		return new SuccessDataResult<List<CandidateExperience>>(this.experienceDao.findAll());
	}

	@Override
	public DataResult<List<CandidateExperience>> getAllByCandidateIdOrderByLeaveDate(int candidateId) {
		return new SuccessDataResult<List<CandidateExperience>>(this.getAllByCandidateIdOrderByLeaveDate(candidateId).getData());
	}
}
