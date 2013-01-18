/**
 * 
 */

/**
 * @author kikanapa
 *
 */

	
	class one{
		
	}

	class Two extends one {
	}
	class Three extends one {
	}

	public class TestInstance {
	public static void main(String args[]) {
	one test1 = new Two();
	one test2 = new Three();
	System.out.println(test1 instanceof one); //true
	System.out.println(test2.getClass().equals(test1.getClass())); //true
	//System.out.println(Test.getClass().equals(test2.getClass())); //false
	System.out.println("TestIn returns******:" 
	+ testIn(test2));
	
	}

	
	
	/**
	 * 
	 * @param context
	 * @return
	 */
	private static boolean testIn(one context) {
		
		boolean result;
		if(context.getClass().equals(Two.class)) {
		//if(context instanceof one) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}

}
