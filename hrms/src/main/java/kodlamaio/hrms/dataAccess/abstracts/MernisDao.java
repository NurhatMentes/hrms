package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entitites.concretes.Mernis;

public interface MernisDao extends JpaRepository<Mernis, Integer>{

}
