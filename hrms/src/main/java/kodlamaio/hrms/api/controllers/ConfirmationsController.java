package kodlamaio.hrms.api.controllers;

import java.util.List;

import javax.persistence.PostUpdate;
import javax.validation.Valid;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ConfirmationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Confirmation;


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

	@PostUpdate()
	@PostMapping("/confirmed")
	public Result isConfirmed(@Valid @RequestBody Confirmation confirmation) {
		return this.service.add(confirmation);
	}
	
}
