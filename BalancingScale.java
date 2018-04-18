/**
 * BalancingScale.java
 *
 * @version   $Id: BalancingScale.java,v 1.0 2017/09/03 12:41pm $
 *
 * Revisions:
 *
 *	None.
 *
 */

import java.util.Properties;

/* 
 * This program calculates whether a given specific weight can be
 * obtained through exact distributions of weight numbers from a 
 * determined set of values.
 *
 * @author		Marjorie Ann M. Cuerdo
 */

import java.util.*;

class BalancingScale {

	// contains the possible weight values
	static int weightsArray[] = {50, 25, 25, 25, 10, 10, 5, 2, 1};

	// maximum possible weight
	static int maxWeight = 50+25+25+25+10+10+5+2+1;

	/*
	 *The main program
	 *
	 * @param	args	command line arguments (ignored)
	 */

    public static void main (String args []) {	// main program
    	checkWeight(0);	// total weight 0
    	checkWeight(1); // total weight 1
    	checkWeight(8); // total weight 8
    	checkWeight(9); // total weight 9
    	checkWeight(57); // total weight 57
    	checkWeight(75); // total weight 75
    	checkWeight(18); // total weight 18
    	checkWeight(100);
    	checkWeight(maxWeight+1); // total weight 18
	}

	/*
	 * Given a weight, calculate the what inidividual weights can be
	 * used to distribute into the weight. If possible, print the weights
	 * used. If not, tell the user.
	 *
	 * @param	weight 	weight to calculate
	 */

	public static void checkWeight(int weight) {

		// variable that maintains original weight value to print
		int initialWeight = 0;
		initialWeight = weight;

		// empty arraylist to hold weight values
		ArrayList<String> usedWeights = new ArrayList<String>();

		// if input weight is valid
		if (weight <= maxWeight && weight > 0) {

			for (int i=0; i < weightsArray.length; i++) {

				// if same value
				if (weightsArray[i] == weight) {

					// add to used array
					usedWeights.add(String.valueOf(weight)); 

					// calculate remaining weight
					weight = weight - weightsArray[i]; 

				} else if (weight >= weightsArray[i] ) {

					// if reached end of list of weight values
					if (i == weightsArray.length - 1) {
						usedWeights.clear(); // remove weights from list
						usedWeights.add("NO, weights can't fit.");
						break;
					}

					// calculate remaining weight
					weight = weight - weightsArray[i];

					usedWeights.add(String.valueOf(weightsArray[i]));
				} 

			}

			// display list of used weight values
			System.out.println(initialWeight + "g:\t" + "used weights = " + usedWeights);

		} else if (weight > maxWeight) {
			System.out.print(initialWeight + "g:\t" + "NO, input weight exceeds max value.\n");
		}
		else {
			System.out.println(initialWeight + "g:\t" + "used weights = " + usedWeights);
		}
	}
}