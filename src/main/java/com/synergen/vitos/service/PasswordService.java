package com.synergen.vitos.service;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class PasswordService {
	private final String encryptKey = "bankfair@openarc";
	
	//encryption
	public String encrypt(String pw) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor(); 
		encryptor.setPassword(encryptKey);
		return encryptor.encrypt(pw);
	}
	//decryption
	public String decrypt(String enpw) {
		StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor(); 
		encryptor.setPassword(encryptKey);
		return encryptor.decrypt(enpw);
	}
	
	public static void main(String[] args) {
		PasswordService ps = new PasswordService();
		String pw = ps.decrypt("2Di+wKnq60xLk9Wb4TmvCQ==");
		System.out.println(pw);
	}
}
