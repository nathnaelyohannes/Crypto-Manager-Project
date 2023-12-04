
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';

	private static final char UPPER_BOUND = '_';

	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;
	
	/**
	 * 
	 * @param plainText
	 * @return
	 */
	
	public static boolean stringInBounds(String plainText) {
		boolean boundary = false;

		for (int index = 0; index < plainText.length(); index++)

		{

			if (plainText.charAt(index) >= LOWER_BOUND && plainText.charAt(index) <= UPPER_BOUND)
	
				boundary = true;

		}

		return boundary;

		}
	
	public static String encryptCaesar(String plainText, int key) {
		String encryptedText = "";
		if(stringInBounds(plainText)) {
			for(int index=0; index<plainText.length(); index++) {
				char thisChar = plainText.charAt(index);
				int encryptedCharint = ((int) thisChar+key);
				while(encryptedCharint > UPPER_BOUND) {
					encryptedCharint -= RANGE;
				}
				encryptedText += (char) encryptedCharint;
			}
		}
		return encryptedText;
	}
	
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptedText = "";
		int bellasoStrLength = bellasoStr.length();
		for(int index=0; index<plainText.length(); index++) {
			char thisChar = plainText.charAt(index);
			int encryptedCharint = ((int) thisChar+
			(int)bellasoStr.charAt(index%bellasoStrLength));
			while(encryptedCharint > (int)UPPER_BOUND) {
				encryptedCharint -= RANGE;
			}
			encryptedText += (char)encryptedCharint;
		}
		return encryptedText;
	}
	
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedText = "";
		
		for(int index=0; index<encryptedText.length(); index++) {
			
			char thisChar = encryptedText.charAt(index);
			
			int decryptedCharint = ((int) thisChar-key);
			
			while(decryptedCharint < LOWER_BOUND) {
				
				decryptedCharint += RANGE;
			}
			decryptedText += (char) decryptedCharint;
		}
		return decryptedText;
	}
	
	public static String decryptBellaso(String encryptedText, String BellasoStr) {
		String decryptedText = "";
		
		int bellasoStrLength = BellasoStr.length();
		
		for(int index=0; index<encryptedText.length(); index++) {
			
			char thisChar = encryptedText.charAt(index);
			
			int decryptedCharint = ((int) (int) BellasoStr.charAt(index%bellasoStrLength));
			
			while (decryptedCharint < (int) LOWER_BOUND) {
				
				decryptedCharint += RANGE;
			}
			decryptedText += (char)decryptedCharint;
		}
		return decryptedText;
	}
		
	}
