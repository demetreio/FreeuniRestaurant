package ge.edu.freeuni.restaurant.logic;

import java.util.Calendar;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

class MyThread extends Thread{		
	private Date time;
	private String userName;
	private String emailAddress;
	public MyThread(Date time, String userName, String emailAddress){
		this.time=time;
		this.userName=userName;
		this.emailAddress=emailAddress;
	}
	
	@Override
	public void run(){
		try {
			long wait = time.getTime();
			System.out.println(wait);
			long asd = wait - Calendar.getInstance().getTimeInMillis();
			this.sleep(asd);
			MailSender.sendRemainderMail(time, userName, emailAddress);
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
	
	
}