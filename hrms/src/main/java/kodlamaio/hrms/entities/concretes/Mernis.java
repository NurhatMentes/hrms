package kodlamaio.hrms.entities.concretes;

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

@Data
@Entity
@Table(name="mernis")
@AllArgsConstructor
@NoArgsConstructor
public class Mernis {
	
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) 
	@Column(name="id")
	private int id;	
	
	@Size(min = 11, max = 11, message = "TC kimlik uzunluğu 11 olmalıdır.")
    @Pattern(regexp = "(^[1-9][0-9]*$)|(^\\d{10}$)", message = "TC kimlik 0 ile başlayamaz veya metin içeremez.")
	@Column(name="national_id")
	private String nationalId;
	

}
