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
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CandidateImageService;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateImage;

@CrossOrigin
@RestController
@RequestMapping("/api/candidateimages")
public class CandidateImagesController {

    private CandidateImageService service;

    @Autowired
    public CandidateImagesController(CandidateImageService service) {
        this.service = service;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<?> add(@RequestBody MultipartFile file,@RequestParam int candidateId) {
        CandidateImage candidateImage = new CandidateImage();
        Candidate candidate = new Candidate();
        candidate.setId(candidateId);
        candidateImage.setCandidate(candidate);
        return ResponseEntity.ok(this.service.add(candidateImage,file));
    }


    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.service.getAll());
    }
}
