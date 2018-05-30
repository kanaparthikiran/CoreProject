/**
 * 
 */
package com.objectlinx.np6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kikanapa
 *
 */


public class StringTest {

	final class one {
		final void oneM() {
			System.out.println("oneM: ");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		int steps = 1000;
        String base = getBaseString();
        
        for(long i=0;i<100000000;i++) {
        	new StringTest().new one();
        	System.out.println("created "+ i+ " number of Objects");
        }

        List<String> strings = new ArrayList<String>();
        int i = 0;
        while (true) {
            String str = base + i;
            str = str.intern();
            strings.add(str);
            i++;
            if (i % steps == 0) {
                Thread.sleep(1000);
            }

            if (i % (steps * 4) == 0) {
                strings = new ArrayList<String>();
            }
        }
    }

    private static String getBaseString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            builder.append("a");
        }
        return builder.toString();
    }

}
