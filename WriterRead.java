/**
 * WriterRead.java
 *
 * @version   $Id: WriterRead.java,v 1.3 2017/11/09 02:03 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.io.*;
import java.util.Scanner;

public class WriterRead implements Runnable {
	
	Thread thrd;
	boolean isWaiting;
	String name;
	Object obj;

	public WriterRead(String name, boolean isWaiting, Object obj) {
		this.name = name;
		this.isWaiting = isWaiting;
		this.obj = obj;
		thrd = new Thread(this, name);
		thrd.start();
	}

	public void run() {
		System.out.println(thrd.getName() + " starting.");

		synchronized(obj) {
			try {
				Scanner reader = new Scanner(System.in);
				System.out.println("Enter the filename (with .txt): ");
				String fileName = reader.next();
				reader.close();

				FileReader fileReader = new FileReader(fileName);

				BufferedReader buf = new BufferedReader(fileReader);

				String line = null;

				while(((line = buf.readLine()) != null) | (Memory.index < Memory.memoryLimit)) {
					if (Memory.index == Memory.memoryLimit)  {
						System.out.println("Shared memory is full!");
						System.out.println("Writer is waiting...");
						obj.notify();
						Memory.isWaiting = true;
						while (Memory.isWaiting) {
							obj.wait();
						}
					}

					Memory.mem_space[Memory.index] = line;
					System.out.println(Memory.mem_space[Memory.index]);
					Memory.index++;
					if (line == null) {
						System.out.println("ENDING FILE.");
						obj.notify();
						Memory.isWaiting = true;
						break;
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}