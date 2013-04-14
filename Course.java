
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
        
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        f.setBounds(center.x - 800 / 2, center.y - 600 / 2, 800,
        600);
        
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
