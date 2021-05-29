package kodlamaio.hrms.business.concretes;

import java.util.UUID;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitites.concretes.User;
import kodlamaio.hrms.entitites.concretes.VerificationCode;
@Service
public class VerificationCodeManager implements VerificationCodeService{

	@Override
	public VerificationCode add(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<VerificationCode> findByUserUuid(UUID uuid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(VerificationCode code, String verificationCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
