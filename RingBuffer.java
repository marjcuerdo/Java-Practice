/**
 * RingBuffer.java
 *
 * @version   $Id: RingBuffer.java,v 1.1 2017/11/12 21:30 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

public class RingBuffer {
	
	static volatile int k, l, n;
	static volatile Object[] ringBufHolder;
	static final Object obj = new Object();
	static int index = 0;
	static volatile int item = 0;
	static volatile boolean end = false;
	static volatile int counter = 0;

	public static void main(String[] args) throws InterruptedException{

		System.out.println("Main thread is starting.");

		if (args.length < 3) {
			System.out.println("You didn't provide enough arguments.\n" +
				"Usage: java RingBuffer [#ofProducers] [#ofConsumers] [lengthOfBuffer]");
			System.exit(0);
		}
		for (int i=0; i<args.length;i++) {
			switch(i) {
				case 0:
					k = Integer.valueOf(args[0]);
					System.out.println("No. of Producers: " + String.valueOf(k));
					break;
				case 1:
					l = Integer.valueOf(args[1]);
					System.out.println("No. of Consumers: " + String.valueOf(l));
					break;
				case 2:
					n = Integer.valueOf(args[2]);
					System.out.println("Length of Ring Buffer: " + String.valueOf(n) + "\n");
					ringBufHolder = createRing(n);
					break;
				default:
					System.out.println("There aren't any arguments provided.");
					System.exit(0);
			}
		}

			for (int i=1; i<k+1; i++) {
				new Producer("Producer " + String.valueOf(i) + " Thread", obj, i);
			}
			for (int i=1; i<l+1; i++) {
				new Consumer("Consumer " + String.valueOf(i) + " Thread", obj, i);
			}
			if (end) {
				// print array of results
				System.out.println("\n\n\n Printing array results...");
				for (int i=0; i<n; i++) {
					System.out.println(i + ": " + ringBufHolder[i]);
				}
				System.exit(0);
			}
	}		

	public static Object[] createRing(int length) {
		return new Object[length];
	}
}