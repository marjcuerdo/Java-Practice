/*
 * PiEvenOddThread.java
 *
 * @version   $Id: PiEvenOddThread.java,v 1.1 2017/10/19 20:32 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */


import java.io.*;

public class PiEvenOddThread implements Runnable {

	Thread thrd;

	PiEvenOddThread() {
		thrd = new Thread(this);
		thrd.start();
	}

	public void run() {
		BufferedReader input = new BufferedReader(new FileReader(args[0]));
		count(input);
		/*System.out.println(thrd.getName() + " starting.");
		try {
			for (int count=0;count < 10;count++) {
				Thread.sleep(400);
				System.out.println("In " + thrd.getName() + ", count is " + count);
			}
		} catch (InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted.");
		}
		System.out.println(thrd.getName() + " terminating.");*/
	}


	synchronized void count(BufferedReader input) {
		//byte[]  buffer = new byte[1024];
	    //int     n;
	    
	    //Stream<String> stream = in.lines().limit(numberOfLinesToBeRead);
	    //PiEvenOddThread p1 = new PiEvenOddThread("Child #1");

		int count_even = 0;
	    int count_odd = 0;

	    	char c;
	    	int i;
	    	
	    	try {

		    	while ( ( i = input.read()) != -1)   {
		    		c = (char)i;

		    		
			    		if (String.valueOf(c).equals(".")) {
			    			Thread.sleep(400);
			    		} else if (i%2 == 0) {
			    			count_even++;
			    			Thread.sleep(400);
			    			//System.out.println(c + ": even");
			    		} else if (i%2 == 1) {
			    			count_odd++;
			    			Thread.sleep(400);
			    			//System.out.println(c + ": odd");
			    		}
		    	
		    	}
	    	} catch (InterruptedException exc) {
	    		System.out.println("Main thread interrupted.");
	    	}

	    	//System.out.println("# lines = " + input.getLineNumber() );
			input.close();
			System.out.println("even = " + count_even);
			System.out.println("odd = " + count_odd);
			System.out.println("odd/even = " + (double)count_odd/(double)count_even);

	    
	}
}
