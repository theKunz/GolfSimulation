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
    private double initialX;
    private double initialY;
    private double currentX;
    private double currentY;
    private double accel;
    private double p;
    private double angle;
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
    public double getDistance(double time, double veloInit)
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
    public void calcVelocityX(float ang)
    {   
        currentVelocityX = currentVelocity * Math.cos(angle);
    }
    
    /**
    * Get the velocity in the X direction.
    * @return the x velocity
    */
    public double getVelocityX()
    {   
        return currentVelocityX; 
    }
    
    /**
    * Calculate the velocity in the Y direction.
    * @param angle the angle at which it was hit with the horizontal
    */
    public void calcVelocityY(float ang)
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
     */
    public void calcX(double distance)
    {
        currentX = distance * Math.cos(angle);
    }
    
    /**
     * Get the current x position
     */
     
    public double getCurrentX()
    {
        return currentX;
    }
    
    public double getCurrentY()
    {
        return currentY;
    }
    
    /**
     * Given a distance, find the y coordinate
     * @param distance how far the ball is from
     * it's original position
     * @param angle the at which the ball was hit
     */
    public void calcY(double distance)
    {
        currentY = distance * Math.sin(angle);
    }
    
    public void move (double time)
    {
        calcX(getDistance(time, initialVelocity));
        calcY(getDistance(time, initialVelocity));
        System.out.println( getCurrentX());
        System.out.println( getCurrentY());
    }

    public void setMass(double m)
    {
        massBall = m;
    }
    
    public double getMass()
    {
        return massBall;
    }
    /*
     public void move (double time) {
    
        
        double x = 0;
        double y = 0;
        
        if (time == 0.0) {
        
            System.out.println("matched time=0");
            x = getCurrentX();
            y = getCurrentY();
        } else if ((getCurrentX() < lane.getOilPercentage()) || (getIsPin()) || (time < 0)) {
        
            // no friction, linear velocity only
            
            System.out.println("angle=" + getAngle() + " radians=" + getAngleRadians());
            System.out.println("velocity=" + getVelocity());
            x = getCurrentX()+ (Math.cos(getAngleRadians()) * getVelocity() * time);
            y = getCurrentY()+ (Math.sin(getAngleRadians())* getVelocity() * time); 
        } else {
            // friction part of the alley, accounts for linear and angular velocity with angle changes.
            
            double angularVelocityAngle = 0;            
   
                angularVelocityAngle = getAngleRadians() + (Math.PI / 4.0);
         
            double deltaX = (Math.cos(getAngleRadians()) * getVelocity() * time) +  
                (Math.cos(angularVelocityAngle) * getAngularVelocity() * time); 
            double deltaY = (Math.sin(getAngleRadians()) * getVelocity() * time) +  
                (Math.sin(angularVelocityAngle) * getAngularVelocity() * time); 
            
         
            double newAngle = Math.atan(deltaY / deltaX);
            if (deltaX < 0.0){
                newAngle += 180.0;
            }
            setAngle(Math.toDegrees(newAngle));
            
            System.out.println("New original linear angle=" + getAngleRadians() + " degrees=" + Math.toDegrees(getAngleRadians()));
            
            
            
            x = deltaX + getCurrentX();
            y = deltaY + getCurrentY(); 
            
            System.out.println("");
            // linear velocity decreases due to friction
            double newLinearVelocity = getVelocity() - (lane.getFriction() * GRAVITY_ACCELERATION * time);
            if (newLinearVelocity < 0) {
                newLinearVelocity = 0;
            }
            System.out.println("linear velocity changed from " + getVelocity() + " to " + newLinearVelocity);
            setVelocity(newLinearVelocity);
            
            
            System.out.println("");
        }
        

        
        Point startPoint = getCurrentLocation(); 
        
        
        
        System.out.println(getName() + " (" + getCurrentX() + ", " + getCurrentY() + ") ----> (" + x + ", " + y + ")");
    
        
        setCurrentLocation (x, y); 
        
        
        
    }
    */

}
