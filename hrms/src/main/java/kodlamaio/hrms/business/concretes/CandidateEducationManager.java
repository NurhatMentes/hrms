package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Constants.Messages;
import kodlamaio.hrms.business.abstracts.CandidateEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateEducationDao;
import kodlamaio.hrms.entities.concretes.CandidateEducation;

@Service
public class CandidateEducationManager implements CandidateEducationService {
	private CandidateEducationDao candidateEducationDao;

	@Autowired
	public CandidateEducationManager(CandidateEducationDao candidateEducationDao) {
		this.candidateEducationDao = candidateEducationDao;
	}

	@Override
	public Result add(CandidateEducation candidateEducation) {
		this.candidateEducationDao.save(candidateEducation);
		return new SuccessResult(Messages.candidateEducationAdd);
	}

	@Override
	public DataResult<List<CandidateEducation>> getAll() {
		return new SuccessDataResult<List<CandidateEducation>>(this.candidateEducationDao.findAll());
	}

	@Override
	public DataResult<List<CandidateEducation>> getAllByCandidateIdOrderByGraduationYear(int candidateId) {
		return new SuccessDataResult<List<CandidateEducation>>(this.getAllByCandidateIdOrderByGraduationYear(candidateId).getData());
	}
}
