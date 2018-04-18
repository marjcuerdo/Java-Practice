/*
 * ConstantOrNot.java
 *
 * @version   $Id: ConstantOrNot.java,v 1.0 2017/09/15 10:07am $
 *
 * Revisions:
 *
 *  None.
 * 
 * This program will not compile. We analyzed what the
 * problems are in the code that causes this.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

class ConstantOrNot {
  //By using "final" in the declaration statement makes variable constant which means 
 //the compiler cannot change variable's value or use assignment operator with it.
   private final int aInt = 1; //variable's value can not be changed a constant variable
   private final String aString = "abc";//variable's value can not be changed a constant variable
   private       String bString = "abc";// variable's value can be changed not a constant variable
   private final String[] aArray = new String[7];//array in java is an object which is a  reference,   and when it is defined as a final that means the variable cannot be changed to refer to anything else, but the array’s element can be changed.

   public void doTheJob() {
       aInt = 3;// using assignment operator with a constant variable is not allowed
       aString = aString + "abc";//using assignment operator with a constant variable is not allowed
       aString = aString;//using assignment operator with a constant variable is not allowed
       aArray = new String[10];//aArray is declared before as a constant variable we can not declared it again
       bString = aString;// ok
       bString = aString + "def";//ok because bString is not final
       aArray[0] = "abc";//ok because the array’s element can be changed 
   }

    public static void main( String args[] ) {
       new ConstantOrNot().doTheJob();
    }
}




