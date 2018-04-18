/**
 * Memory.java
 *
 * @version   $Id: Memory.java,v 1.3 2017/11/09 02:02 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.io.*;
import java.util.Scanner;

public class Memory {
	static int index = 0;
	static int memoryLimit = 50;
	static volatile Object[] mem_space = new Object[memoryLimit];
	static boolean isWaiting = false;
	static final Object obj = new Object();

	public static void main(String[] args) {
		System.out.println("Main thread starting.");

		WriterRead wrt1 = new WriterRead("Writer Thread", isWaiting, obj);
		ReaderWrite rdw1 = new ReaderWrite("Reader Thread", isWaiting, obj);
	}
}



