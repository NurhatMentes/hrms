package kodlamaio.hrms.core.utilities.adapter.concretes;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapter.abstracts.ConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmationDao;
import kodlamaio.hrms.entitites.concretes.Confirmation;

@Service
public class ConfirmationAdapter implements ConfirmationService{
	
	private ConfirmationDao dao;

	public ConfirmationAdapter(ConfirmationDao dao) {
		super();
		this.dao = dao;
	}
	
	@Override
	public boolean isConfirmed(Confirmation confirmation) {
		LocalDateTime firstDate = LocalDateTime.now();
		LocalDateTime endDate = firstDate.plus(Period.ofDays(1));
		LocalDateTime today = LocalDateTime.now();
		
		if(today.getHour() >= endDate.getHour() && confirmation.isIsConfirmation()==false) {
			confirmation.setIsConfirmation(true);
			return true;
		}
		return false;
	}

	@Override
	public DataResult<List<Confirmation>> getAll() {
		return new SuccessDataResult<List<Confirmation>>(dao.findAll());
	}

}
