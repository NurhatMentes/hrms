package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entitites.concretes.User;

public interface UserDao extends JpaRepository<User, Integer>{
	 boolean existsByEmail(String email);
}
