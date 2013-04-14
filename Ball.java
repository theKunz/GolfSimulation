/**
 * The model for the physics for the ball.
 * @author Steven Whitehead
 * @version 2013.04.07
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
        accel = - (5 / 7) * p * g;
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
	* Get the current velocity given a time value.
	*/
	public double getCurrentVelocity(float time)
	{
		currentVelocity = intialVelocity + accel * time;
		return time;
	}
	/**
	* Get the velocity in the X direction.
	*/
	public double getVelocityX(float time, float angle)
	{	
		currentVelocityX = getCurrentVelocity(time) * Math.cos(angle);
		return currentVelocityX;
	}
	
	/**
	* Get the velocity in the Y direction.
	*/
	public double getVelocityY(float time, float angle)
	{	
		currentVelocityY = getCurrentVelocity(time) * Math.sin(angle);
		return currentVelocityY
	}
	
    /**
     * Given a force and the mass, find the initial velocity
     * of the putt
     */
    public double getInitalVelocity(float clubSpeed, float massBall, 
		float massClub, float coeffOfRestit)
    {
        IntialVelocity = (clubSpeed * coeffOfRestit) / 
			(1.0 + (massBall / massClub))
        return InitialVelocity;
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
