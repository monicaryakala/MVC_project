package com.albany.edu.fwp.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class AesEncryptionImpl implements AesEncryption  {
	private static byte[] key ;
	 private static SecretKeySpec secretKey ;
	 
	 private static String decryptedString;
	    private static String encryptedString;
	
	 public void setKey(String myKey){
        
		   
        MessageDigest sha = null;
        try {
            key = myKey.getBytes("UTF-8");
            System.out.println(key.length);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16); // use only first 128 bit
            System.out.println(key.length);
            System.out.println(new String(key,"UTF-8"));
            secretKey = new SecretKeySpec(key, "AES");
            
            
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
              
    
    }
	 
	  public  String getDecryptedString() {
	        return decryptedString;
	    }
	    public  void setDecryptedString(String decryptedString) {
	    	this.decryptedString = decryptedString;
	    }
	    public String getEncryptedString() {
	        return encryptedString;
	    }
	    public void setEncryptedString(String encryptedString) {
	    	this.encryptedString = encryptedString;
	    }
	 
	
	    
	    public  String encrypt(String strToEncrypt)
	    {
	        try
	        {
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
	        
	            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        
	         
	            setEncryptedString(Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes("UTF-8"))));
	        
	        }
	        catch (Exception e)
	        {
	           
	            System.out.println("Error while encrypting: "+e.toString());
	        }
	        return null;
	    }
	    
	    public String decrypt(String strToDecrypt)
	    {
	        try
	        {
	            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
	           
	            cipher.init(Cipher.DECRYPT_MODE, secretKey);
	            setDecryptedString(new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt))));
	            
	        }
	        catch (Exception e)
	        {
	         
	            System.out.println("Error while decrypting: "+e.toString());
	        }
	        return null;
	    }
	 
}
