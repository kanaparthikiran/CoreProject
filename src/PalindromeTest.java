/**
 * 
 */

/**
 * @author kikanapa
 *
 */
public class PalindromeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean result = isPalindrome("KIRIK");
		//boolean result = isPalindrome(null);
		System.out.println("The result is :"+ result);
	}


	/**
	 * 
	 * @return
	 */
	private static boolean isPalindrome(String input) {
		boolean b = false;
		int length = 0;
		if(input!= null && !input.isEmpty()) {
			length = input.length();
			StringBuffer sb = new StringBuffer();
			for(int i=length-1;i>=0;i--) {
				sb.append(input.charAt(i));
			}
			String reversed = sb.toString();
			System.out.println("Input is "+ input+" and reverse is "+reversed);
			if(input.equals(reversed)) {
				b = true;
			}
		}
		return b;	
	}


}
