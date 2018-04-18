/*
 * PiEvenOddBetter.java
 *
 * @version   $Id: PiEvenOddBetter.java,v 1.1 2017/10/20 10:45 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */
// runs: 0.13 real	0.14 user	0.02 sys

import java.io.*;

public class PiEvenOddBetter {

	public static void main(String[] args) {
	   	//byte[]  buffer = new byte[1024];
	    //int     n;
	    
	    //Stream<String> stream = in.lines().limit(numberOfLinesToBeRead);

		int count_even = 0;
	    int count_odd = 0;

	    if ( args.length < 1 )	{
			System.err.println(
			     "Usage: /usr/bin/time java PiEvenOdd [file path]\nOR\n" +
			     "cat [file path] | java PiEvenOdd");
			System.exit(1);
	    }

	    try /*(
	    	DataInputStream in = new DataInputStream(
	    				new FileInputStream(args[0]) );
	    	DataOutputStream out = new DataOutputStream(
	    				new FileOutputStream(args[1]) );
		)*/ {
	    	
			/*while ( (n = in.read(buffer) ) != -1 ) {
				out.write(buffer, 0, n);
	    		}*/
	    	BufferedReader input = new BufferedReader(new FileReader(args[0]), 512);
	    	char c;
	    	int i;
	    	

	    	while ( ( i = input.read()) != -1)   {
	    		c = (char)i;
	    		if (String.valueOf(c).equals(".")) {

	    		} else if (i%2 == 0) {
	    			count_even++;
	    			//System.out.println(c + ": even");
	    		} else if (i%2 == 1) {
	    			count_odd++;
	    			//System.out.println(c + ": odd");
	    		}


	    		
	    	}
	    	//System.out.println("# lines = " + input.getLineNumber() );
			input.close();
			System.out.println("even = " + count_even);
			System.out.println("odd = " + count_odd);
			System.out.println("odd/even = " + (double)count_odd/(double)count_even);

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