package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employer;
import kodlamaio.hrms.entities.concretes.User;

@RestController
@RequestMapping("/api/employers")
public class EmployersController {

	private EmployerService service;

	@Autowired
	public EmployersController(EmployerService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employer>> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/register")
	public Result add(@Valid @RequestBody Employer employer, @Valid User user) {
		return this.service.add(employer, user);
	}
}
