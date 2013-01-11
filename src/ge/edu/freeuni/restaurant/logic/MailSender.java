package ge.edu.freeuni.restaurant.logic;
import java.util.Date;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.*;
import com.sun.xml.internal.fastinfoset.sax.Properties;

public class MailSender {

	private static  String host = "smtp.gmail.com";
	private static  String from = "freeunirestaurant@gmail.com";
	private static  String pass = "sdp123456";

	
	public static synchronized void sendRemainderMail(Date time, String userName, String emailAddress) throws AddressException, MessagingException, InterruptedException{
		
		  java.util.Properties props = System.getProperties();
		    props.put("mail.smtp.starttls.enable", "true"); // added this line
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.user", from);
		    props.put("mail.smtp.password", pass);
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");

		    String[] to = {emailAddress}; // added this line

		    Session session = Session.getDefaultInstance(props, null);
		    MimeMessage message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(from));

		    InternetAddress[] toAddress = new InternetAddress[to.length];

		    // To get the array of addresses
		    for( int i=0; i < to.length; i++ ) { // changed from a while loop
		        toAddress[i] = new InternetAddress(to[i]);
		    }
		    System.out.println(Message.RecipientType.TO);

		    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
		        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		    }
		    message.setSubject("Reminder about reservation");
		    message.setText("Hello "+userName+", we are glad to remind you, that you " +
		    		"have reserved a table in our" +
		    		" Restaurant for Today, please don't be late");
		    Date date=new Date(System.currentTimeMillis()+1000000);		    
		    message.setSentDate(date);//es ar mushaobs
		    Transport transport = session.getTransport("smtp");
		    transport.connect(host, from, pass);
		    transport.sendMessage(message, message.getAllRecipients());
		    transport.close();			
	}
	
	
	public static synchronized void sendConfirmationrMail(String userName, String emailAddress) throws AddressException, MessagingException, InterruptedException{
		
		  java.util.Properties props = System.getProperties();
		    props.put("mail.smtp.starttls.enable", "true"); // added this line
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.user", from);
		    props.put("mail.smtp.password", pass);
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");

		    String[] to = {emailAddress}; // added this line

		    Session session = Session.getDefaultInstance(props, null);
		    MimeMessage message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(from));

		    InternetAddress[] toAddress = new InternetAddress[to.length];

		    // To get the array of addresses
		    for( int i=0; i < to.length; i++ ) { // changed from a while loop
		        toAddress[i] = new InternetAddress(to[i]);
		    }
		    System.out.println(Message.RecipientType.TO);

		    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
		        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		    }
		    message.setSubject("Reminder about reservation");
		    message.setText("Hello "+userName+", we are glad to inform you, that you " +
		    		"have reserved a table in our" +
		    		" Restaurant.");	    
		    Transport transport = session.getTransport("smtp");
		    transport.connect(host, from, pass);
		    transport.sendMessage(message, message.getAllRecipients());
		    transport.close();			
	}
	

}


class MyThread extends Thread{	
	
	private final  String host = "smtp.gmail.com";
	private final  String from = "freeunirestaurant@gmail.com";
	private final  String pass = "sdp123456";
	
	private Date time;
	private String userName;
	private String emailAddress;
	//es klasi imistvisaa rom vinc dawer sredebi gaixsenot, gadaxedet da washalet mere
	public MyThread(Date time, String userName, String emailAddress){
		this.time=time;
		this.userName=userName;
		this.emailAddress=emailAddress;
	}
	
	@Override
	public void run(){
		try {
			sendMail();
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void sendMail() throws InterruptedException, AddressException, MessagingException{
		
			Thread.sleep(time.getTime()-System.currentTimeMillis());
		    java.util.Properties props = System.getProperties();
		    props.put("mail.smtp.starttls.enable", "true"); // added this line
		    props.put("mail.smtp.host", host);
		    props.put("mail.smtp.user", from);
		    props.put("mail.smtp.password", pass);
		    props.put("mail.smtp.port", "587");
		    props.put("mail.smtp.auth", "true");

		    String[] to = {emailAddress}; // added this line

		    Session session = Session.getDefaultInstance(props, null);
		    MimeMessage message = new MimeMessage(session);
		    message.setFrom(new InternetAddress(from));

		    InternetAddress[] toAddress = new InternetAddress[to.length];

		    // To get the array of addresses
		    for( int i=0; i < to.length; i++ ) { // changed from a while loop
		        toAddress[i] = new InternetAddress(to[i]);
		    }
		    System.out.println(Message.RecipientType.TO);

		    for( int i=0; i < toAddress.length; i++) { // changed from a while loop
		        message.addRecipient(Message.RecipientType.TO, toAddress[i]);
		    }
		    message.setSubject("Reminder about reservation");
		    message.setText("Hello "+userName+", we are glad to remind you, that you " +
		    		"have reserved a table in our" +
		    		" Restaurant for Today, please don't be late");
		    Date date=new Date(System.currentTimeMillis()+1000000);
		    Thread t=new Thread();
		    
		    message.setSentDate(date);
		    Transport transport = session.getTransport("smtp");
		    transport.connect(host, from, pass);
		    transport.sendMessage(message, message.getAllRecipients());
		    transport.close();	
	}
}

