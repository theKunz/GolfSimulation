

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JFrame;

public class Course extends Canvas{
    
    double friction;
    double time;
    
    private JFrame frame;
    
    public Course()       
    {
        frame = new JFrame("FRAME");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        frame.setResizable(false);
        setVisible(true);
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
    }
    
    /*public Ball getGolfBall()
    {
        
    }*/
    
    public double getFriction()
    {
        return this.friction;
    }
    
    public void setFriction(double friction)
    {
        this.friction = friction;
    }
    
    public double getTime()
    {
        return this.time;
    }
    
    public void setTime(double time)
    {
        this.time = time;
    }
    
    
}
