package com.vj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vj.utils.EmailUtil;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt = SpringApplication.run(Application.class, args);

		EmailUtil emailUtil = ctxt.getBean(EmailUtil.class);

		String[] to = { "vkmuccharla@gmail.com", "hibernatejpa@gmail.com" };
		String subject = "Test email from Srping Boot Mail";
		String body = "This email is sent using - Java Mail Sender";

		//		String isSent = emailUtil.sendAnEmail(to, subject, body);
		String isSent = emailUtil.sendEmailWithAttachment(to, subject);
		System.out.println(isSent);
	}

}
