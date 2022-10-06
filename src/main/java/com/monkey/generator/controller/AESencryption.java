package com.monkey.generator.controller;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;

import java.util.Base64;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.monkey.generator.util.PropertyUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AESencryption {

	private static byte[] skey;
	private static byte[] nonce;
	
	public AESencryption() throws Exception {
		skey = getKey();
		nonce = newNonce();
		System.out.println("AES key generated");
	}
	
	
	public static byte[] getKey() throws Exception {
		String key = "monkey_king";
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] hash = digest.digest(key.getBytes(StandardCharsets.UTF_8));
		String keyconvert = DatatypeConverter.printHexBinary(hash).toLowerCase().substring(0,32);
		byte[] skey = keyconvert.getBytes();
		return skey;
	}

	
	public static byte[] newNonce() throws NoSuchAlgorithmException {
		char[] noncearr = "0123456789012345".toCharArray();
		byte[] newNonce = new byte[noncearr.length];
		for(int i = 0 ; i<noncearr.length; i++) {
			newNonce[i] = (byte)noncearr[i];
		}
		return newNonce;
	}
	
	public static String encrypte(String msg) throws Exception{
		SecretKey sks = new SecretKeySpec(skey, "AES");
		
		AlgorithmParameterSpec aps =  new IvParameterSpec(nonce);
		
		Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
		
		cipher.init(Cipher.ENCRYPT_MODE, sks, aps);
		
		int blockSize = 32;
		
		byte[] dataBytes = msg.getBytes("UTF-8");
		
		int plaintextLength = dataBytes.length;

        int fillChar = ((blockSize - (plaintextLength % blockSize)));

        plaintextLength += fillChar; //pad 

        byte[] plaintext = new byte[plaintextLength];

        Arrays.fill(plaintext, (byte) fillChar);

        System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);

        byte[] cipherBytes = cipher.doFinal(plaintext);

        String afterCiphered = new String(Base64.getEncoder().encodeToString(cipherBytes));
        
		return afterCiphered;
	}
	
	public static String decrypte(String emsg) throws Exception {
		SecretKey sks = new SecretKeySpec(skey, "AES");
		
		AlgorithmParameterSpec aps =  new IvParameterSpec(nonce);
		
		Cipher dcipher = Cipher.getInstance("AES/CBC/NoPadding");

		dcipher.init(Cipher.DECRYPT_MODE, sks, aps);
		
		byte[] decryptedmsg = Base64.getDecoder().decode(emsg);
		
		byte[] aesdecode = dcipher.doFinal(decryptedmsg);
		
		byte[] origin = new byte[aesdecode.length - (aesdecode[aesdecode.length - 1])];

        System.arraycopy(aesdecode, 0, origin, 0, origin.length);
        
		return new String(origin, "UTF-8");
	}
	
	public static String phoneBlind(String phone) {
		if(phone.length() == 11) {
			return phone.substring(0, 3) + "-****-" + phone.substring(7);
		} else if(phone.length() == 10) {
			return phone.substring(0, 3) + "-***-" + phone.substring(6);
		} else {
			return phone;
		}
	}

}
