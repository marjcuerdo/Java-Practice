/*
 * StringEx.java
 *
 * @version   $Id: StringEx.java,v 1.2 2017/09/10 11:17am $
 *
 * Revisions:
 *
 *  None.
 *
 * 
 * This program takes an array of Strings and counts the frequency of letters
 * and finds possible palindromes given the available characters.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.util.ArrayList;
import java.util.Arrays;

class StringEx {
    
    static String[] aText = {"abccb","BaBcac"};
    static String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    static String twoLines = "";
    static StringBuilder tempWord = new StringBuilder();
    static ArrayList<String> palindromes = new ArrayList<String> ();
    static int counter[]= new int[26];
    static int oddCounter = 0;
    static boolean canPalindrome = true;
  
    /*
     *The main program
     *
     * @param   args  command line arguments (ignored)
     */

    public static void main( String[] args ) {
        findPalindromes(aText);
    }

    /*
     * Given an array of Strings, calculate the number of times a letter appears
     * in the combined Strings and find all occurrences of palindromes.
     *
     * @param   a   array of Strings
     */

    public static void findPalindromes (String a[]) {
        String btext = ""; // hold characters 
        String substring = ""; // substring of characters

        twoLines = a[0] + a[1];
      
        for (int l=0; l < a.length; l++) {
            btext += a[l];
        }

        String[] text = btext.split("");
      
        // ensure every character is the same case
        for (int k=0; k < text.length; k++ ) {
            text[k] = text[k].toLowerCase();
      
            for (int i=0; i < alphabet.length; i++)
            {            
                if (text[k].equals(alphabet[i])) {
                    counter[i]++;
                }  else if (text[k].equals(null)) {
                    counter[i] = 0;
                } 
            }
        }

        System.out.println("Word to Check: " + twoLines);
   
        System.out.println("Character Distribution Count: ");

        // store count of every letter in alphabet
        for (int j=0; j < alphabet.length; j++)
        {
            int count = counter[j];
            
            System.out.println(alphabet[j] + ": " + counter[j]);

            // if more than one count of odd letters, cannot palindrome
            // if only one count, append letter to word template
            if (counter[j] % 2 == 1) {
                oddCounter++;
                if (oddCounter > 1) {
                    canPalindrome = false;
                } else {
                    // if odd letter is more than once, append altogether
                    for (int p=0; p < counter[j]; p++) {
                        if (!palindromes.contains(tempWord)) {
                            tempWord.append(alphabet[j]);
                        }
                    }
                }
            } else { 
                // if count is even, append to the end of word template
                count = count / 2;
                for (int k=0; k < count; k++) {
                    //tempWord.append(k);
                    //tempWord.append(alphabet[j]);
                    tempWord.insert(0,alphabet[j]);
                }
            } 
        }

        // append the even letters to the front of the word template
        for (int m=0; m < alphabet.length; m++ ) {

            int count = counter[m] / 2;

            if (counter[m] % 2 == 0) {
              for (int n=0; n < count; n++) {
                tempWord.append(alphabet[m]);
              }
            }

        }

        // add word and clear the tempWord holder
        palindromes.add(tempWord.toString());
        tempWord.setLength(0);

        int wordLength = 0;

        // create different length palindromes of single letters
        for (int i=0; i < twoLines.length(); i++) {

            if (counter[i]>1){
                for (int j=counter[i]; j > 0; j--) {
                    tempWord.append(alphabet[i]);
                }
                palindromes.add(tempWord.toString());
                tempWord.setLength(0);
            } 

            // create palindromes of single letter
            if (counter[i] > 2) {
                for (int k=2; k <= counter[i]; k++) {
                    tempWord.append(alphabet[i]);
                }
                palindromes.add(tempWord.toString());
                tempWord.setLength(0);
            }
        }

        // create palindromes out of substrings
        for (int i=2; i <= twoLines.length(); i++) {
            for (int j=0; j <= twoLines.length(); j++) {
                int k = i + j -1;
                if (k >= twoLines.length()) {
                    continue;
                }
                substring = twoLines.substring(j, i+j);
                if (substring.equals(new StringBuilder(substring).reverse().toString())) {
                    substring = substring.toLowerCase();
                    if (!palindromes.contains(tempWord.toString())) {
                        palindromes.add(substring);
                    }
                }
            }
        }

        if (canPalindrome) {
            System.out.println("Found Palindrome(s): " + palindromes);
        } else {
            System.out.println("Palindromes CANNOT be made.");
        }
    }
}


