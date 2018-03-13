/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.text.DecimalFormat;

public class Clock {
  /**
   *  Class field definintions go here
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;
    private static double seconds;
    private static double minutes;
    private static double hours;
    private static double angle = 0;
    private static double hourAngle;
    private static double minuteAngle;
    private static double handAngle1;
    private static double handAngle2;

    private static double timeslice;
    private static double totalSeconds;
    private static double degrees;

  /**
   *  Constructor goes here
   */
   public Clock() {

    this.seconds = 0;
    this.minutes = 0;
    this.hours = 0;
    this.timeslice = timeslice;
    this.angle = angle;
    this.minuteAngle = 0;
    this.hourAngle = 0;
    this.totalSeconds = totalSeconds;
    
    
      
   }

  /**
   *  Methods go here
   *
   *  Method to calculate the next tick from the time increment
   *  @return double-precision value of the current clock tick
   */
   public double tick(double arg) {

    this.totalSeconds += this.timeslice;
      return totalSeconds;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException {
      
     double angleArg = Double.parseDouble( argValue );

     if ( argValue.length() == 0 ) {
       angleArg = MAXIMUM_DEGREE_VALUE;
       return MAXIMUM_DEGREE_VALUE;
     }

     if ( angleArg < 0 || angleArg > MAXIMUM_DEGREE_VALUE ) {
       throw new IllegalArgumentException("Invalid angle value");
     }
     return angleArg;
  }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) {
       
       double validtimeslice = Double.parseDouble(argValue);
        if (validtimeslice < 0 || validtimeslice > 1800) {
            throw new NumberFormatException("Invalid Argument");
        }
        return validtimeslice;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   */
   public double getHourHandAngle() {

      hourAngle = ( HOUR_HAND_DEGREES_PER_SECOND * totalSeconds );
    return hourAngle;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   */
   public double getMinuteHandAngle() {
      minuteAngle = ( totalSeconds * MINUTE_HAND_DEGREES_PER_SECOND ) % 360; 
        return minuteAngle;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {

      getHourHandAngle();
      getMinuteHandAngle();

       double handAngle = Math.abs(getHourHandAngle() - getMinuteHandAngle()) % 360;
        if (handAngle > 180) {
            return 360 - handAngle;
        }
        return handAngle;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

  /**
   *  Method to return a String representation of this clock
   *  @return String value of the current clock
   */
   public String toString() {
       hours = Math.floor(totalSeconds / 3600);
       minutes = Math.floor((totalSeconds % 3600) /60);
       seconds = totalSeconds - ((minutes * 60) + (hours * 3600));
       DecimalFormat df = new DecimalFormat("#.00");

       String stringFormat = Double.toString(hours)+ ":" + Double.toString(minutes) + ":" + Double.toString(seconds);
        
        return stringFormat;
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {

       System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock with angle 90 and ts 90: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "    Testing validateAngleArg(90.0)....");
      System.out.print( "      sending '  90.0 degrees', expecting double value   90.0" );
      try { System.out.println( (90.0 == clock.validateAngleArg( "90.0" )) ? " - got   90.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    System.out.println( "    Testing validateTimeSliceArg(30.0)....");
      System.out.print( "      sending '  30.0 degrees', expecting double value   30.0" );
      try { System.out.println( (30.0 == clock.validateTimeSliceArg( "30.0" )) ? " - got   30.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

    
    System.out.println( "\n" );
    System.out.println( "  Creating a new clock with angle 0 and ts 90: " );
      Clock clock1 = new Clock();
      System.out.println( "    New clock created: " + clock1.toString() );
      System.out.println( "    Testing validateAngleArg(0)....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0 == clock1.validateAngleArg( "0" )) ? " - got   0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    System.out.println( "    Testing validateTimeSliceArg(0.0)....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock1.validateTimeSliceArg( "0.0" )) ? " - got   0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }

    
    System.out.println( "\n" );
    System.out.println( "  Creating a new clock with angle 1000 and ts 1000 " );
      Clock clock2 = new Clock();
      System.out.println( "    New clock created: " + clock1.toString() );
      System.out.println( "    Testing validateAngleArg(1000)....");
      System.out.print( "      sending '  1000 degrees', expecting double value   1000" );
      try { System.out.println( (1000.00 == clock2.validateAngleArg( "1000" )) ? " - got   1000" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
    System.out.println( "    Testing validateTimeSliceArg(1000)....");
      System.out.print( "      sending '  1000 degrees', expecting double value   1000" );
      try { System.out.println( (1000.00 == clock2.validateTimeSliceArg( "1000" )) ? " - got   1000" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown: " + e.toString() ); }
}
}

