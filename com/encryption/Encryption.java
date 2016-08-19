package com.encryption;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class Encryption {

	public static byte[] text = null;
	public static byte[] textEncrypted = null;
	public static Cipher desCipher;
	public static KeyGenerator keygenerator;
	public static SecretKey myDesKey;
	public static String userInput = null;
	
	public static Scanner sc = new Scanner(System.in);

	public Encryption() {
	}
	
	public void encryptor() {
		
		try {
			keygenerator = KeyGenerator.getInstance("DES");
			myDesKey = keygenerator.generateKey();
		    desCipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

		    desCipher.init(Cipher.ENCRYPT_MODE, myDesKey);
	    
		    text = userInput.getBytes();

		    System.out.println("\nText you entered: " + new String(text));

		    textEncrypted = desCipher.doFinal(text);

		    System.out.println("Encrypted version of text: " + textEncrypted);
		    
		} catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch(NoSuchPaddingException e) {
			e.printStackTrace();
		} catch(InvalidKeyException e){
			e.printStackTrace();
		} catch(IllegalBlockSizeException e){
			e.printStackTrace();
		} catch(BadPaddingException e){
			e.printStackTrace();
		}
	}
	
	public void inputText() {
	    System.out.println("Enter the text you'd like to encrypt:");
	    userInput = sc.nextLine();
	}

	public SecretKey getMyDesKey() {
		return myDesKey;
	}

	public Cipher getDesCipher() {
		return desCipher;
	}

	public byte[] getText() {
		return text;
	}

	public byte[] getTextEncrypted() {
		return textEncrypted;
	}
}
