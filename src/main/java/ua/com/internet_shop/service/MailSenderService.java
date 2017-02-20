package ua.com.internet_shop.service;

public interface MailSenderService {
	
	void sendMail(String theme, String mailBody, String email);

}
