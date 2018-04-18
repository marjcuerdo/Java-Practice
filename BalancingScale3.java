
//package balancingscale2;

/**
 *
 * @author Shatha Alotaibi
 *         Marjorie Ann M. Cuerdo
 * 
 */
/**
 * BalancingScale2.java
 *
 * @version   $Id: BalancingScale2.java,v 1.0 2017/09/03 12:41pm $
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

class BalancingScale2 {

	// contains the possible weight values
	static int weightsArray[] = {50, 25, 25, 25, 10, 10, 5, 2, 1};

	// maximum possible weight
	static int maxWeight = 50+25+25+25+10+10+5+2+1;
        //static int difference[]= new int[weightsArray.length];
       // int difference=0;
       static boolean checkBalance=false;

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
    	checkWeight(maxWeight+1); // total weight 18

        addWeights(25);
        addWeights(10);
        addWeights(75);
        addWeights(90);
       
   
	}
   
    
    public static void addWeights(int weight) {
        int newweight;
        int difference=0; 
      /*  if(isItIn( weight))
        {
              System.out.println ("The weight in the list");
         } else {*/
       
        for (int i=0; i < weightsArray.length; i++){
               
                difference = Math.abs(weight - weightsArray[i]);
                   if (difference == 0 ){
                         System.out.println ("The weight in the list");
                         checkBalance = true;
                //  System.out.println ("The weight added is " + difference );
                         break;
                    }else {
                     
                             for (int k=0; k < weightsArray.length; k++) {
                   
                                   if ( difference == weightsArray[k]) { 
                                          // System.out.println( "the weight  is :"+ weight );
                                           System.out.println ("The difference between the weight "+ weight+ " and the "+ weightsArray[i]+ " is " + difference );
                                           checkBalance = true;
                                         //  System.out.println("index: " + k);
                                   
                                              if (weight < weightsArray[i]){
                                                     newweight=0;
                                                     newweight= weight+ difference; 
                                                     checkBalance = true;
                                                     System.out.println( "Adding the missing weight: "+ difference +" to the input weight (L) =" + newweight);
                                                     break;
                                                } else if( weight > weightsArray[i]){
                                                        newweight= (weightsArray[i]+ difference);
                                                        checkBalance = true;
                                                        System.out.println( "Adding the missing weight "+ difference+ " to the weightsArray (R) =" + newweight);
                                                        break;
                                                    } /*else if( weight == weightsArray[k]){
                                                        System.out.println( "no needing to add any weight");
                                                        break;*/
                                                        
                                                    } 
                                      
                                    } if (!checkBalance) {System.out.println ("The difference is " + difference+ " is not available. We can not make the weight "+ weight );}
                                }         
                        } 
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
                                      //  checkBalance = true;
					// calculate remaining weight
					weight = weight - weightsArray[i]; 

				} else if (weight >= weightsArray[i] ) {

					// if reached end of list of weight values
					if (i == weightsArray.length - 1) {
						usedWeights.clear(); // remove weights from list
						usedWeights.add("NO, weights can't fit.");
                                               // checkBalance = false;
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


