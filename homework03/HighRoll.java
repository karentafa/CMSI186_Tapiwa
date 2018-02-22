/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Demonstrates the use of input from a command line for use with Yahtzee
 *  Author        :  Tapiwa Tafa
 *  Date          :  2017-02-14
 *  Description   :  
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-14  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll{

   public static void main( String args[] ) {


      int count = Integer.parseInt(args[0]);
      int sides = Integer.parseInt(args[1]);
      int bestScore = 0;
      int mysum = 0;
      DiceSet myDiceSet = new DiceSet( count, sides );
      


      System.out.println( "\n   Welcome to the HighRoll!!\n" );
      System.out.println( "     Press the 'q' key to quit the program." );
      System.out.println( "     Press the 'k' key to ROLL ALL THE DICE" );
      System.out.println( "     Press the 'a' key to ROLL A SINGLE DIE" );
      System.out.println( "     Press the 'r' key to CALCULATE THE SCORE FOR THIS SET" );
      System.out.println( "     Press the 'e' key to SAVE THIS SCORE AS A HIGH SCORE" );
      System.out.println( "     Press the 'n' key to DISPLAY A HIGH SCORE" );
      System.out.println( "     Press the 'q' key to quit the program." );



     // This line uses the two classes to assemble an "input stream" for the user to type
     // text into the program
      BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
      while( true ) {
         System.out.print( ">>" );
         String inputLine = null;
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               System.out.println("enter some text!:");
            }
            System.out.println( "   You typed: " + inputLine );
            if( 'q' == inputLine.charAt(0) ) {
               break;
            }
                else if( 'k' == inputLine.charAt(0) ) {
                     return myDiceSet.roll();
                    System.out.println( myDiceSet.roll() );


                break; 
            }
            else if( 'a' == inputLine.charAt(0) ) {

                  
                break; 
            }
            else if( 'r' == inputLine.charAt(0) ) {
                     mysum = myDiceSet.sum();

                     System.out.println( mysum );
                break; 
            }
            else if( 'e' == inputLine.charAt(0) ) {

                    bestScore = mysum;
                    System.out.println(bestScore);
                break; 
            }
             else if( 'n' == inputLine.charAt(0) ) {

               System.out.println("your high score is: " + bestScore);


                break; 
            }
         }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException" );
         }
      }
   }
}
