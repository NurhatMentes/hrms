package kodlamaio.hrms.core.utilities.adapter.abstracts;

public interface UserCheckService {
	boolean validate(String nationalIdentity, String name, String surname);
}
