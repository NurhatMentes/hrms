package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.core.utilities.adapter.abstracts.ConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entitites.concretes.Confirmation;
import kodlamaio.hrms.entitites.concretes.Employer;
import kodlamaio.hrms.entitites.concretes.User;

@RestController
@RequestMapping("/api/confirmations")
public class ConfirmationsController {
	private ConfirmationService service;

	@Autowired
	public ConfirmationsController(ConfirmationService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/getall")
	public DataResult<List<Confirmation>> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/confirmed")
	public boolean isConfirmed(@Valid @RequestBody Confirmation confirmation) {
		return this.service.isConfirmed(confirmation);
	}
}
