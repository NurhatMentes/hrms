package kodlamaio.hrms.business.abstracts;

import java.util.UUID;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationCodeService {
	    VerificationCode add(User user);
	    DataResult<VerificationCode> findByUserUuid(UUID uuid);
	    Result update(VerificationCode code, String verificationCode);
}
