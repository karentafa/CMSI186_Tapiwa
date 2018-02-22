
/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        : Tapiwa Tafa
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private int sides;
   private Die[] ds = null;

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      ds = new Die[ count ];

      if (count < 1) {
          throw new IllegalArgumentException("has to be 1 or bigger");
      }
         if (sides < 4) {
              throw new IllegalArgumentException("choose more than 4 sides");
         }
              this.count = count;
              this.sides = sides;

    for (int i = 0; i < count; i++) {
              
              ds[i] = new Die(sides);
              ds[i].roll();
    }
   }

  /**
   * @return the sum of all the dice values in the set
   */
   public int sum() {

   	 int mysum = 0;
   
         for (int i = 0; i < count; i++) {
     
               mysum += ds[i].getValue();
         }
              return mysum;
      
   }

  /**
   * Randomly rolls all of the dice in this set
   *  NOTE: you will need to use one of the "toString()" methods to obtain
   *  the values of the dice in the set
   */
   public void roll() {

   	 for( int i = 0; i < ds.length; i++ ) {
     
         ds[i].roll();
     }
   }

  /**
   * Randomly rolls a single die of the dice in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @trhows IllegalArgumentException if the index is out of range
   */

   public int rollIndividual( int dieIndex ) {
   	
   	     ds[dieIndex - 1].roll(); 
     
              return ds[dieIndex - 1].getValue();


   }

  /**
   * Gets the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @trhows IllegalArgumentException if the index is out of range
   */
   public int getIndividual( int dieIndex ) {
     
      return ds[dieIndex - 1].getValue();
   }

  /**
   * @return Public Instance method that returns a String representation of the DiceSet instance
   */
   public String toString() {
     
     String result = "";
         for ( int i = 0; i < count; i ++ ) {
       
             result += ds[i].toString();
     
           }
     return result;
   }

  /**
   * @return Class-wide version of the preceding instance method
   */
   public static String toString( DiceSet ds ) {


       return ds.toString();
   }

  /**
   * @return  tru iff this set is identical to the set passed as an argument
   */
   public boolean isIdentical( DiceSet ds ) {

   	   if (ds.sum() == sum()) {

   	   	return true;
        }    

        else { 
        	return false;
        }
   	   } 
   	   
      
  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {

    System.out.println( "TESTING THE DICESET CLASS: TEST CONSTRUCTOR FOR 3 SIX-SIDED DICE:" );
      System.out.println( "  DiceSet: 3 dice, six sided - ds36:" );
      DiceSet ds36 = new DiceSet( 3, 6 );
      System.out.println( "      initialized ds36 contents             : " + ds36.toString() );
      ds36.roll();
      System.out.println( "      after collective roll ds36 contents   : " + ds36.toString() );
      ds36.rollIndividual( 2 );
      System.out.println( "      after individual roll(2) ds36 contents: " + ds36.toString() );
      System.out.println( "      sum of dice values is: " + ds36.sum() );
      System.out.println( "   Re-rolling all dice" );
      ds36.roll();
      System.out.println( "      after collective roll ds36 contents   : " + ds36.toString() );
      ds36.rollIndividual( 2 );
      System.out.println( "      after individual roll(2) ds36 contents: " + ds36.toString() );
      System.out.println( "      sum of dice values is                 : " + ds36.sum() );
      System.out.println( "   Test of getIndividual(): ");
      System.out.println( "      value of die at index 0: " + ds36.getIndividual( 0 ) );
      System.out.println( "      value of die at index 1: " + ds36.getIndividual( 1 ) );
      System.out.println( "      value of die at index 2: " + ds36.getIndividual( 2 ) );

      System.out.println( "TESTING THE DICESET CLASS: TEST CONSTRUCTOR FOR 6 NINE-SIDED DICE:" );
      System.out.println( "   DiceSet: 6 dice, nine sided - ds69:" );
      DiceSet ds69 = new DiceSet( 6, 9 );
      System.out.println( "      initialized ds36 contents             : " + ds69.toString() );
      ds69.roll();
      System.out.println( "      after collective roll ds69 contents   : " + ds69.toString() );
      ds69.rollIndividual( 2 );
      System.out.println( "      after individual roll(2) ds69 contents: " + ds69.toString() );
      System.out.println( "      sum of dice values is                 : " + ds69.sum() );
      System.out.println( "   Re-rolling all dice" );
      ds69.roll();
      System.out.println( "      after collective roll ds69 contents   : " + ds69.toString() );
      ds69.rollIndividual( 3 );
      System.out.println( "      after individual roll(3) ds69 contents: " + ds69.toString() );
      System.out.println( "      sum of dice values is                 : " + ds69.sum() );
      System.out.println( "   Test of getIndividual(): ");
      System.out.println( "      value of die at index 0: " + ds69.getIndividual( 0 ) );
      System.out.println( "      value of die at index 1: " + ds69.getIndividual( 1 ) );
      System.out.println( "      value of die at index 2: " + ds69.getIndividual( 2 ) );
      System.out.println( "      value of die at index 3: " + ds69.getIndividual( 3 ) );
      System.out.println( "      value of die at index 4: " + ds69.getIndividual( 4 ) );
      System.out.println( "      value of die at index 5: " + ds69.getIndividual( 5 ) );

      System.out.println( "TESTING THE DICESET CLASS: TEST CONSTRUCTOR FOR 9 SEVENTEEN-SIDED DICE:" );
      System.out.println( "   DiceSet: 9 dice, 17 sided - ds917:" );
      DiceSet ds917 = new DiceSet( 9, 17 );
      System.out.println( "      initialized ds36 contents              : " + ds917.toString() );
      ds917.roll();
      System.out.println( "      after collective roll ds917 contents   : " + ds917.toString() );
      ds917.rollIndividual( 6 );
      System.out.println( "      after individual roll(6) ds917 contents: " + ds917.toString() );
      System.out.println( "      sum of dice values is                  : " + ds917.sum() );
      System.out.println( "   Re-rolling all dice" );
      ds917.roll();
      System.out.println( "      after collective roll ds917 contents   : " + ds917.toString() );
      ds917.rollIndividual( 8 );
      System.out.println( "      after individual roll(8) ds69 contents : " + ds917.toString() );
      System.out.println( "      sum of dice values is                  : " + ds917.sum() );
      System.out.println( "   Test of getIndividual(): ");
      System.out.println( "      value of die at index 0: " + ds917.getIndividual( 0 ) );
      System.out.println( "      value of die at index 1: " + ds917.getIndividual( 1 ) );
      System.out.println( "      value of die at index 2: " + ds917.getIndividual( 2 ) );
      System.out.println( "      value of die at index 3: " + ds917.getIndividual( 3 ) );
      System.out.println( "      value of die at index 4: " + ds917.getIndividual( 4 ) );
      System.out.println( "      value of die at index 5: " + ds917.getIndividual( 5 ) );
      System.out.println( "      value of die at index 6: " + ds917.getIndividual( 6 ) );
      System.out.println( "      value of die at index 7: " + ds917.getIndividual( 7 ) );
      System.out.println( "      value of die at index 8: " + ds917.getIndividual( 8 ) );


   }

}

