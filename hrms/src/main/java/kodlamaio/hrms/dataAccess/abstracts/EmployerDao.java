package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entitites.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer> {

}
