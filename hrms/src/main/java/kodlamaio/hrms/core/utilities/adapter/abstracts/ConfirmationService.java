package kodlamaio.hrms.core.utilities.adapter.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entitites.concretes.Confirmation;

public interface ConfirmationService {
	
	DataResult<List<Confirmation>> getAll();
	boolean isConfirmed(Confirmation confirmation);
}
