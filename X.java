/*
 * X.java
 *
 * @version   $Id: X.java,v 1.0 2017/09/15 10:07am $
 *
 * Revisions:
 *
 *  None.
 * 
 * This program utilizes control structures. We analyzed what kind of 
 * output results from the previously written program.
 * 
 * @author    Marjorie Ann M. Cuerdo
 */

class X {

    public static void main( String args[] ) {
    
	int n = 0;
	
	here:
        
	while ( true )  {
         // First run for inside while loop:
        // n = 0 so (n != 3 is T ,  n != 5  is T)  (  n < 4 is T)  which makes all the conditions  true
       // Second run for inside while loop: n= 2 and that makes condition true
       //Third run for inside while loop: n= 5 which will make condition false, so complier can not execute
       // inside while loop any more and will move to the System.out.println( n % 2 == 0 ? *****)

		while ( ( ( n != 3 ) || ( n != 5 ) ) && ( n < 4 ) )  {
      //First run for while loop : increase n by 1 and then check the condition; n=1 , 1 not equal 0 makes condition false
     // Second run for while loop: n= 3, condition ++n == 0 false 
			if ( ++n == 0 )
				System.out.println("a/	n is " + n );
     //First run for inside while loop:
    // n=1 makes condition true  then n will be 2 and "b/n is 2" will be printed and the control will
   //go after the if block to print executing break here
  // Second run for inside while loop: n=3 != 1 so condition false and n will increase by 1 n=4
			else if ( n++ == 1 )    {
				System.out.println("b/	n is " + n );
   //Second run for inside while loop: n=4 makes condition false and then n will increase by 1 so n=5
  //control will move to the else statement.
			} else if ( n++ == 2 )
				System.out.println("c/	n is " + n );
 //Second run for inside while loop: n=5 and "d/n is 5" will be printed and control will move outside If block
			else 
				System.out.println("d/	n is " + n );
 //After First run for inside while loop: " executing break here  " will be printed
//After Second run for inside while loop:" executing break here  "  will be printed and ( ( n != 3 ) || ( n != 5 ) ) && ( n < 4 ) is not valid any more 
			System.out.println("	executing break here");

		}
// After Third checking for the inside while loop condition when n=5, this statement will execute
//n=5: n % 2 =1 , makes condition false then compiler will execute this statement ( n % 3 != 0 ? "3" : "!3" ).
//n=5: n % 3 =2 , makes condition true so "3" will be printed.
		System.out.println( n % 2 == 0 ?
					( n == 4 ? "=" : "!" )
				      : ( n % 3 != 0 ? "3" : "!3" ));
 //break here; to break the outside while loop which is always true so the outside loop will stop at this point
		break here;
	}
    }
}





