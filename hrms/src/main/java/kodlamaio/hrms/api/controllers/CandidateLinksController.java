package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateLinkService;
import kodlamaio.hrms.entities.concretes.CandidateLink;

@RestController
@RequestMapping("/api/candidatelinks")
public class CandidateLinksController {
	 private CandidateLinkService service;

	    @Autowired
	    public CandidateLinksController(CandidateLinkService service) {
	        this.service = service;
	    }

	    @PostMapping("/add")
	    public ResponseEntity<?> add(@RequestBody CandidateLink candidateLink){
	        return ResponseEntity.ok(this.service.add(candidateLink));
	    }


	    @GetMapping("/getall")
	    public ResponseEntity<?> getAll(){
	        return ResponseEntity.ok(this.service.getAll());
	    }
}
