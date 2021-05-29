package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitites.concretes.Confirmation;

public interface ConfirmationService {
	
	DataResult<List<Confirmation>> getAll();
	Result add(Confirmation confirmation);
	boolean isConfirmed(Boolean booltype);
}
