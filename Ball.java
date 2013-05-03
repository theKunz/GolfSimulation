package course;

/**
* The model for the physics for the ball.
*/
public class Ball
{
    private int moveCounter;
    private double massBall;
    private double initialVelocity;
    private double currentVelocity;
    private double initialVelocityX;
    private double initialVelocityY;
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
    private double coeffOfFriction;
    private double time;
    private boolean isMoving = true;

    /**
     * Creates a ball with the default values.
     */
    public Ball()
    {
        coeffOfFriction = 1;
        GRAVITY_ACCEL = 9.81;
        initialX = 35;
        initialY = 80;
        currentX = 35;
        currentY = 80;
        initialVelocity = 0;
        accel = -1 * coeffOfFriction * GRAVITY_ACCEL;
    }
    /**
     * Creates a ball with some input values.
     * @param p the coefficient of friction
     * @param t the time value
     * @param velo the initial velocity value
     */
    public Ball(double p, double t, double velo)
    {
        GRAVITY_ACCEL = 9.81;
        coeffOfFriction = p;
        time = t;
        accel = -1 * coeffOfFriction * GRAVITY_ACCEL;
        initialX = 35;
        initialY = 80;
        currentX = 35;
        currentY = 80;
        initialVelocity = velo;
        initialVelocityX = velo * Math.cos(angle);
        initialVelocityY = velo * Math.sin(angle);
    }
    
    /**
     * Get the distance the ball has traveled.
     * @param time the time value to use
     * @return the distance traveled.
     */
    public double getDistance(double time)
    {
        double d = getInitialVelocity() * time + (1 / 2) * accel * time * time;
        return d;
    }

    /**
     * Calculate the current velocity
     * @param time the time value to use
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
     * Calculate the velocity in the x direction.
     * @param ang the angle at which the ball was hit.
     */
    public void calcVelocityX(float ang)
    {
        currentVelocityX = currentVelocity * Math.cos(angle);
    }
    /**
     * Get the velocity in the x direction.
     * @return the x velocity
     */
    public double getVelocityX()
    {
        return currentVelocityX;
    }
    /**
     * Get the velocity in the x direction.
     * @return the x velocity
     */
    public void calcVelocityY(float ang)
    {
        currentVelocityY = currentVelocity * Math.sin(angle);
    }

    /**
     * Get the velocity in the y direction.
     * @return the y velocity
     */
    public double getVelocityY()
    {
        return currentVelocityY;
    }
    /**
     * Set the intial velocity
     * @param initVelo the initial velocity to set to
     */
    public void setInitialVelocity(double initVelo)
    {
        initialVelocity = initVelo;
        initialVelocityX = initialVelocity * Math.cos(angle);
        initialVelocityY = initialVelocity * Math.sin(angle);
    }

    /**
     * Get the intial velocity
     * @return initial velocity
     */
    public double getInitialVelocity()
    {
        return initialVelocity;
    }
    /**
     * Calculate the x position, and set it to the field x. Also
     * handles collisions.
     */
    public void calcX()
    {
        currentVelocityX = (initialVelocity + (accel * time)) * Math.cos(angle);
        if (Math.abs(currentVelocityX) <= 0.0000)
        {
            currentVelocityX = 0;
        }
        currentX = initialX + (currentVelocityX * time);
        initialX = currentX;

        if(currentX >= 675)
        {
            currentX = 675;
            if (angle < Math.PI)
            {
                angle = Math.PI - angle;
            }
            else
            {
                angle = (3 * Math.PI) - angle;
            }
        } 
        else if (currentX < 20)
        {
            currentX = 20;
            if (angle > Math.PI)
            {
                angle = (3 * Math.PI) - angle;
            }
            else 
            {
                angle = Math.PI - angle;
            }
        }
    }


    /**
     * Get the current x velocity
     * @return the x velocity
     */
    public double getCurrentX()
    {
        return currentX;
    }
    /**
     * Get the current y value
     * @return the y value
     */
    public double getCurrentY()
    {
        return currentY;
    }
    /**
     * Set the x value
     * @param x the value
     */
    public void setCurrentX(double x)
    {
        currentX = x;
    }
    /**
     * Set the y value
     * @param y the y value
     */
    public void setCurrentY(double y)
    {
        currentY = y;
    }
    /**
     * Set the time value
     * @param timec the time value
     */
    public void setTime(double timec)
    {
        time = timec;
    }
    /**
     * Calculate the Y value, and set to the y field.
     */
    public void calcY()
    {
        currentVelocityY = (initialVelocity + (accel * time)) * Math.sin(angle);
        if (Math.abs(currentVelocityY) <= 0.0000)
        {
            currentVelocityY = 0.0;
        }
        currentY = initialY + (currentVelocityY * time);
        initialY = currentY;

        if(currentY >= 155)
        {
            currentY = 155;
            if (angle < ((3 * Math.PI)/2))
            {
                angle = (2 * Math.PI) - angle;
            }
            else
            {
                angle = angle - ((3 * Math.PI)/2);
            }
        }
        else if (currentY < 20)
        {
            currentY = 20;
            angle = (2 * Math.PI) - angle;
        }
    }
    /**
     * Calculate all the values to move the ball.
     */
    public void move ()
    {
        if (isMoving){
        calcX();
        calcY();
        if (checkCollisionHole()) {
            isMoving = false;
        }
        initialVelocity = Math.sqrt((currentVelocityX * currentVelocityX) + (currentVelocityY * currentVelocityY));
        }
    }
    /**
     * Check if there is a collision with the hole.
     * @return whether or not a collision occurred
     */
    public boolean checkCollisionHole()
    {
        return ((int) this.getCurrentX() > 640
                && (int) getCurrentX() < 655
                && (int) getCurrentY() > 60
                && (int) getCurrentY() < 90);
        
        
    }
    /**
     * Set the mass of the ball
     * @param m the mass of the ball
     */
    public void setMass(double m)
    {
        massBall = m;
    }
    /**
     * Return the mass of the ball.
     * @return the mass of the ball
     */
    public double getMass()
    {
        return massBall;
    }
    /**
     * Set the initial y value
     * @param y the initial value
     */
    public void setInitialY(int y)
    {
        this.initialY = y;
    }
    /**
     * Set the angle
     * @param ang the angle
     */
    public void setAngle(double ang)
    {
        this.angle = ang;
    }
    /** 
     * Return the angle
     * @return the angle
     */
    public double getAngle()
    {
        return angle;
    }
    /**
     * Set the current velocity
     * @param vel the velocity
     */
    public void setCurrentVelocity(double vel) 
    {
        currentVelocity = vel;
    }
    /**
     * Set the friction value
     * @param friction the friction value to use
     */
    public void setFriction(double friction)
    {
        accel = -1 * friction * GRAVITY_ACCEL;
        System.out.println("accel to fric: " + accel);
    }
    
    public void setCurrentVelocityX(double velocX)
    {
        currentVelocityX = velocX;
    }
    
    public void setCurrentVelocityY(double velocY)
    {
        currentVelocityY = velocY;
    }
}
