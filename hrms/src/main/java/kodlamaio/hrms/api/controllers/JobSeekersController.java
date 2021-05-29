package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitites.concretes.JobSeeker;
import kodlamaio.hrms.entitites.concretes.User;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
	
	private JobSeekerService service;

	@Autowired
	public JobSeekersController(JobSeekerService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeeker>> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/register")
	public Result add(@Valid @RequestBody JobSeeker jobSeeker,@Valid User user) {
		return this.service.add(jobSeeker, user);
	}
}
