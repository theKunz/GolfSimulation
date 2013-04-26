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
import java.awt.*;
import java.awt.event.*;
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
import java.util.Hashtable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class MainGolf implements ActionListener, ChangeListener 
{
    Course course = null;
    
    JSlider friction;
    JSlider startPos;
    JSlider velocity;
    JSlider mass;
    JPanel menu;
    JPanel view;
    //The start Button
    JButton sbutton;
    //The reset Button
    JButton rbutton;
    //The pause button
    JButton pbutton;
    final int FRAME_HEIGHT = 800;
    final int FRAME_WIDTH = 1200;
    
    
    public MainGolf()
    {
        
    }
    
    public static void main(String[] args) 
    {
        
        MainGolf golfSimulation = new MainGolf();
        golfSimulation.initialize();
        
        
 
        
    }
    
    public void initialize() {
        course = new Course();
        course.setBounds(30, 340, 740, 200);
        
        
        JFrame frame = new JFrame();
        frame.setTitle("Minigolf Simulation");
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        //frame.setBounds(center.x - 800 / 2, center.y - 600 / 2, 800,
        //600);
        
        //Potentially organize it with more JPanels
        //menu = new JPanel();
        //view = new JPanel();

        makeSliders();
        //menu.add(velocity);
        //menu.add(startPos);
        //menu.add(friction);
        //menu.add(mass);
        
        //view.add(c);
        
        //f.add(view, BorderLayout.SOUTH);
        frame.add(menu);
        frame.add(course);
        frame.setVisible(true);
        frame.setResizable(false);
        
        //Setting up the buttons for the JFrame 
        sbutton = new JButton("Start");
        sbutton.setActionCommand("Start");
        sbutton.setVisible(true);
        
        rbutton = new JButton("Reset");
        rbutton.setActionCommand("Reset");
        rbutton.setVisible(true);
        
        pbutton = new JButton("Pause");
        pbutton = new JButton("Pause");
        pbutton.setVisible(true);
        
        //Uses the frame size to set the size of the button
        Dimension buttonSize = new Dimension ((center.x - 800 / 2)) / 3, 99);
        
        sbutton.setPreferredSize(buttonSize);
        sbutton.setMinimumSize(buttonSize);
        sbutton.setMaximumSize(buttonSize);
        sbutton.addActionListener(this);
        
        pbutton.setPreferredSize(buttonSize);
        pbutton.setMinimumSize(buttonSize);
        pbutton.setMaximumSize(buttonSize);
        pbutton.addActionListener(this);

        rbutton.setPreferredSize(buttonSize);
        rbutton.setMinimumSize(buttonSize);
        rbutton.setMaximumSize(buttonSize);
        rbutton.addActionListener(this);
        
        //Creates the Panels to organize the top of the jframe
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(FRAME_WIDTH,(FRAME_HEIGHT / 2)));
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
	topPanel.setBackground(Color.WHITE);
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setPreferredSize(new Dimension((FRAME_WIDTH / 2),(FRAME_HEIGHT / 2)));
	topLeftPanel.setLayout(new BoxLayout(topLeftPanel, BoxLayout.Y_AXIS));
        JPanel topRightPanel = new JPanel();
        topRightPanel.setPreferredSize(new Dimension((FRAME_WIDTH / 2),(FRAME_HEIGHT / 2)));
	topRightPanel.setLayout(new BoxLayout(topRightPanel, BoxLayout.Y_AXIS));
        
        //Creates the Panels to organize the top of the jframe
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(FRAME_WIDTH,(FRAME_HEIGHT / 2)));
	bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        JPanel bottomLeftPanel = new JPanel();
        bottomLeftPanel.setLayout(new BoxLayout(bottomLeftPanel, BoxLayout.Y_AXIS));
        //We may need to play with these values to make it look good
        Dimension blp = new Dimension(10, 10);
        bottomLeftPanel.setPreferredSize(blp);
        JPanel bottomRightPanel = new JPanel();
        bottomRightPanel.setLayout(new BoxLayout(bottomRightPanel, BoxLayout.Y_AXIS));
        //We shoud make a getWidth method for the course
        Dimensions brp = new Dimension (750, 150);
        bottomRightPanel.setPreferredSize(brp);
        //Makes the top left Panel which whill hold the horizontal sliders 
        topLeftPanel.add(friction);
        topLeftPanel.add(startPos);
        topLeftPanel.add(mass);
        
        //Makes the top right Panel which will hold the buttons 
        topRightPanel.add(sbutton);
        topRightPanel.add(rbutton);
        topRightPanel.add(pbutton);
        
        topPanel.add(topLeftPanel);
        topPanel.add(topRightPanel);

        bottomLeftPanel.add(Box.createRigidArea(new Dimension(0, 100)));
        bottomLeftPanel.add(startPos);
        
        bottomRightPanel.add(course);
        
        bottomPanel.add(bottomLeftPanel);
        bottomPanel.add(bottomRightPanel);
        
        jframe.add(topPanel);
        jframe.add(bottomPanel);
        
        //This call makes all of the layouts fit the preferred size
        jframe.pack();
        jframe.setVisible(true);
        
        
        
        

    }
    
    /**
     * Makes the sliders for the frame 
     */
     public void makeSliders() {
         final int MAX_FRIC = 6;
         final int MIN_FRIC = 3;
         final int INIT_FRIC = 4;
         
         final int MAX_POSIT = 50;
         final int MIN_POSIT = 20;
         final int INIT_POSIT = 30;
         
         final int MAX_MASS = 50;
         final int MIN_MASS = 20;
         final int INIT_MASS = 30;
         
         final int MAX_VEL = 50;
         final int MIN_VEL = 20;
         final int INIT_VEL = 30;
         
         Dimension sliderDimension = new Dimension (300, 70);

         
         friction = createSlider(MIN_FRIC, MAX_FRIC, INIT_FRIC, sliderDimension, "Grass", 
                            "Dry sand", "Friction of wet sand");
         friction.setVisible(true);
         mass = createSlider(MIN_MASS, MAX_MASS, INIT_MASS, sliderDimension, MIN_MASS + " mass",
                            MAX_MASS + " mass", "Mass of the ball");                  
         mass.setVisible(true);
         velocity = createSlider(MIN_VEL, MAX_VEL, INIT_VEL, sliderDimension, "", "", "Velocity of the ball");
         
         //Since we want the starting position slider to be verticle we are not able to use the "createSlider" method
         startPos = new JSlider(JSlider.VERTICAL, MIN_POSIT, MAX_POSIT, INIT_POSIT);
         startPos.setPreferredSize(sliderDimension);
         startPos.setMaximumSize(sliderDimension);
         startPos.setMinimumSize(sliderDimension);
         //startPos = createSlider(MIN_POSIT, MAX_POSIT, INIT_POSIT, sliderDimension);   
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
          * This method will gather the data from the sliders and assign them to the simulation
          */ 
          public void resestSettings(){
              Ball ball = course.getBall(); 
              ball.setMass(mass.getValue());
              //Continue setting all values 
          }
         
         
         
         /**
          * This method will react when the buttons are pushed
          */
          public void actionPerformed(ActionEvent e) {
              String command = e.getActionCommand();
              
              //Determines what to do when action is  detected
              if (command.equalsIgnoreCase("Start")){
                  //start simulation
                  resetSettings();
                  timer = new Timer(TIMER_DELAY, this);
                  timer.setActionCommand("Timer");
                  timer.start();
              }
              else if (command.equalsIgnoreCase("Reset")){
                  //reset simulation
                  //TO_DO make a method that resets the simulation
                  
              }
              else if (command.equalsIgnoreCase("Pause")){
                  //pause simulation 
                  timer.stop();
                  sbutton.setActionCommand("Restart");
                  sbutton.setText("Restart");
              }
              else if (command.equalsIgnoreCase("Restart")){
                  //Restarts the simulation 
                  timer.start();
                  sbutton.setActionCommand("Start");
                  sbutton.setText("Start");
              }
              else if (command.equalsIgnoreCase("Timer")){
                  double delayTime = (double) timer.getDelay() / 1000.0;
                  course.setTime(delayTime);
                  course.repaint();
              }

          }

    @Override
    public void stateChanged(ChangeEvent e){
                  JSlider source = (JSlider) e.getSource();
                  if(!source.getValueIsAdjusting()){
                      resetSettings();
                  }
    
}
