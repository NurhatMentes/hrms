package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Constants.Messages;
import kodlamaio.hrms.business.abstracts.CandidateSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateSkillDao;
import kodlamaio.hrms.entities.concretes.CandidateSkill;

@Service
public class CandidateSkillManager implements CandidateSkillService {

    private CandidateSkillDao candidateSkillDao;

    @Autowired
    public CandidateSkillManager(CandidateSkillDao candidateSkillDao) {
        this.candidateSkillDao = candidateSkillDao;
    }

	@Override
	public Result add(CandidateSkill candidateSkill) {
		this.candidateSkillDao.save(candidateSkill);
        return new SuccessResult(Messages.candidateSkillAdd);
	}

	@Override
	public DataResult<List<CandidateSkill>> getAll() {
		return new SuccessDataResult<List<CandidateSkill>>(this.candidateSkillDao.findAll());
	}

	@Override
	public DataResult<List<CandidateSkill>> getAllByCandidateId(int candidateId) {
		 return new SuccessDataResult<List<CandidateSkill>>(this.candidateSkillDao.getAllByCandidateId(candidateId));
	}

}
