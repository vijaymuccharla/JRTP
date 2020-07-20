package com.vj.utils;

import java.util.Random;

public class RandomPasswordUtil {

	public static void main(String[] args) {
		char[] generatePassword = generatePassword(9);
		System.out.println(generatePassword);
	}
		
	/**
	 * https://www.tutorialspoint.com/Generating-password-in-Java
	 * https://beginnersbook.com/2014/06/how-to-convert-a-char-array-to-a-string-in-java/
	 * @param length
	 * @return
	 */
	public static char[] generatePassword(int length) {
	      String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	      String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
	      String specialCharacters = "!@#$";
	      String numbers = "1234567890";
	      String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
	      Random random = new Random();
	      char[] password = new char[length];

	      password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
	      password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
	      password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
	      password[3] = numbers.charAt(random.nextInt(numbers.length()));
	   
	      for(int i = 4; i< length ; i++) {
	         password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
	      }
	      return password;
	   }
}
