package kodlamaio.hrms.entitites.concretes;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="job_seekers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) 
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="birth_date")
	private Date birthDate;
	
	@Size(min = 11, max = 11, message = "TC kimlik uzunluğu 11 olmalıdır.")
    @Pattern(regexp = "(^[1-9][0-9]*$)|(^\\d{10}$)", message = "TC kimlik 0 ile başlayamaz veya metin içeremez.")
	@Column(name="national_id")
	private String nationalId;	
}
