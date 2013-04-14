/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Andrew Koh
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


public class MainGolf {
    
    public static void main(String args[])
    {
        JFrame frame = new JFrame();
        frame.setSize(900, 600);
        frame.setAlwaysOnTop(true);
        frame.setLayout(new BorderLayout());
        JPanel menu = new JPanel();
        JPanel screen = new JPanel();
        
        Container myContainer = new Container();
        
        menu.setBackground(Color.blue);
        menu.setPreferredSize(new Dimension(900, 150));
        
        screen.setBackground(Color.green);
        screen.setPreferredSize(new Dimension(900, 450));
        frame.add(menu, BorderLayout.NORTH);
        frame.add(screen, BorderLayout.SOUTH);
        frame.setVisible(true);
        
    }
    
}
