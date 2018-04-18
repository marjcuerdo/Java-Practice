/*
 * Maze.java
 *
 * @version   $Id: Maze.java,v 1.7 2017/09/24 18:58 $
 *
 * Revisions:
 *
 *  None.
 * 
 * This class is reads a text file and creates a maze to solve,
 * using left-hand wall follower algorithm.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Maze {

	static public int column = 0;
	static public int row = 0;
	static public int depth = 1;
	static public String[][][] char3d ;
	static public boolean[][][] visited;
	static public int cF = 1;
	static public int cR = 0;
	static public int cC = 1;
	static public boolean findingPath = false;

	/*
     *The main program
     *
     * @param   args  command line arguments (ignored)
     */

	public static void main(String[] args) throws FileNotFoundException {
		File mazeFile = new File(args[0]); 
		Scanner scnr = new Scanner(mazeFile);
		String contentLine = "";
		ArrayList<String> charArrayList = new ArrayList<String>();

		while (scnr.hasNextLine()) {
			contentLine = scnr.nextLine();
			String[] lines = contentLine.split("");
			column = contentLine.length();
			if ((depth == 1) && (!contentLine.equals(""))){
				row++;
			}
			if (contentLine.equals("")) {
				depth++;
			} else {
				for (int i=0; i < lines.length; i++) {
					charArrayList.add(lines[i]);
					System.out.print(lines[i]);
				}
				System.out.println();
			}
		}

		System.out.println(charArrayList);

		// print out values for array
		System.out.println("depth: " + depth);
		System.out.println("row: " + row);
		System.out.println("column: " + column);

		// creating 3d array object
		char3d = new String[depth][row][column];
		visited = new boolean[depth][row][column];

		String[] charArray = charArrayList.toArray(new String[charArrayList.size()]);

		// STORING INTO 3D ARRAY and init the 
		int indexer = 0;
		for (int i=0; i < depth; i++) {
			for (int j=0; j < row; j++) {
				for (int k=0; k < column; k++) {
					char3d[i][j][k] = charArray[k+indexer];
					visited[i][j][k] = false;
					System.out.print(charArray[k+indexer]);
				}
				indexer+=(column);
				System.out.println();
			}
		}

		System.out.println("FINDING PATH...");

		visited[cF][cR][cC] = true;
		char3d[cF][cR][cC] = "~";

		// keep trying to find path while not solved yet
		while (!findingPath) {
			findPath(char3d);
		}

		// PRINTING path rescult
		int indexer2 = 0;
		for (int i=0; i < depth; i++) {
			for (int j=0; j < row; j++) {
				for (int k=0; k < column; k++) {
					System.out.print(char3d[i][j][k]);
				}
				indexer2+=(column);
				System.out.println();
			}
		}
	}

	// solve maze by finding path (left-hand)
	static void findPath(String[][][] char3d) {

		System.out.println("cF: " + cF);
		System.out.println("cR: " + cR);
		System.out.println("cC: " + cC + "\n"); // debugging print statements

		if ( (cF > depth-1) || (cF < 0) || (cR > row-2) || (cC > column-2) ) {
			findingPath = true;
		} else if (char3d[cF][cR][cC+1].equals(".") && (char3d[cF][cR-1][cC+1].equals("#") || char3d[cF][cR-1][cC].equals("#"))) {
			if (visited[cF][cR][cC+1] == false) {
				char3d[cF][cR][cC+1] = "~"; // go right/east
				visited[cF][cR][cC+1] = true;
				cC++;
				System.out.println("1");
			}
		} else if (char3d[cF][cR+1][cC].equals(".") && char3d[cF][cR][cC+1].equals("#")) {
			if (visited[cF][cR+1][cC] == false) {
				char3d[cF][cR+1][cC] = "~"; // go down/south
				visited[cF][cR+1][cC] = true;
				cR++;
				System.out.println("2");
			}
		}  else if (char3d[cF][cR-1][cC].equals(".")) {
			if (visited[cF][cR-1][cC] == false) {
				char3d[cF][cR-1][cC] = "~"; // go up/backwards
				visited[cF][cR-1][cC] = true;
				cR--;
				System.out.println("3");
			}
		} else if (cF+1 <= depth-1) {
			if (char3d[cF+1][cR][cC].equals(".")) {
				if (visited[cF+1][cR][cC] == false) {
					char3d[cF+1][cR][cC] = "~"; // go up a floor
					visited[cF+1][cR][cC] = true;
					cF++;
					System.out.println("4");
				}
			}
		} else if (cF-1 >= 0) {
			if (char3d[cF-1][cR][cC].equals(".")) {
				if (visited[cF-1][cR][cC] == false) {
					char3d[cF-1][cR][cC] = "~"; // go down a floor
					visited[cF-1][cR][cC] = true;
					cF--;
					System.out.println("5");
				}
			}
		} else {
			System.out.println("Failed to get out.");
			findingPath = true;
		}
	}
}