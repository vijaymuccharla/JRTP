package com.vj.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.vj.bindings.User;

@Component
public class EmailUtil {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String to, User user) {

		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message);

			messageHelper.setTo(to);
			messageHelper.setSubject("Unlock/Reset your User Account!");
			messageHelper.setText(getUnlockAccEmailBody(user), true);

			javaMailSender.send(message);
			System.out.println("Email Sent to : " + to);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Sending Email Failed");
		}
	}

	private String getUnlockAccEmailBody(User acc) throws IOException {
		StringBuffer sb = new StringBuffer("");

		FileReader fr = new FileReader("EMAIL_BODY_TEMPLATE_UNLOCK_ACCNT.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while (line != null) {
			sb.append(line);
			line = br.readLine();
		}

		br.close();

		// format mail body
		String mailBody = sb.toString();
		mailBody = mailBody.replace("{FNAME}", acc.getFirstName());
		mailBody = mailBody.replace("{LNAME}", acc.getLastName());
		mailBody = mailBody.replace("{TEMP-PWD}", acc.getUserPassword());
		mailBody = mailBody.replace("{EMAIL}", acc.getUserEmail());

		return mailBody;
	}

}
