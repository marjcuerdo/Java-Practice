/**
 * ReaderWrite.java
 *
 * @version   $Id: ReaderWrite.java,v 1.3 2017/11/09 02:02 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.io.*;

public class ReaderWrite implements Runnable {

	Thread thrd;
	boolean isWaiting;
	String name;
	Object obj;


	public ReaderWrite(String name, boolean isWaiting, Object obj) {
		this.name = name;
		this.isWaiting = isWaiting;
		this.obj = obj;
		thrd = new Thread(this, name);
		thrd.start();
	}

	public void run() {
		System.out.println(thrd.getName() + " starting.");

		synchronized(obj) {
			try (Writer writer = new BufferedWriter(new OutputStreamWriter(
	              new FileOutputStream("output.txt"), "utf-8"))) {
				
				Memory.index = 0;

				while (Memory.mem_space[Memory.index] != null) {
					while (!Memory.isWaiting) {
						System.out.println("Reader thread is waiting...");
						obj.wait();
					}
					System.out.println("Writing to a file...");
					Memory.index = 0;

					for (int i=0; i < Memory.memoryLimit-1; i++) {
						writer.write(Memory.mem_space[i].toString() + "\n");
						System.out.println(Memory.mem_space[i].toString());
					}

					writer.flush();
					Memory.isWaiting = false;
					obj.notify();
				}				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (NullPointerException e) {
				e.printStackTrace();
			}
		}
	}
}