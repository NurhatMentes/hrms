package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.Constants.Messages;
import kodlamaio.hrms.business.abstracts.ConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmationDao;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Confirmation;
import kodlamaio.hrms.entities.concretes.Employer;


@Service
public class ConfirmationManager implements ConfirmationService{
	
	private ConfirmationDao dao;

	public ConfirmationManager(ConfirmationDao dao) {
		super();
		this.dao = dao;
	}

	boolean bool = false;
	@Override
	public boolean isConfirmed(Boolean booltype) {
		LocalDateTime firstDate = LocalDateTime.now();
		LocalDateTime endDate = firstDate.plus(Period.ofDays(30));
		LocalDateTime today = LocalDateTime.now();
		
		if(today.getHour() >= endDate.getHour() && booltype==false) {
			
			return bool=true;
		}
		return false;
	}

	@Override
	public DataResult<List<Confirmation>> getAll() {
		return new SuccessDataResult<List<Confirmation>>(dao.findAll());
	}

	@Override
	public Result add(Confirmation confirmation) {	
		dao.save(confirmation);
		return new SuccessResult(Messages.employerConfirmed);
	}

}
