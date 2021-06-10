package kodlamaio.hrms.business.concretes;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Constants.Messages;
import kodlamaio.hrms.business.abstracts.CandidateEducationService;
import kodlamaio.hrms.business.abstracts.CandidateExperienceService;
import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.business.abstracts.CandidateLanguageService;
import kodlamaio.hrms.business.abstracts.CandidateLinkService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CandidateSkillService;
import kodlamaio.hrms.business.abstracts.MernisService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.adapter.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.resultChecker.ResultChecker;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;
import kodlamaio.hrms.entities.dtos.CandidateResumeDto;

@Service
public class CandidateManager implements CandidateService {
	
	private CandidateDao candidateDao;
	private UserDao userDao;
    private EmailService emailService;
	private VerificationCodeService verificationCodeService;
	private CandidateEducationService candidateEducationDao;
	private CandidateExperienceService candidateExperienceDao;
	private CandidateImageService candidateImageDao;
	private CandidateLanguageService candidateLanguageDao;
	private CandidateLinkService candidateLinkDao;
	private CandidateSkillService candidateSkillServiceDao;

	@Autowired
	public CandidateManager(CandidateDao candidateDao, MernisService mernisService, UserDao userDao, 
            EmailService emailService,
            VerificationCodeService verificationCodeService, CandidateEducationService candidateEducationDao, 
            CandidateExperienceService candidateExperienceDao, CandidateImageService candidateImageDao,
            CandidateLanguageService candidateLanguageDao, 
            CandidateLinkService candidateLinkDao, CandidateSkillService candidateSkillServiceDao) {
		super();
		this.candidateDao = candidateDao;	
		this.userDao=userDao;
        this.emailService = emailService;
        this.verificationCodeService = verificationCodeService;
        this.candidateEducationDao = candidateEducationDao;
        this.candidateExperienceDao = candidateExperienceDao;
        this.candidateImageDao = candidateImageDao;
        this.candidateLanguageDao = candidateLanguageDao;
        this.candidateLinkDao = candidateLinkDao;
        this.candidateSkillServiceDao = candidateSkillServiceDao;
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(), Messages.jobSeekerGetAll);
	}
	
	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.findById(id).get());
	}

	@Override
	public DataResult<CandidateResumeDto> getCandidateWithCv(int candidateId) {
		CandidateResumeDto candidateResumeDto =new CandidateResumeDto();
		candidateResumeDto.setCandidate(this.getById(candidateId).getData());
		candidateResumeDto.setCandidateEducation(this.candidateEducationDao.getAllByCandidateIdOrderByGraduationYear(candidateId).getData());
		candidateResumeDto.setCandidateExperiences(this.candidateExperienceDao.getAllByCandidateIdOrderByLeaveDate(candidateId).getData());
		candidateResumeDto.setCandidateImage(this.candidateImageDao.getAllByCandidateId(candidateId).getData());
		candidateResumeDto.setCandidateLanguage(this.candidateLanguageDao.getAllByCandidateId(candidateId).getData());
		candidateResumeDto.setCandidateLink(this.candidateLinkDao.getAllByCandidateId(candidateId).getData());
        candidateResumeDto.setCandidateSkill(this.candidateSkillServiceDao.getAllByCandidateId(candidateId).getData());
        return new SuccessDataResult<CandidateResumeDto>(candidateResumeDto);
	}
  

	@Override
	public Result add(Candidate candidate, User user) {
		
		 Result result = ResultChecker.check(Arrays.asList(
	                checkIfEmailExists(user.getEmail()),
	                checkIfPasswordsMatch(user.getPassword(), user.getPasswordAgain()),
	                nullAndEmptyField(candidate,user),
	                checkIfTcNO(candidate)
	        ));

	        if(result.isSuccess()){
	        	this.candidateDao.save(candidate);
	    		this.userDao.save(user);
	    		return new SuccessResult(
	    				candidate.getFirstName() + " " + candidate.getLastName() + " " + Messages.add);
	        } else {
	            return new ErrorResult(result.getMessage());
	        }
	}

	
	
	
	
	
	
	// ********************Business rules***********************

	
	 private VerificationCode addVerificationCode(User user){
	        return verificationCodeService.add(user);
	    }

	    private void sendMail(String email, String message){
	        emailService.sendMail(email, message);
	    }
	    
	    private Result checkIfTcNO(Candidate candidate) {
	    	if(candidate.getNationalId().length()!=11) {
	    	    return new ErrorResult(Messages.tcNoCheck);
	    	}
	    	return new SuccessResult();
	    }

	    private Result checkIfEmailExists(String email){
	        if(userDao.existsByEmail(email)){
	            return new ErrorResult(
	                    "Bu e-posta zaten alınmış."
	            );
	        } else {
	            return new SuccessResult();
	        }
	    }

	    private Result checkIfPasswordsMatch(String password, String passwordCheck){
	        if(!password.equals(passwordCheck)) {
	            return new ErrorResult(
	                    "Şifreler eşleşmedi."
	            );
	        } else {
	            return new SuccessResult();
	        }
	    }
	
	    private Result nullAndEmptyField(Candidate candidate, User user) { 
		  if(candidate.getFirstName().isEmpty() || candidate.getLastName().isEmpty() ||
				  candidate.getNationalId().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty() ||
	  user.getPasswordAgain().isEmpty()) {
			  return new ErrorResult("X Alanlar boş geçilemez"); 
			  } else { 
				  return new SuccessResult(); 
				  }
	  }
}
