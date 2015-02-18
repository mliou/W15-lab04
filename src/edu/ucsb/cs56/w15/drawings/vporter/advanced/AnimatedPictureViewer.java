package edu.ucsb.cs56.w15.drawings.vporter.advanced;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimatedPictureViewer {

    private DrawPanel panel = new DrawPanel();
    
    Thread anim;  
    Thread anim2;
 
    //Information for Robot 1
    int xCoordinate = 100;
    int yCoordinate = 100;
    int size = 300;
    int sizeChange = 1;
    int xSpeed = 5;
    int antennaeSize = 10;

    //Information for Robot 2
    int x2Coordinate = 700;
    int y2Coordinate = 100;
    int size2 = 300;
    int size2Change = 1;
    int x2Speed = -5;

    public static void main (String[] args) {
      new AnimatedPictureViewer().go();
    }

    public void go() {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      frame.getContentPane().add(panel);
      frame.setSize(640,480);
      frame.setVisible(true);
      
      frame.getContentPane().addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e){
        System.out.println("mouse entered");
          anim = new Animation();
          anim.start();
        }

        public void mouseExited(MouseEvent e){        
          System.out.println("Mouse exited");
          anim.interrupt();
          while (anim.isAlive()){}
          anim = null;         
          panel.repaint();        
        }
	public void mouseClicked(MouseEvent arg0) {
	    System.out.println("here was a click ! ");
	    anim2 = new Animation2();
	    anim2.start();
	}
      });
      
    } // go()

    class DrawPanel extends JPanel {
       public void paintComponent(Graphics g) {

        Graphics2D g2 = (Graphics2D) g;

         // Clear the panel first
          g2.setColor(Color.GREEN);
          g2.fillRect(0,0,this.getWidth(), this.getHeight());

          g2.setColor(Color.BLACK);
          RobotWithFeatures test = new RobotWithFeatures(xCoordinate, yCoordinate, size, antennaeSize);
          g2.draw(test);
	  RobotWithFeatures test2 = new RobotWithFeatures(x2Coordinate,y2Coordinate, size2, 10);
	  g2.setColor(Color.PINK);
	  g2.draw(test2);
       }
    }
    
    class Animation extends Thread {
      public void run() {
        try {
          while (true) {

	    if (x2Coordinate <= 400) { antennaeSize +=2; }
	    if (antennaeSize == 100) { antennaeSize -=2;}
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }

    class Animation2 extends Thread {
      public void run() {
        try {
          while (true) {
            // Bounce off the walls

            if (x2Coordinate >= 400) { x2Speed = -5; }
            if (x2Coordinate <= 400) { x2Speed = 0; }
	           
            x2Coordinate += x2Speed;
    
            panel.repaint();
            Thread.sleep(50);
          }
        } catch(Exception ex) {
          if (ex instanceof InterruptedException) {
            // Do nothing - expected on mouseExited
          } else {
            ex.printStackTrace();
            System.exit(1);
          }
        }
      }
    }
    
    
}
