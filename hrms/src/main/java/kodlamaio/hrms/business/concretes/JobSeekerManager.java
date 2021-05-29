package kodlamaio.hrms.business.concretes;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Constants.Messages;
import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.MernisService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.adapter.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.resultChecker.ResultChecker;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entitites.concretes.JobSeeker;
import kodlamaio.hrms.entitites.concretes.User;
import kodlamaio.hrms.entitites.concretes.VerificationCode;

@Service
public class JobSeekerManager implements JobSeekerService {
	
	private JobSeekerDao jobSeekerDao;
	private UserDao userDao;
    private EmailService emailService;
	private VerificationCodeService verificationCodeService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, MernisService mernisService, UserDao userDao, 
            EmailService emailService,
            VerificationCodeService verificationCodeService) {
		super();
		this.jobSeekerDao = jobSeekerDao;	
		this.userDao=userDao;
        this.emailService = emailService;
        this.verificationCodeService = verificationCodeService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), Messages.jobSeekerGetAll);
	}

	@Override
	public Result add(JobSeeker jobSeeker, User user) {
		
		 Result result = ResultChecker.check(Arrays.asList(
	                checkIfEmailExists(user.getEmail()),
	                checkIfPasswordsMatch(user.getPassword(), user.getPasswordAgain()),
	                nullAndEmptyField(jobSeeker,user),
	                checkIfTcNO(jobSeeker)
	        ));

	        if(result.isSuccess()){
	        	this.jobSeekerDao.save(jobSeeker);
	    		this.userDao.save(user);
	    		return new SuccessResult(
	    				jobSeeker.getFirstName() + " " + jobSeeker.getLastName() + " " + Messages.add);
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
	    
	    private Result checkIfTcNO(JobSeeker jobSeeker) {
	    	if(jobSeeker.getNationalId().length()!=11) {
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
	
	    private Result nullAndEmptyField(JobSeeker jobSeeker, User user) { 
		  if(jobSeeker.getFirstName().isEmpty() || jobSeeker.getLastName().isEmpty() ||
	  jobSeeker.getNationalId().isEmpty() || user.getEmail().isEmpty() || user.getPassword().isEmpty() ||
	  user.getPasswordAgain().isEmpty()) {
			  return new ErrorResult("X Alanlar boş geçilemez"); 
			  } else { 
				  return new SuccessResult(); 
				  }
	  }
	  
	 

}
