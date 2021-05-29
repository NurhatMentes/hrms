package kodlamaio.hrms.core.utilities.adapter.abstracts;

public interface EmailService {
	void sendMail(String email, String message);
	boolean verify(String email, String verificationCode, String otherVerificationCode);
}
