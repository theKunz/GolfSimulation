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

    
    public Course()
    {
        this.setBounds(30, 340, 740, 200);
        ball = new Ball();
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
        putt.fill3DRect(50, 340, 700, 20, true); //top boundary
        putt.fill3DRect(30, 340, 20, 200, true); //left boundary
        putt.fill3DRect(50, 520, 700, 20, true); //bottom boundary
        putt.fill3DRect(730, 340, 20, 200, true); //right boundary
        putt.setColor(new Color(0, 150, 75));
        putt.fillRect(50, 360, 680, 160); //grass
        putt.setColor(Color.BLACK);
        putt.fillOval(650, 425, 25, 25); // hole
        
        putt.setColor(Color.WHITE);
        
        ball.move(time);
        
        putt.fillOval((int)ball.getCurrentX(), (int)ball.getCurrentY(), 25, 25); // ball
        
    
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
