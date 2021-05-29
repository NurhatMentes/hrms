package kodlamaio.hrms.core.utilities.ExternalServices.email;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class FakeMailSender {
	public void sendMail(String email, String message) {
		new SuccessResult("Mail gönderilmiştir: "+ email + "\n" + message);
	}
	
	public boolean verifyMail(String email, String verificationCode, String otherVerificationCode) {
		if(verificationCode.equals(otherVerificationCode)) {
			new SuccessDataResult<>(email,"Doğrulama Başarılır");
			return true;
		}else {
			new ErrorResult("Doğrulama başarısız");
			return false;
		}
	}
}
