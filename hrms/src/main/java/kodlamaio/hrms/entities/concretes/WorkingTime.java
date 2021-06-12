package kodlamaio.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="working_times")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkingTime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) 
	@Column(name="working_time_id")
	private int id;
	
	@Column(name="working_time_name")
	private String workingTimeName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "workingTime")
	private List<JobAdvertisement> jobAdvertisements;
}
