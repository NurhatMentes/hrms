package kodlamaio.hrms.core.utilities.adapter.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.utilities.ExternalServices.email.FakeMailSender;
import kodlamaio.hrms.core.utilities.adapter.abstracts.EmailService;
@Service
public class EmailServiceAdapter implements EmailService{

	@Override
	public void sendMail(String email, String message) {
		FakeMailSender fakeMailSender = new FakeMailSender();
		fakeMailSender.sendMail(email, message);
	}

	@Override
	public boolean verify(String email, String verificationCode, String otherVerificationCode) {
		FakeMailSender fakeMailSender = new FakeMailSender();
		return fakeMailSender.verifyMail(email, verificationCode, otherVerificationCode);
	}

}
