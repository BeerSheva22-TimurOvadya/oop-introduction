package telran.cipher;


public class BaseCipher {

	private String key = "" ;
	
	private static final int MIN = 33;
	private static final int MAX = 126;

	public BaseCipher(int length) {			
		if (length < 2) {
			length = 2;
		}
		else if (length > 94) {
			length = 94;
		}
		this.key = createKey(length);
	}	
	
	private String createKey(int length) {		
		int[] arr = new int[MAX - MIN + 1];		
		for (int i = 0; i < length; i++) {
			char symbol = getRandomCharSymbol(MIN, MAX);
			if (arr[symbol - MIN] != 1) {
				key = symbol + key;
				arr[symbol - MIN] = 1;				
			}
		}
		return key;
	}	
	
	private static char getRandomCharSymbol(int min, int max) {
		max = max - min + 1;
		return (char) (Math.random() * max + min);
	}	
	
	public String cipher(int number) {
		String res = "";
		int keyLength = key.length();
		do  {
			res = res + key.charAt(number % keyLength);
			number = number / keyLength;			
		} while (number != 0);
		return res;
	}	
	
	public int decipher(String cipher) {
		int res = 0;
		int keyLength = key.length();
		int cipherLength = cipher.length();
		char[] charArray = cipher.toCharArray();		
		for (int i = 0; i < cipherLength; i++) {			
			res += Math.pow(keyLength, i) * indexCount(charArray[i]);			
		}		
		return res;
	}
		
	private int indexCount(char symbol) {
		char[] keyArray = key.toCharArray();
		int keyLength = key.length();		
		int count = 0;
		for (int i = 0; i < keyLength; i++) {
			if (keyArray[count] == symbol) {
				count = count + 0;
			}
			else {
				count++;
			}
		}		
		return count;
	}	
}