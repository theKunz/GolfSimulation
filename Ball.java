/**
 * The model for the physics for the ball.
 * @author Steven Whitehead
 * @version 2013.04.20
 *
*/
public class Ball
{
    private int moveCounter;
    private double massBall;
    private double initialVelocity;
    private double currentVelocity;
    private double currentVelocityX;
    private double currentVelocityY;
    private double angle;
    private double initialX;
    private double initialY;
    private double currentX;
    private double currentY;
    private double accel;
    private double p;
    private final double GRAVITY_ACCEL;
    private Course course;
    private int radius; 

    /**
     * constructor
     */
    public Ball()
    {
        double p = 0.131;
        GRAVITY_ACCEL = 9.81;
        initialVelocity = 0;
        accel = - (5 / 7) * p * GRAVITY_ACCEL;
    }
    /**
     * constructor while entering a coefficient of friction
     * Note that p = N / R, where N is the normal force and R
     * is the radius of the ball.
     * @param p the coefficient of friction.
     */
    public Ball(float p)
    {
        GRAVITY_ACCEL = 9.81;
        accel = - (5 / 7) * p * GRAVITY_ACCEL;
    }

    /**
     * Given a time value and an initial velocity, find the distance
     * that the ball went.
     * @param time how far along the simulation is.
     * @param veloInit the initial velocity
     * @return the distance it went
     */
    public double getDistance(float time, float veloInit)
    {
        double d = 0;
        d = veloInit * time + (1 / 2) * accel * time * time;
        return d;
    }
    
    /**
    * Calculate the current velocity given a time value.
    * @param time the time value
    */
    public void calcCurrentVelocity(double time)
    {
        currentVelocity = initialVelocity + accel * time;
    }
    
    /**
     * Get the current velocity
     * @return the current velocity 
     */
    public double getCurrentVelocity()
    {
        return currentVelocity;
    }
    
    /**
    * Calculate the velocity in the X direction.
    * @param angle the angle at which it was hit with the horizontal
    */
    public void calcVelocityX(float angle)
    {   
        currentVelocityX = currentVelocity * Math.cos(angle);
    }
    
    /**
    * Get the velocity in the X direction.
    * @return the x velocity
    */
    public void getVelocityX()
    {   
        return currentVelocityX; 
    }
    
    /**
    * Calculate the velocity in the Y direction.
    * @param angle the angle at which it was hit with the horizontal
    */
    public void calcVelocityY(float angle)
    {   
        currentVelocityY = currentVelocity * Math.sin(angle);
    }
    
    /**
    * Get the velocity in the Y direction.
    * @return the y velocity
    */
    public double getVelocityY()
    {   
        return currentVelocityY; 
    }
    
    /**
     * Given a few inputs, find the initial velocity
     * of the putt
     * @param clubSpeed the speed of the club
     * @param massBall the mass of the ball
     * @param massClub the mass of the club
     * @param coeffOfRestit the coefficitent of restitution
     * 
     */
    public void calcInitalVelocity(double clubSpeed, double massBall, 
        double massClub, double coeffOfRestit)
    {
        initialVelocity = (clubSpeed * coeffOfRestit) / 
            (1.0 + (massBall / massClub));       
    }
    
    /**
     * Set the initial velocity to any value you want
     * @param initVelo the initial velocity you want
     */
    public void setInitialVelocity(double initVelo)
    {
        initialVelocity = initVelo;
    }
   
    /**
     * Return the initial velocity
     * @return the initial velocity
     */
    public double getInitialVelocity()
    {
        return initialVelocity;
    }
        
    /**
     * Given a distance, find the x coordinate
     * @param distance how far the ball is from
     * it's original position
     * @param angle the at which the ball was hit
     * @return the x position
     */
    public double getX(double distance, double angle)
    {
        double x = distance * Math.cos(angle);
        return x;
    }
    
    /**
     * Given a distance, find the y coordinate
     * @param distance how far the ball is from
     * it's original position
     * @param angle the at which the ball was hit
     * @return the y position
     */
    public double getY(double distance, double angle)
    {
        double y = distance * Math.sin(angle);
        return y;
    }

}
