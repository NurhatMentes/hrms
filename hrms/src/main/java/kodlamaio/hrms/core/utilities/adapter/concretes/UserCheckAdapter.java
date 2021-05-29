package kodlamaio.hrms.core.utilities.adapter.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.adapter.abstracts.UserCheckService;

@Service
public class UserCheckAdapter implements UserCheckService{

	@Override
	public boolean validate(String nationalIdentity, String name, String surname) {
		// TODO Auto-generated method stub
		return true;
	}

}
