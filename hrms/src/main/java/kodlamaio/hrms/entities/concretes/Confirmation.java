package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "confirmation")
@AllArgsConstructor
@NoArgsConstructor
public class Confirmation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "employees_id")
	private int EmployeesId;
	
	@Column(name = "employer_id")
	private int EmployerId;
	
	@Column(name = "is_confirmation")
	private boolean IsConfirmation;
	
	@Column(name="date")
	private Date Date;
}
