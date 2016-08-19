package com.decryption;

import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;

import com.encryption.Encryption;

public class Decryption {

	public byte[] textDecrypted = null;
	public byte[] textEncrypted = null;
	public static Cipher desCipher;
	public static SecretKey myDesKey;
	
	public Decryption() {
	}

	public void decryptor() {

		Encryption encrypting = new Encryption();
		textEncrypted = encrypting.getTextEncrypted();
		desCipher = encrypting.getDesCipher();
		myDesKey = encrypting.getMyDesKey();
		
		try {
			desCipher.init(Cipher.DECRYPT_MODE, myDesKey);
		
			textDecrypted = desCipher.doFinal(textEncrypted);
			
			System.out.println("Decrypted text: " + new String(textDecrypted) + "\n");
			
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
}
