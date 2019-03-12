package Mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class EmailConfigurations extends Authenticator{
	
	
	
	@Override
	public PasswordAuthentication getPasswordAuthentication() {
		PasswordAuthentication p = new PasswordAuthentication("jkanikaram", "kjoshua");
		return p;
	}
}

	

