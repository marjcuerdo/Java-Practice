/**
 * Consumer.java
 *
 * @version   $Id: Consumer.java,v 1.1 2017/11/12 21:31 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

public class Consumer implements Runnable {

	Thread thrd;
	String name;
	Object obj;
	private int numOfItems;
	private int eatIndex = 0;
	
	public Consumer(String name, Object obj, int numOfItems) {
		this.name = name;
		this.obj = obj;
		this.numOfItems = numOfItems;
		thrd = new Thread(this, name);
		thrd.start();
	}

	public void run() {
		System.out.println(thrd.getName() + " starting.");
		System.out.println(thrd.getName() + " numOfItems REMOVE: " + String.valueOf(numOfItems));

		synchronized(obj) {
			for (int i=0; i < numOfItems; i++) {
				if (eatIndex >= RingBuffer.n) {
				eatIndex = 0;
				i--;
				continue;
			} else if (RingBuffer.ringBufHolder[eatIndex] == null) {
				eatIndex++;
				i--;
				continue;
			} else {
				System.out.println(" REMOVED by " + thrd.getName() + "-- " + RingBuffer.ringBufHolder[eatIndex] + ", ");
				RingBuffer.ringBufHolder[eatIndex] = null;
				RingBuffer.counter--;
				eatIndex++;
				}
			}

			if (numOfItems >= RingBuffer.n) {
				RingBuffer.end = true;
				thrd.interrupt();
			}
		}
	}
}