package course;
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

/**
 * The main class for the Golf simulation. It handles the sliders, panels,
 * buttons, and the course. 
 */
public class MainGolf implements ActionListener, ChangeListener
{
    Course course = null;

    Timer timer;
    static double testTime;

    JSlider friction;
    JSlider startPos;
    JSlider velocity;
    JSlider angle;
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
        // Intentionally left blank
    }

    public static void main(String[] args)
    {
        MainGolf golfSimulation = new MainGolf();
        golfSimulation.initialize();
        testTime = 1;
    }

    public void initialize() {

        JFrame frame = new JFrame();
        frame.setTitle("Minigolf Simulation");
        frame.setPreferredSize(new Dimension(FRAME_WIDTH, FRAME_HEIGHT));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        frame.setBounds(center.x - 800 / 2, center.y - 600 / 2, 800,
        600);

        int fwidth = frame.getWidth();
        int fheight = frame.getHeight();
        course = new Course();
        makeSliders();
        course.getBall().setTime(0.01);
        double fin = (double)friction.getValue();
        fin = fin / 30;
        course.getBall().setFriction(fin);
        course.getBall().setFriction(friction.getValue());
        course.getBall().setInitialVelocity(velocity.getValue() * 6);

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
        Dimension buttonSize = new Dimension( (center.x - 100 / 2) / 3, 99);

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
        topPanel.setPreferredSize(new Dimension(fwidth,(fheight / 2)));
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        topPanel.setBackground(Color.WHITE);
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setPreferredSize(new Dimension((fwidth / 2),(fheight / 2)));
        topLeftPanel.setLayout(new BoxLayout(topLeftPanel, BoxLayout.Y_AXIS));
        JPanel topRightPanel = new JPanel();
        topRightPanel.setPreferredSize(new Dimension((fwidth / 2),(fheight / 2)));
        topRightPanel.setLayout(new BoxLayout(topRightPanel, BoxLayout.Y_AXIS));
    

        //Creates the Panels to organize the top of the jframe
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(fwidth,(fheight / 2)));
        bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));
        JPanel bottomLeftPanel = new JPanel();
        bottomLeftPanel.setLayout(new BoxLayout(bottomLeftPanel, BoxLayout.Y_AXIS));
        //We may need to play with these values to make it look good
        Dimension blp = new Dimension(70, course.getHeight());
        bottomLeftPanel.setPreferredSize(blp);
        JPanel bottomRightPanel = new JPanel();
        bottomRightPanel.setLayout(new BoxLayout(bottomRightPanel, BoxLayout.X_AXIS));
        //We shoud make a getWidth method for the course
        Dimension brp = new Dimension (course.getWidth(), course.getHeight());
        bottomRightPanel.setPreferredSize(brp);
        //Makes the top left Panel which whill hold the horizontal sliders
        topLeftPanel.add(friction);
        topLeftPanel.add(velocity);
        topLeftPanel.add(mass);
        topLeftPanel.add(angle);
        topLeftPanel.add(Box.createRigidArea(new Dimension(5000, 10)));

        //Makes the top right Panel which will hold the buttons
        topRightPanel.add(sbutton);
        topRightPanel.add(rbutton);
        topRightPanel.add(pbutton);

        topPanel.add(topLeftPanel);
        topPanel.add(topRightPanel);

        bottomLeftPanel.add(startPos);
        bottomLeftPanel.add(Box.createRigidArea(new Dimension(50, 105)));

        bottomRightPanel.add(course);

        bottomPanel.add(Box.createRigidArea(new Dimension(80, 140)));
        bottomPanel.add(bottomLeftPanel);
        bottomPanel.add(bottomRightPanel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        //This call makes all of the layouts fit the preferred size
        frame.pack();
        frame.setVisible(true);

    }

     /**
     * Makes the sliders for the frame
     */
     public void makeSliders() {
         final int MAX_FRIC = 6;
         final int MIN_FRIC = 3;
         final int INIT_FRIC = 4;

         final int MAX_POSIT = course.getHeight() - 20;
         final int MIN_POSIT = 20;
         final int INIT_POSIT = course.getHeight()/2;

         final int MAX_MASS = 50;
         final int MIN_MASS = 20;
         final int INIT_MASS = 30;

         final int MAX_VEL = 120;
         final int MIN_VEL = 20;
         final int INIT_VEL = 60;

         final int MAX_ANG = 45;
         final int MIN_ANG = -45;
         final int INIT_ANG = 0;

         Dimension sliderDimension = new Dimension (400, 70);

         friction = createSlider(MIN_FRIC, MAX_FRIC, INIT_FRIC, sliderDimension, "Grass",
                            "Dry sand", "Friction of wet sand");
         friction.setVisible(true);
         mass = createSlider(MIN_MASS, MAX_MASS, INIT_MASS, sliderDimension, MIN_MASS + " mass",
                            MAX_MASS + " mass", "Mass of the ball");
         mass.setVisible(true);
         velocity = createSlider(MIN_VEL, MAX_VEL, INIT_VEL, sliderDimension, "", "", "Initial Velocity of the ball");
         velocity.setVisible(true);

         angle = createSlider(MIN_ANG, MAX_ANG, INIT_ANG, sliderDimension, "-45", "45", "Angle");
         angle.setVisible(true);
         //Since we want the starting position slider to be verticle we are not able to use the "createSlider" method
         startPos = new JSlider(JSlider.VERTICAL, MIN_POSIT, MAX_POSIT, INIT_POSIT);
         Dimension vertSlider = new Dimension(70, course.getHeight());
         startPos.setPreferredSize(vertSlider);
         startPos.setMaximumSize(vertSlider);
         startPos.setMinimumSize(vertSlider);
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
          public void resetSettings(){
              Ball ball = course.getBall();
              double fin = (double)friction.getValue();
              fin = fin / 30;
              ball.setFriction(fin);
              ball.setMass(mass.getValue());
              ball.setInitialVelocity(velocity.getValue());
              ball.setInitialY(course.getHeight() - startPos.getValue());
              ball.setAngle(angle.getValue() * (Math.PI/180) * -1);

              //Repaints the course with the new setings
              course.repaint();
              //Continue setting all values
          }



          /**
          * This method will react when the buttons are pushed
          */
          public void actionPerformed(ActionEvent e) {
              String command = e.getActionCommand();

              //Determines what to do when action is detected
              if (command.equalsIgnoreCase("Start")){
                  //start simulation
                  course.getBall().setInitialVelocity(velocity.getValue() * 6);
                  course.getBall().setCurrentVelocity(velocity.getValue() * 6);
                  resetSettings();
                  
                  timer = null;
                  timer = new Timer(10, this);
                  timer.setActionCommand("Timer");
                  timer.start();
                  rbutton.setActionCommand("Reset");
                  rbutton.setText("Reset");

              }
              else if (command.equalsIgnoreCase("Reset")){
                  //reset simulation
                  //TO_DO make a method that resets the simulation
                  timer.stop();
                  sbutton.setActionCommand("Start");
                  sbutton.setText("Start");
                  course.makeNewBall();
                  course.getBall().setTime(0.01);
                  double fin = (double)friction.getValue();
                  fin = fin / 30;
                  course.getBall().setFriction(fin);
                  course.getBall().setFriction(friction.getValue());
                  course.getBall().setInitialVelocity(velocity.getValue() * 6);
                  course.repaint();
              }
              else if (command.equalsIgnoreCase("Pause")){
                  //pause simulation
                  timer.stop();
                  sbutton.setActionCommand("Continue");
                  sbutton.setText("Continue");
                  rbutton.setActionCommand("Reset");
                  rbutton.setText("Reset");
              }
              else if (command.equalsIgnoreCase("Continue")){
                  //Continues the simulation
                  timer.start();
                  sbutton.setActionCommand("Start");
                  sbutton.setText("Start");
                  rbutton.setActionCommand("Reset");
                  rbutton.setText("Reset");
              }
              else if (command.equalsIgnoreCase("Timer")){;
                  course.repaint();
              }

          }
    /**
    * Updates everything when a slider is changed.
    * @Override
    */    
    public void stateChanged(ChangeEvent e)
    {
                  JSlider source = (JSlider) e.getSource();
                  if(!source.getValueIsAdjusting()){
                      resetSettings();
                  }
    }

}
