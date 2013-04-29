package course;

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

    public double getDistance(double time)
    {
        double d = getInitialVelocity() * time + (1 / 2) * accel * time * time;
        return d;
    }

    public void calcCurrentVelocity(double time)
    {
        currentVelocity = initialVelocity + accel * time;
    }

    public double getCurrentVelocity()
    {
        return currentVelocity;
    }


    public void calcVelocityX(float ang)
    {
        currentVelocityX = currentVelocity * Math.cos(angle);
    }

    public double getVelocityX()
    {
        return currentVelocityX;
    }

    public void calcVelocityY(float ang)
    {
        currentVelocityY = currentVelocity * Math.sin(angle);
    }


    public double getVelocityY()
    {
        return currentVelocityY;
    }

    public void calcInitalVelocity(double clubSpeed, double massBall,
        double massClub, double coeffOfRestit)
    {
        initialVelocity = (clubSpeed * coeffOfRestit) /
            (1.0 + (massBall / massClub));
    }


    public void setInitialVelocity(double initVelo)
    {
        initialVelocity = initVelo;
        initialVelocityX = initialVelocity * Math.cos(angle);
        initialVelocityY = initialVelocity * Math.sin(angle);
    }


    public double getInitialVelocity()
    {
        return initialVelocity;
    }

    public void calcX()
    {
        currentVelocityX = (initialVelocity + (accel * time)) * Math.cos(angle);
        if (Math.abs(currentVelocityX) <= 0.0)
        {
            currentVelocityX = 0.0;
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



    public double getCurrentX()
    {
        return currentX;
    }

    public double getCurrentY()
    {
        return currentY;
    }


    public void setCurrentX(double x)
    {
        currentX = x;
    }

    public void setCurrentY(double y)
    {
        currentY = y;
    }
    
    public void setTime(double timec)
    {
        time = timec;
    }

    public void calcY()
    {
        currentVelocityY = (initialVelocity + (accel * time)) * Math.sin(angle);
        if (Math.abs(currentVelocityY) <= 0.0)
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

    public void move ()
    {
        calcX();
        calcY();
        initialVelocity = Math.sqrt((currentVelocityX * currentVelocityX) + (currentVelocityY * currentVelocityY));
    }

    public void setMass(double m)
    {
        massBall = m;
    }

    public double getMass()
    {
        return massBall;
    }

    public void setInitialY(int y)
    {
        this.initialY = y;
    }

    public void setAngle(double ang)
    {
        this.angle = ang;
    }
 
    public double getAngle()
    {
        return angle;
    }

    public void setCurrentVelocity(double vel) 
    {
        currentVelocity = vel;
    }
    
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

