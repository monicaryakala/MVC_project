package com.albany.edu.fwp.dao;

public interface AesEncryption {
	void setKey(String myKey);
	public String encrypt(String strToEncrypt);
	public String decrypt(String strToDecrypt);
	public  String getDecryptedString();
	public String getEncryptedString();
}
