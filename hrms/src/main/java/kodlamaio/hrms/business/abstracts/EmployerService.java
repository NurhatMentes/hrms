package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitites.concretes.Confirmation;
import kodlamaio.hrms.entitites.concretes.Employer;
import kodlamaio.hrms.entitites.concretes.User;

public interface EmployerService {
	DataResult<List<Employer>> getAll();
	Result add(Employer employer, User user, Confirmation confirmation);
}
