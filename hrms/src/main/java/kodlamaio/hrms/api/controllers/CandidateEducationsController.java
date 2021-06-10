package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateEducationService;
import kodlamaio.hrms.entities.concretes.CandidateEducation;

@CrossOrigin
@RestController
@RequestMapping("/api/candidateeducations")
public class CandidateEducationsController {
	 private CandidateEducationService service;

	    @Autowired
	    public CandidateEducationsController(CandidateEducationService service) {
	        this.service = service;
	    }
	    
	    @PostMapping("/add")
	    public ResponseEntity<?> add(@RequestBody CandidateEducation candidateEducation){
	        return ResponseEntity.ok(this.service.add(candidateEducation));
	    }


	    @GetMapping("/getall")
	    public ResponseEntity<?> getAll(){
	        return ResponseEntity.ok(this.service.getAll());
	    }

	    @GetMapping("/getallbycandidateidorderbygraduationyear")
	    public ResponseEntity<?> getAllByCandidateIdOrderByGraduationYear(@RequestParam int candidateId){
	        return ResponseEntity.ok(this.service.getAllByCandidateIdOrderByGraduationYear(candidateId));
	    }
}
