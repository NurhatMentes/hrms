package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Mernis;

public interface MernisDao extends JpaRepository<Mernis, Integer>{

}
