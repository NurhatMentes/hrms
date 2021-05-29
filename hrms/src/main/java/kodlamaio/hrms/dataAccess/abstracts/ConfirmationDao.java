package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entitites.concretes.Confirmation;

public interface ConfirmationDao extends JpaRepository<Confirmation, Integer>{

}
