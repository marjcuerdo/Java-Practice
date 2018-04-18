/*
 * Writer.java
 *
 * @version   $Id: Writer.java,v 1.1 2017/10/21 21:50 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.io.*;

public class Writer {

	public static void main(String[] args) {

		int count_even = 0;
	    int count_odd = 0;
	    FileOutputStream out_stream = null;

	    if ( args.length < 1 )	{
			System.err.println(
			     "Usage: /usr/bin/time java PiEvenOdd [file path]\nOR\n" +
			     "cat [file path] | java PiEvenOdd");
			System.exit(1);
	    }

	    try {

	    	BufferedReader input = new BufferedReader(new FileReader(args[0]), 512);
	    	File output_file = new File("new_file.txt");

	    	out_stream = new FileOutputStream(output_file);

	    	char c;
	    	int i;
	    	int counter = 0;
	    	char[] hashCode = "md5".toCharArray();
	    	
	    	while ( ( i = input.read()) != -1)   {
	    		c = (char)i;
	    		if (counter == 0) {

	    			for(int j=0;j<hashCode.length;j++) {
	    				out_stream.write(hashCode[j]);
	    			}
	    			out_stream.write(c);
	    		} else {
	    			out_stream.write(c);
	    		}

	    		counter++;
	    	}

			input.close();
			out_stream.close();
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