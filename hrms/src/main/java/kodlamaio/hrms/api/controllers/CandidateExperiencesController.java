package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateExperienceService;
import kodlamaio.hrms.entities.concretes.CandidateExperience;
@CrossOrigin
@RestController
@RequestMapping("/api/candidateexperiences")
public class CandidateExperiencesController {
	private CandidateExperienceService service;

    @Autowired
    public CandidateExperiencesController(CandidateExperienceService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) CandidateExperience candidateExperience){
        return ResponseEntity.ok(this.service.add(candidateExperience));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }

    @GetMapping("/getallbycandidateidorderbyleavedate")
    public ResponseEntity<?> getAllOrderByLeaveDate(@RequestParam int candidateId){
        return ResponseEntity.ok(this.service.getAllByCandidateIdOrderByLeaveDate(candidateId));
    }

}
