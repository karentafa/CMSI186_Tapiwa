/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  Tapiwa Tafa
 *  Date          :  2017-01-19
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Fill in methods to make the program actually work
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {

   private static final int A    = 1;
   private static final int B   = A   + 1;
   private static final int C   = B   + 1;
   private static final int D   = C   + 1;
   private static final int E   = D   + 1;
   private static final int F   = E   + 1;
   private static final int G   = F   + 1;
   private static final int H   = G   + 1;
   private static final int I   = H   + 1;
   private static final int J   = I   + 1;
   private static final int K   = J   + 1;
   private static final int L   = K   + 1;
   private static final int M    = L   + 1;
   private static final int N   = M   + 1;
   private static final int O   = N   + 1;
   private static final int P   = O   + 1;
   private static final int Q   = P   + 1;
   private static final int R   = Q   + 1;
   private static final int S   = R   + 1;
   private static final int T   = S   + 1;
   private static final int U   = T   + 1;
   private static final int V   = U   + 1;
   private static final int W   = V   + 1;
   private static final int X   = W   + 1;
   private static final int Y   = X   + 1;
   private static final int Z   = Y   + 1;

  /**
   * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
   * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
   * it gets included.
   *
   * @param s String containing the data to be checked for &quot;vowel-ness&quot;
   * @return  boolean which is true if there is a vowel, or false otherwise
   */
   public static boolean containsVowel( String s ) {

      String check = s.toLowerCase();

      if(check.contains("a") || check.contains("e") || check.contains("i") || check.contains("o") || check.contains("u") || check.contains("y") ) {

         return true;
      }

      if (!check.contains("a") && !check.contains("e") && !check.contains("i") && !check.contains("o") && !check.contains("u") && !check.contains("y")) {

         return false;

      } else {

      return false;
    }
   }

  /**
   * Method to determine if a string is a palindrome.  Does it the brute-force way, checking
   * the first and last, second and last-but-one, etc. against each other.  If something doesn't
   * match that way, returns false, otherwise returns true.
   *
   * @param s String containing the data to be checked for &quot;palindrome-ness&quot;
   * @return  boolean which is true if this a palindrome, or false otherwise
   */
   public static boolean isPalindrome( String s ) {
    
    String rev = new StringBuilder(s).reverse().toString();
    if (rev.equals(s)) {

      return true;
    } else {

      return false;
    }

   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
   * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input
   */
   public static String evensOnly( String s ) {
    
      String result = new String();

      for (int i = 0; i < s.length(); i++)  {

         char c = s.charAt(i);

         if (c == 'B' || c == 'D' || c == 'F' || c == 'H' || c == 'J' || c == 'L' || c == 'N'  || c == 'P' || c == 'R' || c == 'T' || c == 'V' || c == 'X' || c == 'Z' 
            || c == 'b' || c == 'd' || c == 'f' || c == 'h' || c == 'j' || c == 'l' || c == 'n'  || c == 'p' || c == 'r' || c == 't' || c == 'v' || c == 'x' || c == 'z' 

            ) {

            result += new Character(c).toString();
         } 
   
      }

      return result ;

   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
   * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input
   */
   public static String oddsOnly( String s ) {

   String result = new String();

      for (int i = 0; i < s.length(); i++)  {

         char c = s.charAt(i);

         if (c == 'A' || c == 'C' || c == 'E' || c == 'G' || c == 'I' || c == 'K' || c == 'M'  || c == 'O' || c == 'Q' || c == 'S' || c == 'U' || c == 'W' || c == 'Y' 
            || c == 'a' || c == 'c' || c == 'e' || c == 'g' || c == 'i' || c == 'k' || c == 'm'  || c == 'o' || c == 'q' || c == 's' || c == 'u' || c == 'w' || c == 'y' 

            ) {

            result += new Character(c).toString();
         } 

   
      }

      return result ;




   }

   public static String removeDuplicates(String str) {

   String str2 = "" + str.charAt(0);
    for (int i = 1; i < str.length(); i++) {
        if (str.charAt(i - 1) == str.charAt(i) && i != 0) {
            continue;
        }
        str2 = str2 + str.charAt(i);
    }
    return str2;
}



  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input without duplicates
   */
   public static String evensOnlyNoDupes( String s ) {



      String result = new String();

          for (int i = 0; i < s.length(); i++) {

            evensOnly(s);


            String str2 = "" + s.charAt(0);

               for (int j = 1; j < s.length(); j++) {
                  if (s.charAt(j - 1) == s.charAt(j) && j != 0) {
                    continue;
                  }

                    str2 = s + s.charAt(j);
               }
                result = evensOnly(str2);

            
          }
          return result; 



      

/**String result = new String("");

          for (int i = 0; i < s.length(); i++) {
 
             if (removeDuplicates(s).contains(evensOnly(s))) {

              result = result + removeDuplicates(s).contains(evensOnly(s));
             
             }
         }

         return result ;**/

}
   

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * @param s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input without duplicates
   */
   public static String oddsOnlyNoDupes( String s ) {

      return oddsOnly(s);

     


   }

  /**
   * Method to return the reverse of a string passed as an argument
   *
   * @param s String containing the data to be reversed
   * @return  String containing the reverse of the input string
   */
   public static String reverse( String s ) {

      String rev = new StringBuilder(s).reverse().toString();

      return rev;
    

}

  /**
   * Main method to test the methods in this class
   *
   * @param args String array containing command line parameters
   */
   public static void main( String args[] ) {
      String blah = new String( "Blah blah blah" );
      String woof = new String( "BCDBCDBCDBCDBCD" );
      String pal1 = new String( "a" );
      String pal2 = new String( "ab" );
      String pal3 = new String( "aba" );
      String pal4 = new String( "amanaplanacanalpanama" );
      String pal5 = new String( "abba" );
      System.out.println( containsVowel( blah ) );
      System.out.println( containsVowel( woof ) );
      System.out.println( isPalindrome( pal1 ) );
      System.out.println( isPalindrome( pal2 ) );
      System.out.println( isPalindrome( pal3 ) );
      System.out.println( isPalindrome( pal4 ) );
      System.out.println( isPalindrome( pal5 ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REHEARSALSZ" ) );
      System.out.println( "evensOnly()        returns: " + evensOnly( "REhearSALsz" ) );
      System.out.println( "evensOnlyNoDupes() returns: " + evensOnlyNoDupes( "REhearSALsz" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "xylophones" ) );
      System.out.println( "oddsOnly()         returns: " + oddsOnly( "XYloPHonES" ) );
      System.out.println( "oddsOnlyNoDupes()  returns: " + oddsOnlyNoDupes( "XYloPHonES" ) );
      System.out.println( "reverse()          returns: " + reverse( "REHEARSALSZ" ) );
   }
}
