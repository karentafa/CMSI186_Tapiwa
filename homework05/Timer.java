public class Timer {
  


  private double hours;
  private double mins;
  private double secs;
  private double totalSecs;


public Timer() {
    this.hours = 0;
    this.mins = 0;
    this.secs = 0;
    this.totalSecs = 0;
    


  }

 public double tick() {


    totalSecs = totalSecs + 1;

    secs = totalSecs;

    if( secs >= 60 ) {
      mins = secs / 60 ;
      secs = secs % 60;
    }
    if( mins >= 60 ) {
      hours =  mins / 60;
      mins = mins % 60;
    }
    return totalSecs;
  }

public String toString() {
    return Math.floor( hours ) + ":" + Math.floor( mins ) + ":" + secs ;
  }

 public static void main( String args[] ) {
   
    Timer t = new Timer();
    System.out.println( t.toString() );
    t.tick();
    System.out.println( t.toString() );
  }









}
