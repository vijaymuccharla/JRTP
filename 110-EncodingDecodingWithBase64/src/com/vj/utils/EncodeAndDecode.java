package com.vj.utils;

import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

public class EncodeAndDecode {

	public static String endcode(String msg) {
		Encoder encoder = Base64.getEncoder();
		String encodedMsg = encoder.encodeToString(msg.getBytes());
		return encodedMsg;
	}

	public static String decode(String encodedMsg) {
		Decoder decoder = Base64.getDecoder();
		byte[] decodedMsg = decoder.decode(encodedMsg);
		return new String(decodedMsg);
	}
}
