package course;
/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Andrew Koh
* @author Aaron Kunzer
*/

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;


public class MainGolf
{
    JSlider friction;
    JSlider startPos;
    JSlider mass;
    JPanel menu;
    JPanel view;
    
    
    public MainGolf()
    {
        
    }
    
    public static void main(String[] args) 
    {
        
        MainGolf golfSimulation = new MainGolf();
        golfSimulation.initialize();
        
        
 
        
    }
    
    public void initialize() {
        Course c = new Course();
        c.setBounds(30, 340, 740, 200);
        
        
        JFrame f = new JFrame();
        f.setTitle("Minigolf Simulation");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        f.setBounds(center.x - 800 / 2, center.y - 600 / 2, 800,
        600);
        

        menu = new JPanel();
        view = new JPanel();
        
        startPos.setOrientation(SwingConstants.VERTICAL);
        startPos.setMaximum(160 - width.getValue());
        startPos.setMinimum(0 + width.getValue());
        
        menu.add(startPos);
        menu.add(friction);
        menu.add(mass);
        
        //view.add(c);
        
        //f.add(view, BorderLayout.SOUTH);
        f.add(menu);
        f.add(c);
        f.setVisible(true);
        f.setResizable(false);
    }
    
    /**
     * Makes the sliders for the frame 
     */
     public void makeSliders() {
         final int MAX_FRIC = 0.6;
         final int MIN_FRIC = 0.35;
         final int INIT_FRIC = 0.4;
         
         final int MAX_POSIT = 50;
         final int MIN_POSIT = 20;
         final int INIT_POSIT = 30;
         
         final int MAX_MASS = 50;
         final int MIN_MASS = 20;
         final int INIT_MASS = 30;
         
         Dimension sliderDimension = new Dimension (300, 70);

         
         friction = createSlider(MIN_FRIC, MAX_FRIC, INIT_FRIC, sliderDimension, "Grass", 
                            "Dry sand", "Friction of wet sand");
         friction.setVisible(true);
         mass = createSlider(MIN_MASS, MAX_MASS, INIT_MASS, sliderDimension, MIN_MASS + " mass",
                            MAX_MASS + " mass", "Mass of the ball");                  
         mass.setVisible(true);
         
         //Since we want the starting position slider to be verticle we are not able to use the "createSlider" method
         startPos = new JSlider(JSlider.VERTICAL, MIN_POSIT, MAX_POSIT, INIT_POSIT);
         startPos.setPreferredSize(sliderDimension);
         startPos.setMaximumSize(sliderDimension);
         startPos.setMinimumSize(sliderDimension);
         startPos = createSlider(MIN_POS, MAX_POS, INIT_POS, sliderD);   
         Hashtable temp = new Hashtable();
             temp.put ( new Integer (INIT_POSIT), new JLabel ("Position"));
             temp.put ( new Integer (MIN_POSIT), new JLabel (""));
             temp.put ( new Integer (MAX_POSIT), new JLabel ("")); 
         startPos.setLabelTable(temp);
         startPos.setPaintLabels(true);
         startPos.addChangeListener(this);
         startPos.setVisible(true);
         
     }
     
     /**
      * This method will create a new JSlider 
      */
      public JSlider createSlider (int min, int max, int init, Dimension y, String mini, String maxi, String initi){
             JSlider temporarySlider = new JSlider(JSlider.HORIZONTAL, min, max, init);
             temporarySlider.setPreferredSize(y);
             temporarySlider.setMaximumSize(y);
             temporarySlider.setMinimumSize(y);
             
             Hashtable temp = new Hashtable();
             temp.put ( new Integer (init), new JLabel (initi));
             temp.put ( new Integer (min), new JLabel (mini));
             temp.put ( new Integer (max), new JLabel (maxi)); 
             temporarySlider.setLabelTable(temp);
             temporarySlider.setPaintLabels(true);
             
             temporarySlider.addChangeListener(this);
         
             return temporarySlider;
             
             
             
         }
         
         /**
          * This method will take 
          */
          public void actionPerformed(ActionEvent e) {
              String command = e.getActionCommand();
              
          }
    
}
