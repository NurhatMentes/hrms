package kodlamaio.hrms.entities.dtos;

import java.util.List;


import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CandidateEducation;
import kodlamaio.hrms.entities.concretes.CandidateExperience;
import kodlamaio.hrms.entities.concretes.CandidateImage;
import kodlamaio.hrms.entities.concretes.CandidateLanguage;
import kodlamaio.hrms.entities.concretes.CandidateLink;
import kodlamaio.hrms.entities.concretes.CandidateSkill;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateResumeDto {
    private Candidate candidate;
    private List<CandidateEducation> candidateEducation;
    private List<CandidateExperience> candidateExperiences;
    private List<CandidateImage> candidateImage;
    private List<CandidateLanguage> candidateLanguage;
    private List<CandidateLink> candidateLink;
    private List<CandidateSkill> candidateSkill;
}
