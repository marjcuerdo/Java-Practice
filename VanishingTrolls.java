/**
 * VanishingTrolls.java
 *
 * @version   $Id: VanishingTrolls.java,v 1.1 2017/11/05 19:00 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.util.ArrayList;
import java.util.Random;

public class VanishingTrolls extends Thread {

	private static Object obj = new Object();
	private int index;
	private boolean check = false;
	private static int numOfTrolls = 0;
	private static int numOfCookies = 0;
	private static ArrayList<VanishingTrolls> trolls1 = new ArrayList<VanishingTrolls>();
	public static ArrayList<VanishingTrolls> trolls2 = new ArrayList<VanishingTrolls>();

  /**
   * The main program.
   *
   * @param    args    command line arguments (ignored)
   */

	public static void main(String args[]) {

		String number = args[0];

		VanishingTrolls trollObj = new VanishingTrolls();

		int players = Integer.parseInt(number);
		numOfTrolls = players;
		System.out.println(numOfTrolls + " trolls are present");

		for (int i = 0; i < numOfTrolls; i++) {
			new VanishingTrolls(i).start();
		}
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		trollObj.statusCheck();
		System.out.println();

		while (numOfTrolls > 1) {
			try {
				sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			for (int i = 0; i < trolls2.size(); i++) {
				new VanishingTrolls(trolls2.get(i).index).start();
			}
			trolls2.clear();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			trollObj.statusCheck();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		if (numOfTrolls == 1) {
			trollObj.statusCheck();
		}
	}

  /**
   * Checks which trolls have cookies or not
   */

	private void statusCheck() {

		numOfCookies = 0;
		if (numOfTrolls > 2) {
			
			for (int i = 0; i < trolls1.size(); i++) {
				if (trolls1.get(i).check == false) {
					System.out.println("\t" + "Troll #" + (trolls1.get(i).index + 1)
							+ " vanished!");
				}
			}
			numOfTrolls = numOfTrolls - 1;
			System.out.println();
			System.out.println(numOfTrolls + " trolls are still present");
			System.out.print("\t");
			for (int count = 0; count < trolls1.size(); count++) {
				if (trolls1.get(count).check == true) {
					System.out.print((trolls1.get(count).index + 1) + "  ");
					trolls2.add(trolls1.get(count));
				}
			}

			System.out.println();
			trolls1.clear();
		} else {
			System.out.println("WINNER: "
					+ "Troll #" + (trolls1.get(randomPicker()).index + 1));
			System.exit(0);
		}
	}

   /**
   * Prints the current troll
   */

	public String toString() {
		return "Troll " + (this.index);
	}

   /**
   * Constructor that initializes the troll alues
   */

	public VanishingTrolls(int index) {
		this.index = index;
		this.check = true;
	}

   /**
   * Constructor 
   */

	public VanishingTrolls() {

	}

  /**
   * Picks a random troll
   */

	public int randomPicker() {
		Random ran = new Random();

		int index = ran.nextInt(trolls1.size());
		System.out.println("(Random pick: " + String.valueOf(index) + ")");
		return index;
	}

  /**
   * Override run()
   */
	public void run() {
		synchronized (obj) {

			if (this.check == true && numOfCookies < numOfTrolls - 1) {
				trolls1.add(this);
				numOfCookies++;
			} else {
				VanishingTrolls vanTrol = trolls1.get(randomPicker());
				vanTrol.check = false;
				trolls1.add(vanTrol);
				numOfCookies++;
			}
		}
	}

	
}
