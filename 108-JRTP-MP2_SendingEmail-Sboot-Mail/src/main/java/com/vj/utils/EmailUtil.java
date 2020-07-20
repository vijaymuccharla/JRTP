package com.vj.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender javaMailSender;

	/**
	 * https://mkyong.com/spring-boot/spring-boot-how-to-send-email-via-smtp/
	 * @param to
	 * @param subject
	 * @param body
	 * @return
	 */
	public String sendAnEmail(String[] to, String subject, String body) {
		try {

			System.out.println("JavaMailSender(I) implementation class : " + javaMailSender.getClass().getName());

			SimpleMailMessage simpleMsg = new SimpleMailMessage();
			simpleMsg.setTo(to);
			simpleMsg.setSubject(subject);
			simpleMsg.setText(body);

			javaMailSender.send(simpleMsg);

			String recipients = "";
			for (String one : to) {
				recipients += one + ", ";
			}

			return "Email Sent to : " + recipients;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Email sending failed";
	}

	/**
	 * https://mkyong.com/spring-boot/spring-boot-how-to-send-email-via-smtp/
	 * @param to
	 * @param subject
	 * @return
	 */
	public String sendEmailWithAttachment(String[] to, String subject) {

		MimeMessage msg = javaMailSender.createMimeMessage();

		try {
			// true = multipart message
			MimeMessageHelper helper = new MimeMessageHelper(msg, true);

			helper.setTo(to);

			helper.setSubject(subject);

			// default = text/plain
			//helper.setText("Check attachment for image!");

			// true = text/html
			helper.setText("<h1>Check attachment for image!</h1>", true);

			// hard coded a file path
			//FileSystemResource file = new FileSystemResource(new File("path/android.png"));

			helper.addAttachment("my_photo.jpg", new ClassPathResource("programmer.jpg"));

			javaMailSender.send(msg);

			String recipients = "";
			for (String one : to) {
				recipients += one + ", ";
			}

			return "Email Sent to : " + recipients;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Email sending failed";

	}

}
