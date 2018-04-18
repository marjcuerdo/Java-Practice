/**
 * F.java
 *
 * @version   $Id: F.java,v 1.0 2017/09/03 12:45pm $
 *
 * Revisions:
 *
 *	None.
 *
 */

import java.util.Properties;

/* 
 * This program calculates and outputs values from a geometric series sum.
 *
 * @author		Marjorie Ann M. Cuerdo
 */

class F {

	/*
	 * The main program
	 *
	 * @param	args	command line arguments (ignored)
	 */

	public static void main(String[] args) {

		f(0.5);
	}

	/*
	 * Takes a value of x and calculates geometric series sum and 
	 * added term values for a determined n value.
	 *
	 * @param	x	value of x in f(x)
	 */

	static private void f(double x) {

		double n = 15; // value of n can be changed from 0 to infinity
		double delta = 0.7; // a limiting value above 0
		double infSum = 1/1.5; // value obtained from geometric series to +infinity
		double nSum = 0; // total running sum of f(x) from i=0 to i=n
		double nValue = 0; // current values added to nSum

			// run through formula n times
			for (double i = 0; i < n; i++) {

				if ((absValue(nSum - infSum)) < delta) {

					if (i == 0) {
						nValue = 1; // x^0 is always 1
						nSum += nValue; 
					} else if (i == 1) {
						nValue = (-1)*x;
						nSum += nValue;
					} else {
						nValue = (-1)*x*nValue; // x is -x^n
						nSum += nValue;
					}
				} 
			}
			// prints value of approximation of f(x) sum, n, and last term added 
			System.out.println("f(" + x + ") = " + nSum + "\t" + n + "\t" + nValue);
	}

	/*
	 * Takes a negative sum value and multiples by -1 to get absolute value.
	 *
	 * @param	sum		running value in nSum
	 */

	static double absValue(double sum) {
		if (sum < 0 ) {
			sum = sum * (-1);
		}
		return sum;
	}

}