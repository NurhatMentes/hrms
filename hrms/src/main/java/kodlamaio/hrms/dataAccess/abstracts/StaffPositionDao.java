package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entitites.concretes.StaffPosition;

public interface StaffPositionDao extends JpaRepository<StaffPosition, Integer>{

}
