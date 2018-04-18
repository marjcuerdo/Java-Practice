/**
 * P.java
 *
 * @version   $Id: P.java,v 1.0 2017/09/03 12:47pm $
 *
 * Revisions:
 *
 *	None.
 *
 */

import java.util.Properties;

/* 
 * This program calculates a formula using only 3 running variables.
 *
 * @author		Marjorie Ann M. Cuerdo
 */

class P {

	/*
	 * The main program
	 *
	 * @param	args	command line arguments (ignored)
	 */

	public static void main(String[] args) {
		
		System.out.println("The sum cannot exceed 100.");
		p(0);
		p(1);
		p(2);
		p(3);
		p(4);
		p(5);
		p(50);
		p(100);
	}

	/*
	 * Calculates the value of p(number) for any given number.
	 *
	 * @param	number	number is any value k
	 */

	public static void p(float number) {

		float n0 = 0;
		float n1 = 1;
		float n2 = 2;

		// p(0) is always 0
		if (number == 0) {
			System.out.println("p(" + number + ") = " + n0);
		} else if (number == 1) {
			System.out.println("p(" + number + ") = " + n1);
		} else {

			// calculate value of p(number) for number/k times
			for (float i=3; i <= number; i++) {
				n0 = n1;
				n1 = n2;
				n2 = 2 * n1 + n0;
				//System.out.print("n0 = " + n0 + "\t");
				//System.out.print("n1 = " + n1 + "\t");
				System.out.print("p(" + i + ") = " + n2 + "\n\n");
			}

			// print result of p(k)
			System.out.println("p(" + number + ") = " + n2);
		}
	}
}