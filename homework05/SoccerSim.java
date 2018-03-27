public class SoccerSim {
  private static final String error_Mes = "";
  private static final double FIELD_SIZE_Y = 100;
  private static final double FIELD_SIZE_X = 100;
  private Ball[] ballArray = null;
  private Timer t = null;
  private static final double POLE_X = 15;
  private static final double POLE_Y = 15;


  public SoccerSim( String args[] ) {
    handleInitialArguments( args );
    try {
      int ballCount =  ( args.length / 4 );
      ballArray = new Ball[ballCount];
      int j = 0;
        for( int i = 0; i < args.length; i++ ) {
          double val1 = Double.parseDouble( args[i++] );
          double val2 = Double.parseDouble( args[i++] );
          double val3 = Double.parseDouble( args[i++] );
          double val4 = Double.parseDouble( args[i] );
          ballArray[j] = new Ball( val1, val2, val3, val4 );
          j++;

        }
    }
    catch( NumberFormatException nfe ) { System.out.println ( "Numbers only" ); }
  }

  public boolean checkBoundary( String[] args ) {
    double xPos = 0;
    double yPos = 0;
    for( int i = 0; i < ballArray.length; i++ ) {
      xPos = ballArray[i].getX();
      yPos = ballArray[i].getY();
      if( Math.abs( xPos) < ( FIELD_SIZE_X / 2 ) && Math.abs( yPos ) < ( FIELD_SIZE_Y / 2 ) ) {
        return false;
      }
    }
    return true;
  }

  
  public boolean checkCollision( String[] args ) {
    double x1 = 0;
    double y1 = 0;
    double x2 = 0;
    double y2 = 0;
    for( int i = 0; i < ( ballArray.length  - 1 ); i++ ) {
      for( int j = ( i + 1 ); j < ( ballArray.length ); j++ ) {
        x1 = ballArray[i].getX();
        y1 = ballArray[i].getY();
        x2 = ballArray[j].getX();
        y2 = ballArray[j].getY();
        if( Math.sqrt( Math.pow( ( x1 - x2 ), 2 ) + Math.pow( ( y1 - y2 ), 2 ) ) <= ( 8.9 / 12 ) ) {
          return true;
        }
      }
    }
    for( int i = 0; i < ( ballArray.length ); i++ ) {
      x1 = ballArray[i].getX();
      y1 = ballArray[i].getY();
      if( Math.sqrt( Math.pow( ( x1 - POLE_X ), 2 ) + Math.pow( ( y1 - POLE_Y ), 2 ) ) <= ( 4.45 / 12 ) ) {
        return true;
      }
    }
    return false;
  }

  public boolean checkRest( String[] args ) {
    for( int i = 0; i < ballArray.length; i++ ) {
      if( Math.abs( ballArray[i].getXSpeed() ) > ( 1 / 12 ) || Math.abs ( ballArray[i].getYSpeed() ) > ( 1 / 12 ) ) {
        return false;
      }
    }
    return true;
  }

  public void handleInitialArguments( String args[] ) {
    System.out.println( "\nSoccerSim program!!\n\n" ) ;
    if( 0 == args.length ) {
      System.out.println( "   enter at least 4 arguments\n" +
                          "   Usage: java SoccerSim X-Coordinate Y-Coordinate XVelocity YVelocity\n" +
                          "   Please try again..........." );
      System.exit( 1 );
    }
    if( args.length % 4 != 0 ) {
      System.out.println( "   Sorry you must enter at least 4 arguments for each ball\n" +
                          "   Usage: java SoccerSim X-Coordinate Y-Coordinate XVelocity YVelocity\n" +
                          "   Please try again..........." );
      System.exit( 1 );
    }
  }

  public void update( String[] args ) {
    for( int i = 0; i < ballArray.length; i++ ) {
      ballArray[i].newXSpeed();
      ballArray[i].newYSpeed();
      ballArray[i].updateLocation();
    }
  }
  public void report( Timer t ) {
    System.out.println( t.toString() );
    for( int i = 0; i < ballArray.length; i++ ) {
      System.out.println( ballArray[i].toString() + "\n" );
    }
  }

  public static void main( String args[] ) {
    SoccerSim ss = new SoccerSim( args );
    Timer t = new Timer();
    while ( true ) {
      if( ss.checkBoundary( args ) ) {
        System.out.println( "All ball(s) off field, no collisions occured" );
        break;
      }
      if( ss.checkCollision( args ) ) {
        System.out.println( "Collision occured" );
        ss.report( t );
        break;
      }
      if( ss.checkRest( args ) ) {
        System.out.println( "All ball(s) at rest. No collisions occured" );
        ss.report( t );
        break;
      }
      ss.report( t );
      t.tick();
      ss.update( args );
    }
  }
}
