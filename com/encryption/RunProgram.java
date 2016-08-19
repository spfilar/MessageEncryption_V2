package com.encryption;

import com.decryption.Decryption;

public class RunProgram {

	public static boolean exit = false;
	
	public static void main(String[] args) {
			
		while(!exit) {
			runProgram();
		}	
	}
	
	public static void runProgram() {

		Encryption newEncryption = new Encryption();
		Decryption newDecryption = new Decryption();
		
		newEncryption.inputText();
		newEncryption.encryptor();
		newDecryption.decryptor();
	}
}
