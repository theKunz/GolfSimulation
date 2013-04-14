import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;

public class Course extends Canvas
{
    
    double friction;
    double time;
    
    private JFrame frame;
    
    public Course()       
    {
        
        frame = new JFrame("Minigolf Simulation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(false);
        
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        f.setBounds(center.x - 800 / 2, center.y - 600 / 2, 800,
        600);
        
        frame.add(this);
        setVisible(true);
    }
    /**
     * This paints the field, including the hole, onto the canvas.
     * The dimensions and positions are hard coded for now, but
     * we can make the parameters variables for dynamic course creation
     * @param boll 
     */
    public void paint(Graphics g)
    {
        super.paint(g);
        g.setColor(new Color(160, 120, 75));
        g.fill3DRect(50, 340, 700, 20, true); //top boundary
        g.fill3DRect(30, 340, 20, 200, true); //left boundary
        g.fill3DRect(50, 520, 700, 20, true); //bottom boundary
        g.fill3DRect(730, 340, 20, 200, true); //right boundary
        g.setColor(new Color(0, 150, 75));
        g.fillRect(50, 360, 680, 160); //grass
        g.setColor(Color.BLACK);
        g.fillOval(650, 425, 25, 25); // hole
    }
    
    /*public Ball getGolfBall()
    {
        
    }*/
    
    public double getFriction()
    {
        return this.friction;
    }
    
    public void setFriction(double frictiony)
    {
        this.friction = frictiony;
    }
    
    public double getTime()
    {
        return this.time;
    }
    
    public void setTime(double timey)
    {
        this.time = timey;
    }
    
    
}
