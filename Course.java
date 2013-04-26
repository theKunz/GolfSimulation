package course;
import java.awt.*;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Aaron
 */
public class Course extends Canvas
{
    private double friction;
    private Ball ball;
    private double time;
    private int length;
    private int height;

    
    public Course()
    {
        this.setBounds(30, 340, 740, 200);
        //ball = new Ball();
        length = 680; //680 default
        height = 160; //160 default        
    }
    /**
     * This paints the field, including the hole, onto the canvas
     * The dimensions and positions are hard coded for now, but
     * we can make the parameters variables for a dynamic course
     * @param putt 
     */
    @Override
    public void paint(Graphics putt)
    {
        super.paint(putt);
        putt.setColor(new Color(160, 120, 75));
        putt.fill3DRect(50, 340, length, 20, true); //top boundary
        putt.fill3DRect(30, 340, 20, height + 40, true); //left boundary
        putt.fill3DRect(50, 340 + height + 20, length, 20, true); //bottom boundary
        putt.fill3DRect(30 + length + 20, 340, 20, height + 40, true); //right boundary
        putt.setColor(new Color(0, 150, 75));
        putt.fillRect(50, 360, length, height); //grass
        putt.setColor(Color.BLACK);
        putt.fillOval(length - 30, 345 + (height/2), 25, 25); // hole
        
        putt.setColor(Color.WHITE);
        
        //ball.move(time);
        
        //putt.fillOval((int)ball.getCurrentX(), (int)ball.getCurrentY(), 25, 25); // ball
        
    
    }
    /*
     * sets the friction constant for the course
     * @param fric 
     */
    public void setFriction(double fric)
    {
        friction = fric;
    }
    /**
     * returns the friction constant of the course
     * @return friction
     */
    public double getFriction()
    {
        return friction;
    }
    /**
     * returns the instance of Ball for this game
     * @return ball
     */
    public Ball getBall()
    {
        return ball;
    }
    /**
     * returns the time elapsed
     */
    public double getTime()
    {
        return time;
    }
    /**
     * sets the time elapsed
     */
    public void setTime(double t)
    {
        time = t;
    }
    /**
     * returns the width
     */
    public int getLength()
    {
        return length;
    }
    /**
     * sets the width
     */
    public void setLength(int longs)
    {
        length = longs;
    }
    /**
     * returns the height
     */
     @Override
    public int getHeight()
    {
        return height;
    }
    /**
     * sets the width
     */
    public void setHeight(int high)
    {
        height = high;
    }
    
    
    /*
        public void paint(Graphics g) {
        
        super.paint(g);
        System.out.println("paint me");
                             
        for (int i = 0; i < ballPins.size(); i++){
            MovingObjects vari = (MovingObjects) ballPins.get(i);
            
            if (vari.getVelocity() != 0){
                vari.move(getTime());                        
                         
                         
                 }
             }
            
             vari.drawBall(g);
        }
        
      */      
}
