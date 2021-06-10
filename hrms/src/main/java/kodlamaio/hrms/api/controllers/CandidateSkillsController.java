package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateSkillService;
import kodlamaio.hrms.entities.concretes.CandidateSkill;
@CrossOrigin
@RestController
@RequestMapping("/api/candidateskills")
public class CandidateSkillsController {
	private CandidateSkillService service;

    @Autowired
    public CandidateSkillsController(CandidateSkillService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody CandidateSkill candidateSkill){
        return ResponseEntity.ok(this.service.add(candidateSkill));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }
}
