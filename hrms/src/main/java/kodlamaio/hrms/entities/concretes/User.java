package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY ) 
	@Column(name="id")
	private int id;
	
	@Column(name="candidate_id")
	private int candidateId;
	
	@Column(name="employers_id")
	private int employersId;
	
	@Column(name="system_employees_id")
	private int systemEmployeesId;
	
	
    @Email
	@Column(name="email")
	private String email;
	
	@NotBlank(message = "Parola boş olamaz.")
	@Column(name="password")
	private String password;
	
	@NotBlank(message = "Parola kontrolü boş olamaz.")
	@Column(name="passwordAgain")
	private String passwordAgain;
}
