/*
 * PiMultiThreaded.java
 *
 * @version   $Id: PiMultiThreaded.java,v 1.2 2017/10/29 14:40 $
 *
 * Revisions:
 *
 *  None.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

import java.io.*;
import java.nio.*;
import java.nio.channels.*;

/**
 * This program reads a file as an argument and counts the number of 
 * even and odd numbers present using multithreading.
 *
 * @author      Marjorie Ann Cuerdo
 */

/* HOMEWORK
Question: what is the optimal number of threads in relation ship to the number of cores a computer has.
Answer: Number of threads is equal to the number of cores computer has. In my case, 4.
FINAL COUNT
even = 499748
odd = 500251
odd/even = 1.0010045062711606
        3.33 real         2.64 user         2.81 sys
*/

public class PiMultiThreaded implements Runnable
{
    private FileChannel file_channel;
    private FileChannel write_channel;
    private int start_location;
    private int size1;
    static int odd_count1 = 0;
    static int even_count1 = 0;

  /**
   * The main program.
   *
   * @param    args[0]  file name to read from same directory
   */

    public static void main(String[] args)
        throws Exception
    {
        if ( args.length < 1 )  {
            System.err.println(
                 "Usage: /usr/bin/time java PiMultiThreaded [file path]\nOR\n" +
                 "cat [file path] | java PiMultiThreaded");
            System.exit(1);
        } else {
            FileInputStream str = new FileInputStream(args[0]);
            String b = "Is this written";
            FileChannel chnl = str.getChannel();
            ByteBuffer buff = ByteBuffer.wrap(b.getBytes());
            Thread t1 = new Thread(new PiMultiThreaded(0, 250000, chnl));
            Thread t2 = new Thread(new PiMultiThreaded(250000, 250000, chnl));
            Thread t3 = new Thread(new PiMultiThreaded(500000, 250000, chnl));
            Thread t4 = new Thread(new PiMultiThreaded(750000, 250000, chnl));
            t1.start();
            t2.start();
            t3.start();
            t4.start();
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            str.close();
            System.out.println("FINAL COUNT");
            System.out.println("even = " + even_count1);
            System.out.println("odd = " + odd_count1);
            System.out.println("odd/even = " + (double)odd_count1/(double)even_count1);
        }
    }

  /**
   * Thread constructor
   *
   * @param     start_location   start index for current thread
   * @param     size             size for buffer
   * @param     file             file channel
   * 
   */
    public PiMultiThreaded(int location, int size, FileChannel file)
    {
        start_location = location;
        size1 = size;
        file_channel = file;
    }

 /**
   * Overriding run method in for threads
   */

    public void run()
    {
        try
        {
            System.out.println("Reading the channel: " + start_location + ":" + size1);
            ByteBuffer buff = ByteBuffer.allocate(size1);
            file_channel.read(buff, start_location);

            String s = new String(buff.array());
            String s_array[] = s.split("");
            for (int i=0; i<s_array.length;i++) {
                System.out.println(s_array[i]);

                if (s_array[i].equals(".")) {
                } else if (Integer.parseInt(s_array[i])%2 == 0) {
                    even_count1++;
                } else if (Integer.parseInt(s_array[i])%2 == 1) {
                    odd_count1++;
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    
}