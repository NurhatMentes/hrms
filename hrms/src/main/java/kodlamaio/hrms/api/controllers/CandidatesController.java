package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	
	private CandidateService service;

	@Autowired
	public CandidatesController(CandidateService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/register")
	public Result add(@Valid @RequestBody Candidate candidate,@Valid User user) {
		return this.service.add(candidate, user);
	}
}
