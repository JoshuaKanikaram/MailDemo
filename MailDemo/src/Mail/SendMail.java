package Mail;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

	public static void main(String[] args) throws FileNotFoundException, IOException, MessagingException {
		
		
//		8.Load the property file
		Properties p = new Properties();
		p.load(new FileInputStream("./settings.properties"));

// 		9.Create Session
		Session session = Session.getInstance(p, new EmailConfigurations());

// 		10.Create mail
		MimeMessage mail = new MimeMessage(session);
		
//		11.addReceipent
		InternetAddress to = new InternetAddress("jkanikaram@gmail.com");
		mail.addRecipient(RecipientType.TO, to);
		
//		12.add subject
		mail.setSubject("sending from code");
		
//		13.add body
		mail.setText("this mail is send from java code");
		
//		14.add attachment
		Multipart multiPart = new MimeMultipart();
		MimeBodyPart bp = new MimeBodyPart();
		
		DataSource ds = new FileDataSource("./devi2.png");
		bp.setDataHandler(new DataHandler(ds));
		bp.setFileName("Indian Flag");
		multiPart.addBodyPart(bp);
		mail.setContent(multiPart);
		
//		15.send mail
		Transport.send(mail);
		
		System.out.println("done");
		
	}

}
