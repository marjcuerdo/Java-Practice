/**
 * TwinPrimes.java
 *
 * @version   $Id: TwinPrimes.java,v 1.0 2017/09/07 12:03pm $
 *
 * Revisions:
 *
 *	None.
 *
 * 
 * This program calculates and prints all twin prime numbers within a given
 * range.
 * 
 *
 * @author		Marjorie Ann M. Cuerdo
 */

import java.util.ArrayList;

class TwinPrimes {
	
	static int nValue = 0; // hold the overall value of n

	/*
	 *The main program
	 *
	 * @param	args	command line arguments (ignored)
	 */

	public static void main( String[] args ) {
		int delta = 100;

		for ( int index = 0; index < 1000; index += 100 ) {
			findTwinPrimes(index, index + delta, nValue );
		}

	}

	/*
	 *The main program
	 *
	 * @param	index	beginning value of range
	 * @param	range   end value of range
	 * @param	n 		current n value to correct range
	 */

	public static void findTwinPrimes( int index, int range, int n ) {
		ArrayList<Integer> twinPrimes = new ArrayList<Integer>();

		int twinPrime1 = 0;
		int twinPrime2 = 0;

		do {
			if (n == 0) {
				twinPrimes.add(3); // twin primes (3,5) can't fit formula
				n++; // update n count
			} else {
				twinPrime1 = 6 * n - 1; // smaller value in pair
				twinPrime2 = 6 * n + 1; // larger value in pair
				// if values are still within the current range
				if ((twinPrime1 < range) && (twinPrime2 < range)) {
					twinPrimes.add(twinPrime1);
					twinPrimes.add(twinPrime2);
				}
				n++; // update n count
			}
		} while ((twinPrime1 < range) && (twinPrime2 < range));

		nValue = n; // update the count value of n

		System.out.println("Range " + index + " - " + range + ":\n" + twinPrimes + "\n");
	}
}