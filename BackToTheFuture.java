/*
 * BackToTheFuture.java
 *
 * @version   $Id: BackToTheFuture.java,v 1.3 2017/09/15 10:07am $
 *
 * Revisions:
 *
 *  Fixed game condition bugs and formatting
 * 
 * This program simulates a word-guessing game of hangman, using a text file 
 * to initialize an array of possible words to guess.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

class BackToTheFuture {

	static int guessCount = 9; // number of guesses remaining
	static int wrongCount = 8; // number of wrong guesses made
	static String wordToGuess = ""; // holder for word to guess
	static ArrayList<String> dictionary = new ArrayList<String>(); 
	static ArrayList<String> correctLetters = new ArrayList<String>();
	static boolean checker = false; // if letter is in word
	static boolean gameOver = false; // if game is over
	static ArrayList<Boolean> booleanArrayList = new ArrayList<Boolean>();

    /*
     *The main program
     *
     * @param   args  command line arguments (ignored)
     */

	public static void main(String[] args) {

		Random ran = new Random();

		try {

			// use the argument as file to read from
			File dictFile = new File(args[0]); 

			Scanner sc = new Scanner(dictFile).useDelimiter("\\n");

			// read text file
			while (sc.hasNext()) {
				dictionary.add(sc.next()); // add word to dictionary
			}

			int index = ran.nextInt(dictionary.size());
			String[] dictionary_array = dictionary.toArray(new String[dictionary.size()]);
			wordToGuess = dictionary_array[index]; // choose random word 

			String[] lettersInWord = wordToGuess.split(""); // store letters

			// create list of booleans for every letter
			for(int i=0; i<lettersInWord.length;i++) {
				booleanArrayList.add(false);				
			}

			// change arraylist to array for indexing
			Boolean[] booleanArray = booleanArrayList.toArray(new Boolean[booleanArrayList.size()]);

			System.out.println("Remaining guesses: " + guessCount);

			System.out.println("                      ###");
			System.out.println("                      ###");
			System.out.println("                       #");
			System.out.println("                     #####");
			System.out.println("                    # ### #");
			System.out.println("                      ###");
			System.out.println("                      # #");
			System.out.println("                     ##  ##");
			System.out.println("##############################");
			System.out.println("##                          ##");   
			System.out.println("##                          ##");

			// while there are still guesses left, keep prompting user to guess
			while (guessCount > 0) {
				guessLetter(lettersInWord, booleanArray);

				// if all letters are found, tell user and end game
				if (!Arrays.asList(booleanArray).contains(false)) {
					System.out.println("You guessed the whole word -- \"" + wordToGuess.toUpperCase() + "\" -- correctly. You WIN! :D");
					gameOver = true;
					break;
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace(); // catch a filenotfoundexception
		}
	}

	 /*
     * Given two arrays -- one containing letters in the word to guess and 
     * one with boolean values of whether it has been found --, check whether
     * the user input/guess matches a letter in the word.
     *
     * @param   lettersInWord	array of letters
     * @param	booleanArray    array of boolean values
     */

	public static void guessLetter(String[] lettersInWord, Boolean[] booleanArray) {

		Scanner userReader = new Scanner(System.in); 
		String letterGuessString = "";

		System.out.println("RULE: Only one character/letter per guess.");
		System.out.println("GUESS a letter for a " + lettersInWord.length + "-letter long word:");
		System.out.println("You can also type in the whole word if you want to guess it.");
		System.out.print(">>>>>>> ");
		
		letterGuessString = userReader.nextLine(); // read user guess
		letterGuessString = letterGuessString.toLowerCase(); // make sure all cases are the same

		// check every letter
		for (int i=0; i<lettersInWord.length;i++) {
			// if user guesses the whole word, win and end game
			if (letterGuessString.equals(wordToGuess)) {
				System.out.println("You guessed the whole word -- \"" + wordToGuess.toUpperCase() + "\" -- correctly. You WIN! :D");
				gameOver = true;
				break;
			}
			// if user guess is valid and correct, add to array and mark true
			if ((letterGuessString.length() == 1) && (letterGuessString.matches("[a-zA-Z]"))) {
				if ((booleanArray[i].equals(false)) && (letterGuessString.equals(lettersInWord[i]))) {
						booleanArray[i] = true;
						correctLetters.add(lettersInWord[i]);
						checker = true;	
				} 
			} else {
				checker = false;
			}
			// tell user which letters were guessed correctly
			System.out.println("letter #" + (i+1) + " correct === " + booleanArray[i]);
		} 

		// if game isn't over, tell user status of game
		if (!gameOver) {		

			System.out.println("Correct letters: " + correctLetters);
			guessCount--;
			System.out.println("Remaining guesses: " + guessCount);

			// draw the current scene/hangman
			if (checker) {
					drawHangman();
			} else {
				drawHangman();
			}
			checker = false;
		}
	}

	/*
     * Draw the appropriate scene/hangman that corresponds to the number of 
     * wrong attempts left for the user/player.
     *
     * @param   lettersInWord	array of letters
     * @param	booleanArray    array of boolean values
     */

	public static void drawHangman() {
		// if user guesses wrong
		if (!checker) {
			System.out.println("WRONG");

			// print out the current scene, hangman depending on number of wrong
			switch(wrongCount) {
				case 8: {     
				    System.out.println("                       #");
				    System.out.println("                     #####");
				    System.out.println("                    # ### #");
				    System.out.println("                      ###");
				    System.out.println("                      # #");
				    System.out.println("                     ##  ##");
				    System.out.println("##############################");
				    System.out.println("##                          ##");   
				    System.out.println("##                          ##"); 
				    wrongCount--;
				    break;   
				}
				case 7: {
				    System.out.println("                     #####");
				    System.out.println("                    # ### #");
				    System.out.println("                      ###");
				    System.out.println("                      # #");
				    System.out.println("                     ##  ##");
				    System.out.println("##############################");
				    System.out.println("##                          ##");   
				    System.out.println("##                          ##");
				    wrongCount--; 
				    break;    
				}
				case 6: {
				    System.out.println("                    # ### #");
				    System.out.println("                      ###");
				    System.out.println("                      # #");
				    System.out.println("                     ##  ##");
				    System.out.println("##############################");
				    System.out.println("##                          ##");   
				    System.out.println("##                          ##");
				    wrongCount--; 
				    break;    
				}
				case 5: {
				    System.out.println("                      ###");
				    System.out.println("                      # #");
				    System.out.println("                     ##  ##");
				    System.out.println("##############################");
				    System.out.println("##                          ##");   
				    System.out.println("##                          ##"); 
				    wrongCount--;
				    break;    
				}
				case 4: {
				    System.out.println("                      # #");
				    System.out.println("                     ##  ##");
				    System.out.println("##############################");
				    System.out.println("##                          ##");   
				    System.out.println("##                          ##");  
				    wrongCount--;
				    break;   
				}
				case 3: {
				    System.out.println("                     ##  ##");
				    System.out.println("##############################");
				    System.out.println("##                          ##");   
				    System.out.println("##                          ##");  
				    wrongCount--;
				    break;   
				}
				case 2: {
				    System.out.println("##############################");
				    System.out.println("##                          ##");   
				    System.out.println("##                          ##");
				    wrongCount--;
				    break;     
				}
				case 1: {
					System.out.println("##                          ##");   
				    System.out.println("##                          ##"); 
				    wrongCount--;
				    System.out.println("GAME OVER. You lose. The word was: " + wordToGuess);
				    gameOver = true;
				    break;    
				}
			}
			if (guessCount == 0) {
				System.out.println("You have run out of attempts!");
			}
		} 
	}
}


