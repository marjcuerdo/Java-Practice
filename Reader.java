/*
 * Reader.java
 *
 * @version   $Id: Reader.java,v 1.1 2017/10/201 21:49 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.io.*;

public class Reader {

	public static void main(String[] args) {

		int count_even = 0;
	    int count_odd = 0;

	    if ( args.length < 1 )	{
			System.err.println(
			     "Usage: /usr/bin/time java PiEvenOdd [file path]\nOR\n" +
			     "cat [file path] | java PiEvenOdd");
			System.exit(1);
	    }

	    try {
	    	
	    	BufferedReader input = new BufferedReader(new FileReader(args[0]), 512);
	    	char c;
	    	int i;
	    	int counter = 0;
	    	//char[] hashCode = "md5".toCharArray();

	    	while ( ( i = input.read()) != -1)   {
	    		
	    		c = (char)i;

				if (counter < 3) {
					if (String.valueOf(c).equals("m")) {
						counter++;
	    			} else if (String.valueOf(c).equals("d")) {
	    				counter++;
	    			} else if (counter == 2 & String.valueOf(c).equals("5")) {
						counter++;
	    				System.out.println("Hash code matches!");
	    			}	
	    		} 
	    	}

	    	if (counter != 3) {	
	    		System.out.println("Hash code doesn't match!");
	    	}

			input.close();
	    }
	    catch ( FileNotFoundException ef)	{
	    	System.out.println("File not found: " + args[1]);
	    }
	    catch ( IOException ef)	{
	    	System.out.println("File not found: " + args[1]);
	    }
	    catch ( Exception e)	{
	    	System.out.println("ExceptionType occurred: " + 
	    		e.getMessage() );
	    }
	}

}