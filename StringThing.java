/**
 * StringThing.java
 *
 * @version   $Id: StringThing.java,v 1.0 2017/09/10 3:02pm $
 *
 * Revisions:
 *
 *	None.
 *
 *
 * This assignment wants us to identify the bugs in the program and answer
 * questions about their functions. The topic is Strings.
 *
 * @author		Marjorie Ann M. Cuerdo
 */

/*
one of the most common operations that performed
on string type is the concatenation operation which is
done by using (+), and this sign is used to connect or 
join two string together or join a string with numeric 
values or character after converting them to string. 
And (+) operation starts from left to right.

*/
class StringThing {
  public static void method(String id, String literal, String aNewString)	{
	System.out.println("method!" + id + ". " + (literal == aNewString ));
  }
  public static void main( String args[] ) {
	String aString = "123";
	String bString = "123";
	int number = 3;
        /*
        a.  true; because it compares a string "123" with a string that is
        held in aString which is "123" and they are equal. The strings "123"
        when declared will point to the same address. 
        */
	System.out.println("a.  " +   (  "123" == aString  ) );
        /*
        b.false; the variable aString has the value "123" which points to a 
        different address than the variable number 
        */
	System.out.println("b.	" +   ( "12" + number == aString ) );
       /*
         It prints 12323 because the first 123 which is the value that holds by 
        aString variable and the second 23 is the value of the multiplication 
        operation 1*23 = 23. The (* )will be done first because it has higher
        priority than ( + )  after that the result form (*) operation will be 
        converted to a string by (+)  to join the aString value. 
        */
        
	System.out.println("c.  " +   aString  + 1 * 23 );
        /*
        d.1233123; the numeric value 123 will convert to string then it will be
        joined to the previous string  "d." by (+). And then join the value of 
        number variable which is numeric value also after converting it to 
        string.Finaly, adding the aString value which is string to the previous 
        string 1233.
        */
	System.out.println("d.	" +   123 + number + aString  );
        /*
        e.126123; First, the arithmetic operation  ( 123 + number ) will do 
        because of using parentheses, which have a higher priority than + to 
        join strings, the result will be 126, and then it will convert to a 
        string and connect it with the previous string "e. " Then the value 
        of the string variable will be connected to the  last string "e. 126 "
        */
        
	System.out.println("e.	" +   ( 123 + number ) + aString   );
        
        /*
        f.1213123; First ( 123 - 2 + "" +  number + aString ) will be done 
        because it has higher priority. Arithmetic subtraction will be done
        first 123 - 2 = 121. Then an empty string "" will add to 121 
        to convert it to from a numeric value to string value. Then, the value 
        of number will join the string "121"  after converting it to string 
        after that the value of aString will join 1213.
        */
	System.out.println("f.	" +   ( 123 - 2 + "" +  number + aString )  );
        /*
        g.369123; The Arithmetic multiplication will be done first,  because 
        it has higher priority 123 * number= 369 . Then It will be converted to
        a string and join "g." and the value of aString "123" will be added to 
        them after that.
       
        */
	System.out.println("g.	" +   123 * number + aString  );
       /* h.41123; The Arithmetic dividing will be done first, because 
        it has higher priority 123 / number = 41 . Then It will be converted to
        a string and join "h." and the value of aString "123" will be added to 
        them after that.
        
        */
	System.out.println("h.	" +   123 / number + aString  );
        
       /* i.120123; In the second parameter the arithmetic subtraction will be
        done first, because of using parentheses  123 - number = 120 . 
        Then It will be converted to a string and join "i." and the value of 
        aString "123" will be added to them after that.
        
        */
	System.out.println("i.	" +  ( 123 - number)  + aString  );
        /*
        method!1. true; The second parameter  "x" + "yz" will be sent as one 
        sting "xyz" ,becuse of using + to join strings, which is equal the first
        parameter.
        */
	method("1", "xyz", "x" + "yz");
		/*
		method!2. false; The third parameter is created by a new instance 
		object which will have a different reference address than the second
		parameter's "xyz". So even if you add "yz" to the new "x" String,
		that "xyz" will not be equal to the first "xyz".
		*/
	method("2", "xyz", new String("x") + "yz" );
        /* 
        method!3. true; The second parameter  "x" + "y" +"z" will be sent as one 
        sting "xyz" ,becuse of using + to join strings, which is equal the first
        parameter.
        */
	method("3", "xyz", "x" + "y" +"z");
        /*
        method!4. true; The first parameter will be" 123". In the second parameter 
        the 2 * 1 will be done first because of the priority and the result, 
        which is 2 will be converted to a string and connect to 1, and 3 will be
        joined to them after that, so the second parameter will be "123 "  which 
        is equal the first parameter.
        */
	method("4", "1" + "2" + "3", "1" + 2 * 1 + 3);
        /*
        method!5. true; The first parameter will be" 123". And the second 
        parameter will be " 123" fter convert number 2 and 3 to a string so the
        second parameter will be "123 " which is equal the first parameter.
       
        */
	method("5", "1" + "2" + "3", "1" + 2 + 3);
        /*
        method!6. true;The first parameter will be" 123".
        In the second parameter the arithmetic subtraction will be
        done first, because of using parentheses  3 - 1 = 2 . 
        Then It will be converted to a string and join "1" and then 3 as a 
        srting will be added to "12" and that makes the second parameter equal 
        The first parameter
        
        */
	method("6", "1" + "2" + "3", "1" + (3 - 1)  + 3);
  }
  /* #2. 	
   * "How many strings will be generated in the lines marked a) ... i) and 1. ... 6?"
   * - There will be 15 strings generated in the lines as the main and method
   * methods turn everything to Strings.
   * #3.
   * "When is the earliest moment the garbage collector can free up memory for 
   * each of the lines...?"
   * - The earliest that the garbage collector will free up memory is when bString
   * is set to the same value as aString. It will free up that memory space and make
   * bString point to the same address as aString in order to save up space.
   */

}


