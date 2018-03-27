import java.text.DecimalFormat;


public class Ball {

  private boolean atRest;
  public static final double Weight = 1; 
  public static final double Radius = 4.45;
  public static final double Diameter = 8.65;
  private double xPosition = 0.0;
  private double yPosition = 0.0;
  private double xVelocity = 0.0;
  private double yVelocity = 0.0;
  private double[] myArray;
  private double timeSlice;
  

  public Ball(double val1, double val2, double val3, double val4) {

 xPosition = val1;
 yPosition = val2;
 xVelocity = val3;
 yVelocity = val4;


    
  }

  public double getX(){

    return this.xPosition;

  }


  public double getY(){

    return this.yPosition;
  }


  public double getXSpeed(){

    return this.xVelocity;

  }


  public double getYSpeed(){

    return this.yVelocity;
  }



  public double newXSpeed() {

    xVelocity = 1 - (xVelocity * 0.01);
      return xVelocity;

   

  }

  public double newYSpeed(){
      
      yVelocity = 1 - (yVelocity * 0.01);
        return yVelocity;
  }


  public double newXPosition(){
      xPosition += xVelocity;
      return xPosition;
    }

    public double newYPosition(){
      yPosition += yVelocity;
      return yPosition;
    }

    public void updateLocation() {
    xPosition += xVelocity;
    yPosition += yVelocity;
  }

   
   public   void setArray() {  

       double ballArray[] = new double[4];
    ballArray[0] = xPosition;
    ballArray[1] = yPosition;
    ballArray[2] = xVelocity;
    ballArray[3] = yVelocity;
    myArray = ballArray;

    }

    public   double[] getArray() {
    return myArray;
  }

 public String velocityToString() {
      return "(" + newXSpeed() + "," + newYSpeed() + ")";
    }


 public String positionToString() {
      return "(" + newXPosition() + "," + newYPosition() + ")";
    }

    public String toString() {
        DecimalFormat df = new DecimalFormat("#0.000");
        String stringBall= "<" + df.format(xPosition) + "," + df.format(yPosition) + ">" + "<" + df.format(xVelocity) + "," + df.format(yVelocity) + ">";
        return stringBall;
    }

   
  

  /*public boolean atRest(){

    
   if ((xSpeed == 0) && (yPosition == 0) ) {

      return true;
    }
        else {

              return false;
        }

  } */
  
/*public boolean isMoving(){


if ((xSpeed > 0) & (yPosition > 0) ) {

      return true;
    }
        else {

              return false;
        }


}*/
   public static void main( String args[] ) {
    System.out.println( "New ball made: " );
    Ball ball = new Ball( 30.0, 40.0, 3.0, 4.0);
    System.out.println( "Testing getXPos (expecting 30.0) " );
    System.out.println( ball.getX() );
    System.out.println( "Testing getYPos (expecting 40.0) " );
    System.out.println( ball.getY() );
    System.out.println( "Testing getXSpeed (expecting 3.0) " );
    System.out.println( ball.getXSpeed() );
    System.out.println( "Testing getYSpeed (expecting 4.0) " );
    System.out.println( ball.getYSpeed() );
    System.out.println( "Testing toString " );
    System.out.println( ball.toString() );
  }
}



