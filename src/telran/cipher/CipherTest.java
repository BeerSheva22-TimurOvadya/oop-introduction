package telran.cipher;


import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.*;

public class CipherTest {
	
	
	@Test	
	void baseCipherTestUserInputPrint() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input the number to be encoded: ");
		int number = in.nextInt();
		
		System.out.print("Input the number of encoding characters: ");
		int character = in.nextInt();
			
		BaseCipher cipherbase = new BaseCipher(character);
		String cipher = cipherbase.cipher(number);
		int decipher = cipherbase.decipher(cipher);
		System.out.println("Encrypted value: " + cipher);		
		
		assertEquals(number, decipher);
		in.close();
	}
		
		@Test
		void baseCipherTest() {
		int number = 15;						
		BaseCipher cipherbase = new BaseCipher(94);
		String cipher = cipherbase.cipher(number);
		int decipher = cipherbase.decipher(cipher);		
		assertEquals(number, decipher);
		
		
		number = 15;						
		cipherbase = new BaseCipher(1);
		cipher = cipherbase.cipher(number);
		decipher = cipherbase.decipher(cipher);		
		assertEquals(number, decipher);
		
		number = 230394;						
		cipherbase = new BaseCipher(3);
		cipher = cipherbase.cipher(number);
		decipher = cipherbase.decipher(cipher);		
		assertEquals(number, decipher);
		
		number = 271089;						
		cipherbase = new BaseCipher(45);
		cipher = cipherbase.cipher(number);
		decipher = cipherbase.decipher(cipher);		
		assertEquals(number, decipher);
		
		}
		
	}
	
	
