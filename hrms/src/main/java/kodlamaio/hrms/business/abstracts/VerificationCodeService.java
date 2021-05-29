package kodlamaio.hrms.business.abstracts;

import java.util.UUID;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitites.concretes.User;
import kodlamaio.hrms.entitites.concretes.VerificationCode;

public interface VerificationCodeService {
	    VerificationCode add(User user);
	    DataResult<VerificationCode> findByUserUuid(UUID uuid);
	    Result update(VerificationCode code, String verificationCode);
}
