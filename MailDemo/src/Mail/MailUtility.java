package Mail;

import java.io.FileInputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtility {

	public static void toAddAttachment(MimeMessage mail, String filePath, String fileName) {
		try 
		{
			Multipart multiPart = new MimeMultipart();
			MimeBodyPart bp = new MimeBodyPart();
			DataSource ds = new FileDataSource("./devi2.png");
			bp.setDataHandler(new DataHandler(ds));
			bp.setFileName("Indian Flag");
			multiPart.addBodyPart(bp);
			mail.setContent(multiPart);
		}
		
		catch(Exception e) 
		{
			
		}
	}
	
	public static void sendMail() {
		try 
	{
		Properties p = new Properties();
		p.load(new FileInputStream("./settings.properties"));
		Session session = Session.getInstance(p, new EmailConfigurations());
		MimeMessage mail = new MimeMessage(session);
		InternetAddress to = new InternetAddress("jkanikaram@gmail.com");
		mail.addRecipient(RecipientType.TO, to);
		mail.setSubject("sending from code");
		mail.setText("this mail is send from java code");
		toAddAttachment(mail, "./", "");
		
	}
		catch(Exception e) {
			
		}
	}
}
