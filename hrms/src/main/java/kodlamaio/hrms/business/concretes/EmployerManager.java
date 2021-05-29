package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.Constants.Messages;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.adapter.abstracts.ConfirmationService;
import kodlamaio.hrms.core.utilities.resultChecker.ResultChecker;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmationDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entitites.concretes.Confirmation;
import kodlamaio.hrms.entitites.concretes.Employer;
import kodlamaio.hrms.entitites.concretes.User;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employerDao;
	private UserDao userDao;
	private ConfirmationDao confirmationDao;
	private ConfirmationService confirmationSerivce;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao, UserDao userDao, 
			ConfirmationDao confirmationDao, ConfirmationService confirmationSerivce) {
		super();
		this.employerDao = employerDao;
		this.userDao = userDao;
		this.confirmationDao = confirmationDao;
		this.confirmationSerivce=confirmationSerivce;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(), Messages.employerGetall);
	}

	@Override
	public Result add(Employer employer, User user, Confirmation confirmation) { 
		Result result = ResultChecker.check(Arrays.asList(
				checkIfEmail(employer, user),
				nullAndEmptyField(employer, user)));
		
		if(result.isSuccess()) {
		confirmationSerivce.isConfirmed(confirmation);
			
			employerDao.save(employer);	
			userDao.save(user);
			
			
			return new SuccessResult(Messages.employerIsConfirmed);
		}else {
			return new ErrorResult(result.getMessage());
		}
	}
	
	
	
	
	// ********************Business rules***********************
	
	private Result checkIfEmail(Employer employer, User user) {
		
		 String[] domainsWebsite = employer.getWebAdress().split("[.]+");
         String[] domainsMail = user.getEmail().split("[.]+");
         
         if (domainsMail[domainsMail.length - 1].equals(domainsWebsite[domainsWebsite.length - 1])) {
        	 return new SuccessResult();
         }
         return new ErrorResult(Messages.employerDomain);
	}
	
	 private Result nullAndEmptyField(Employer employer, User user) { 
		  if(employer.getCompanyName().isEmpty() || user.getEmail().isEmpty() ||
	  employer.getPhone().isEmpty() || employer.getWebAdress().isEmpty()
	  || user.getEmail().isEmpty() || user.getPassword().isEmpty() ||
	  user.getPasswordAgain().isEmpty()) {
			  return new ErrorResult("X Alanlar boş geçilemez"); 
			  } else { 
				  return new SuccessResult(); 
				  }
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
}
