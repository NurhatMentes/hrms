package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MernisService;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service	
public class MernisManager implements MernisService{

	@Override
	public boolean isMernis(Candidate candidate) {
		
		return false;
	}

}
