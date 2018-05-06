/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Tuple.java
 * Purpose    :  Program to represent a tuple of integers, indexed from zero
 * @author    :  Professor Don Murphy
 * @author    :  B.J. Johnson totally ripped off from the original
 * Date       :  2017-04-19
 * Description:  This program provides a "Tuple" class which is basically a set of "n" integers that are
 *                handled as a unit.  This class is intended to be used as part of homework 7, the coin
 *                changemaker, which is a "Dynamic Programming" algorithm.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson  Initial release; stolen blatently from Professor Don Murphy with his
 *                                    express permission and blessing; just added this comment block
 *  1.1.0  2017-04-28  B.J. Johnson  Added complete JavaDocs; added "throws" clauses to the methods that
 *                                    use them; added explanatory notes to comments; fixed hashCode() to
 *                                    start product at "1" instead of "0" to prevent all codes from being
 *                                    zero, and also checked to make sure that IMPOSSIBLE *does* return 0.
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;


public class Tuple {

  
   public static final Tuple IMPOSSIBLE = new Tuple(new int[0]);

   private int[] data;

  
   public Tuple( int n ) {
      if( n < 0 ) {
         throw new IllegalArgumentException();
      }

      data = new int[n];
      for( int i = 0; i < n; i++ ) {
         data[i] = 0;
      }
   }

  
   public Tuple( int[] data ) {
      if( data == null ) {
         throw new IllegalArgumentException();
      }

      this.data = new int[data.length];
      for( int i = 0; i < data.length; i++ ) {
         this.data[i] = data[i];
      }
   }

  
   public boolean isImpossible() {
      return this == IMPOSSIBLE;
   }

  
   public void setElement( int i, int j ) {
      checkIndex(i);
      data[i] = j;
   }

  
   public int getElement( int i ) {
      checkIndex(i);
      return data[i];
   }

  
   public int length() {
      return data.length;
   }

  
   public int total() {
      int sum = 0;
      for( int i = 0; i < length(); i++ ) {
         sum = sum + getElement(i);
      }

      return sum;
   }

   public Tuple add( Tuple t ) {

      if( length() != t.length()) {
         throw new IllegalArgumentException();
      }

      Tuple sum = new Tuple(length());
      for( int i = 0; i < length(); i++ ) {
         sum.setElement(i, getElement(i) + t.getElement(i));
      }

      return sum;
   }

  
   @Override
   public boolean equals(Object t) {
      if( (t == null) || !(t instanceof Tuple) || (length() != ((Tuple)t).length()) ) {
         return false;
      }

      for( int i = 0; i < length(); i++ ) {
         if( getElement(i) != ((Tuple)t).getElement(i) ) {
            return false;
         }
      }

      return true;
   }

  
   @Override
   public int hashCode() {
      int product = 0;
      for( int i = 0; i < length(); i++ ) {
         product = product * getElement(i);
      }
      return (product >= 0) ? product : -product;
   }

  
   @Override
   public String toString() {
      if( isImpossible()) {
         return "Impossible tuple";
      }

      String result = "<";
      for( int i = 0; i < length(); i++ ) {
         result += (i > 0 ? "," : "") + data[i];
      }
      return result + ">";
   }

   private void checkIndex(int i) {
      if( i < 0) {
         throw new IllegalArgumentException();
      }

      if( i >= length()) {
         throw new IllegalArgumentException();
      }
   }

}
