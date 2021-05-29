package kodlamaio.hrms.core.adapter.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.adapter.abstracts.EmailService;
import kodlamaio.hrms.core.utilities.ExternalServices.email.FakeMailSender;
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
