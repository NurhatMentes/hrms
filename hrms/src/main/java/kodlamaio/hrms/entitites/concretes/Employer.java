package kodlamaio.hrms.entitites.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "employers")
@AllArgsConstructor
@NoArgsConstructor
public class Employer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "job_id")
	private int jobId;

	@Column(name = "company_name")
	private String companyName;

	@NotBlank(message = "Şirket web adresi boş olamaz.")
	@Pattern(regexp = "[a-zA-Z0-9]?[a-zA-Z0-9-]+[a-zA-Z0-9]\\.[a-zA-Z0-9]+",
	         message = "Yanlış web adresi biçimi. company.com gibi olmalı")
	@Column(name = "web_adress")
	private String webAdress;

	@Size(min = 10, max = 10, message = "Telefon numarası uzunluğu 10 karakter olmalıdır. Örneğin 53xxxxxxxx")
    @Pattern(regexp = "(^[1-9][0-9]*$)|(^\\d{10}$)", message = "Telefon 0 ile başlayamaz veya metin içeremez.")
	@Column(name = "tel_number")
	private String phone;

}
