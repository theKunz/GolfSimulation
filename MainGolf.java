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
    static JSlider friction;
    static JSlider startPos;
    static JSlider mass;
    static JSlider width;
    static JPanel menu;
    static JPanel view;
    
    public MainGolf()
    {
        
    }
    
    public static void main(String[] args) 
    {
        Course c = new Course();
        c.setBounds(30, 340, 740, 200);
        
        
        JFrame f = new JFrame();
        f.setTitle("Minigolf Simulation");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        f.setBounds(center.x - 800 / 2, center.y - 600 / 2, 800,
        600);
        
        friction = new JSlider();
        startPos = new JSlider();
        mass = new JSlider();
        width = new JSlider();
        menu = new JPanel();
        view = new JPanel();
        
        startPos.setOrientation(SwingConstants.VERTICAL);
        startPos.setMaximum(160 - width.getValue());
        startPos.setMinimum(0 + width.getValue());
        
        menu.add(startPos);
        menu.add(friction);
        menu.add(mass);
        menu.add(width);
        
        //view.add(c);
        
        //f.add(view, BorderLayout.SOUTH);
        f.add(menu);
        f.add(c);
        f.setVisible(true);
        f.setResizable(false);
        
    }
    
}
