package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.StaffPosition;

public interface StaffPositionDao extends JpaRepository<StaffPosition, Integer>{

}
