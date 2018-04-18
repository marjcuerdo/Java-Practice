/**
 * Producer.java
 *
 * @version   $Id: Producer.java,v 1.1 2017/11/12 21:31 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

public class Producer implements Runnable {

	Thread thrd;
	String name;
	Object obj;
	private int numOfItems;
	
	public Producer(String name, Object obj, int numOfItems) {
		this.name = name;
		this.obj = obj;
		this.numOfItems = numOfItems;
		thrd = new Thread(this, name);
		thrd.start();
	}

	public void run() {
		System.out.println(thrd.getName() + " starting.");
		System.out.println(thrd.getName() + " numOfItems: " + String.valueOf(numOfItems));

		synchronized(obj) {
			//try {

				for (int i=0; i < numOfItems; i++) {
					RingBuffer.item++;
					RingBuffer.ringBufHolder[RingBuffer.index] = RingBuffer.item;
					System.out.println(" PUT ITEM " + thrd.getName()  + " " + RingBuffer.ringBufHolder[RingBuffer.index] + ", ");
					RingBuffer.counter++;
					RingBuffer.index++;
				}
				//System.out.println();
				
				//obj.notify();
		
			//} catch (InterruptedException e) {
			//	e.printStackTrace();
			//} 
			if (numOfItems >= RingBuffer.n) {
				RingBuffer.end = true;
				thrd.interrupt();
			}
		}
	}
}