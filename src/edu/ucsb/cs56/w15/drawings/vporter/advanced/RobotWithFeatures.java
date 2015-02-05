package edu.ucsb.cs56.w15.drawings.vporter.advanced;
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes

// all imports below this line needed if you are implementing Shape
import java.awt.geom.Point2D; 
import java.awt.geom.Line2D; 
import java.awt.geom.Rectangle2D;
import java.awt.Rectangle;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;
import edu.ucsb.cs56.w15.drawings.vporter.simple.Circle;

import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;
/**
   A Robot with Buttons
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class RobotWithFeatures extends Robot implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public RobotWithFeatures(double x, double y, double width, double height,int antennae) {
    	
	// construct the basic Robot shell
	super(x,y,width,height);
	
	Circle button1 =
           new Circle (x + .85 * (.25 * height), y + (.25 * height) + (.25 * (.45 * height)), (.25 * height)/15);

    Circle button2 =
           new Circle (x + .85 * (.25 * height), y + (.25 * height) + (.50 * (.45 * height)), (.25 * height)/15);;

    Circle button3 =
           new Circle (x + .85 * (.25 * height), y + (.25 * height) + (.75 * (.45 * height)), (.25 * height)/15);;

    GeneralPath wholeRobot = this.get();
    wholeRobot.append(button1, false);
    wholeRobot.append(button2, false);
    wholeRobot.append(button3, false); 
    }

}
