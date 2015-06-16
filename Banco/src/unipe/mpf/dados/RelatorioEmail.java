package unipe.mpf.dados;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import unipe.mpf.dados.exceptions.RelatorioNaoCriadoException;

public class RelatorioEmail implements IRelatorio{
	File file;
	String to;
	public RelatorioEmail(File file, String to){
		this.file = file;
		this.to = to;
	}
	
	public void enviar() throws RelatorioNaoCriadoException{
		final Properties propBanco = new Properties();
		
		try {
			propBanco.load(new FileInputStream("src/unipe/mpf/resources/email.properties"));
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	    String host = "relay.jangosmtp.net";
	      
	    //String host = "smtp.gmail.com";

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", host);
	    props.put("mail.smtp.port", "587");

	    Session session = Session.getInstance(props,
	    		new javax.mail.Authenticator() {
	    	@Override
			protected PasswordAuthentication getPasswordAuthentication() {
	    		return new PasswordAuthentication(propBanco.getProperty("user"), propBanco.getProperty("password"));
	    	}
	    });

	    try {
	    	Message message = new MimeMessage(session);
	    	message.setFrom(new InternetAddress(propBanco.getProperty("email")));
	    	message.setRecipients(Message.RecipientType.TO,
	    			InternetAddress.parse(to));
	    	message.setSubject("Relatorio Midas");

	    	BodyPart messageBodyPart = new MimeBodyPart();
	    	messageBodyPart.setText("Envio do Relatorio: "+file.getName());

	    	Multipart multipart = new MimeMultipart();
	    	multipart.addBodyPart(messageBodyPart);

	    	messageBodyPart = new MimeBodyPart();
	    	String filename = file.getAbsolutePath();
	    	DataSource source = new FileDataSource(filename);
	    	messageBodyPart.setDataHandler(new DataHandler(source));
	    	messageBodyPart.setFileName(file.getName());
	    	multipart.addBodyPart(messageBodyPart);

	    	message.setContent(multipart);
	    	Transport.send(message);

	    } catch (MessagingException e) {
			throw new RelatorioNaoCriadoException("Não foi possivel enviar o email!");
		}
	}
	
}
