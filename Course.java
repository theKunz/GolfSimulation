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


    
    public Course()
    {
        this.setBounds(30, 340, 740, 200);
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
        
    
    }
    
    /*
        public void paint(Graphics g) {
        
        super.paint(g);
        System.out.println("paint me");
        
        //Draw Oil
        g.setColor(Color.BLUE);
                    g.fillRect(0, 0, (int)getOilPercentage(), (int)AlleyConversion.getLaneLength());
        
        //Draw Gutter
        g.setColor(Color.GRAY);
        g.fillRect(0, 0,(int) AlleyConversion.getLaneWidth(), (int) AlleyConversion.getGutterWidth());
        g.fillRect(0, (int)AlleyConversion.getLaneLength() - (int)AlleyConversion.getGutterWidth(),
                (int) AlleyConversion.getLaneWidth(), (int) AlleyConversion.getGutterWidth());
        
        
        
        for (int i = 0; i < ballPins.size(); i++){
            MovingObjects vari = (MovingObjects) ballPins.get(i);
            
            if (vari.getVelocity() != 0){
                vari.move(getTime());
    
                    
                 for (int j = i + 1;  j < ballPins.size(); j++){
                     MovingObjects varj = (MovingObjects) ballPins.get(j);
                     if (AlleyConversion.isHit(vari.getCurrentLocation(), vari.getRadius(), 
                             varj.getCurrentLocation(), varj.getRadius())){
                                    
                            System.out.println("It hit --------------> r1,r2=" + vari.getRadius() + ", " + varj.getRadius());
                            varj.printCurrentLocation();
                            vari.printCurrentLocation();
                            varj.setColor(Color.RED);
                            AlleyConversion.collision(vari, varj);
                         
                        }            
                         
                         
                         
                         
                 }
             }
            
             vari.drawBall(g);
        }
        
      */      
}
