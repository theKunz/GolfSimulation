/**
 * The model for the physics for the ball.
 * @author Steven Whitehead
 * @version 2013.04.07
 *
*/
public class Ball
{
    private double accel;
    private double p;
    private double g;
    private double xPosition = 0;
    private double yPosition = 0;

    /**
     * Main
     *
     */
   // public void main( )
   // {
   //     this.getDistance(7, 30);
   // }
    /**
     * constructor
     */
    public Model()
    {
        double p = 0.131;
        double g = 9.81;
        accel = - (5 / 7) * p * g;
    }
    /**
     * constructor while entering a coefficient of friction
     * Note that p = N / R, where N is the normal force and R
     * is the radius of the ball.
     * @param p the coefficient of friction.
     */
    public Model(float p)
    {
        double g = 9.81;
        accel = - (5 / 7) * p * g;
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
     * Given a force and the mass, find the initial velocity
     * of the putt
     */
    public double getVeloInit(float clubSpeed, float massBall, 
		float massClub, float coeffOfRestit)
    {
        double veloInit = (clubSpeed * coeffOfRestit) / 
			(1.0 + (massBall / massClub))
        return veloInit;
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
