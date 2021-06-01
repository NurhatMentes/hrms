package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Confirmation;

public interface ConfirmationDao extends JpaRepository<Confirmation, Integer>{

}
