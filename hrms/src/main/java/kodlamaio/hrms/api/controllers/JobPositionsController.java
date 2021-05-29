package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitites.concretes.JobPosition;

@RestController
@RequestMapping("/api/jobpositions")
public class JobPositionsController {
	
	private JobPositionService service;

	@Autowired
	public JobPositionsController(JobPositionService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPosition>> getAll(){
		return service.getAll();
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody JobPosition jobPosition) {
		return this.service.add(jobPosition);
	}
}
