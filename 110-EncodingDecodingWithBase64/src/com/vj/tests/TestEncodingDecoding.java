package com.vj.tests;

import com.vj.utils.EncodeAndDecode;

public class TestEncodingDecoding {

	public static void main(String[] args) {
		String actualMsg = "My name is Vijay Muccharla";

		System.out.println("Actual Msg : " + actualMsg);

		String encodedMsg = EncodeAndDecode.endcode(actualMsg);

		System.out.println("Actual Msg after Encoding : " + encodedMsg);

		String decodedMsg = EncodeAndDecode.decode(encodedMsg);

		System.out.println("Actual msg after Encoding, then Decoded : " + decodedMsg);
	}

	/**
	 Today's session : Encoding, Decoding, Encryption & De-Cryption
	--------------------------------------------------------------
	-> As part of our applications we will transfer data from one application to another application through network
	
	-> As part of our applications, clients will provide the data in forms and will send to server through network.
	
	-> When we are sending data over the network all the characters of data may not be compatible with HTTP protocol. To make sure our data characters are compatible we will use Encoding & De-Coding Techniques.
	
	What is Encoding?
	-----------------
	It is the process of creating a message to transfer from source to destination with compatability.
	
	What is De-Coding?
	------------------
	It is the process of Interpreting message at destination.
	
	
	
	-> To work with Encoding & De-Coding we have Base64 algorithm
	
	How to work with Encoding & De-Coding in Java?
	----------------------------------------------
	-> Sun Microsystem provide Bases64 as part of java.util package to work with Encoding & De-Coding
	
	
	Converting String to byte[]
	---------------------------
	String msg = "hi";
	byte[] byteArray = msg.getBytes( );
	
	Converting byte[] to String
	---------------------------
	String msg = new String(byteArrary);
	 
	 
	 */
}
