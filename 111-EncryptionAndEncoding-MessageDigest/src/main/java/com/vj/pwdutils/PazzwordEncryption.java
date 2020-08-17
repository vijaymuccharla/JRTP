package com.vj.pwdutils;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Encoder;

public class PazzwordEncryption {
	
	
	
	public static void main(String[] args) throws Exception {
		PazzwordEncryption.encryptText("vijay@123");
	}

	/**
	 
	 We take a text(pwd) from enduser when registering, encrypt using an Algorithm.
	 After encrypting we have to decode it for compatible characters, then insert to DB.
	 Whenever user want to access we take a text(pwd), encrypt and decode again.
	 Then compare it with the value inserted in DB.
	 If equal, valid credentials. Else Invalid.
	  
	 * @param text
	 * @return
	 * @throws Exception
	 */
	public static String encryptText(String text) throws Exception {
		System.out.println("Text to encrypt : " + text);
		//get instance of MsgDigest with an Algorithm.
		MessageDigest msgDigest = MessageDigest.getInstance("SHA-256");
		//encrypt the text and get byte[]
		byte[] digestedText = msgDigest.digest(text.getBytes());
		System.out.println("Text after encryption : " + new String(digestedText));
		//encode the Encrypted text for compatibility
		Encoder encoder = Base64.getEncoder();
		String encodedText = encoder.encodeToString(digestedText);
		System.out.println("Encrypted text after encoding : " + encodedText);
		return encodedText;
	}
}
