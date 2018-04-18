/**
 * JavaRunTimeVersion.java
 *
 * @version   $Id: JavaRunTimeVersion.java,v 1.5 2017/08/30 14:49:46 Marjorie Ann M. Cuerdo $
 *
 * Revisions:
 *
 *	Revision 1.5  2017/08/30 14:50:45 MMC
 *	Revision for lab submission
 *
 */

import java.util.Properties;

/* 
 * This program prints out the JAva Runtime Environment version number.
 * This program is a revision of given code in the CSCI 605 -
 * Advanced Object Oriented Programming Class.
 *
 * @author		Marjorie Ann M. Cuerdo
 */

class JavaRunTimeVersion {

	/*
	 *The main program
	 *
	 * @param	args	command line arguments (ignored)
	 */

    public static void main (String args []) { 
    	// prints out the version number
		System.out.printf("Java Version: %s\n", System.getProperty("java.version").toString());
    }

}