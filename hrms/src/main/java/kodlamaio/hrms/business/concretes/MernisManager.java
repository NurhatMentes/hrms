package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.MernisService;
import kodlamaio.hrms.entitites.concretes.JobSeeker;
@Service	
public class MernisManager implements MernisService{

	@Override
	public boolean isMernis(JobSeeker jobSeeker) {
		
		return false;
	}

}
