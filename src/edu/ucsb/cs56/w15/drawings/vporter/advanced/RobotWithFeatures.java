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
   A House
      
   @author Phill Conrad 
   @version for CS56, W11, UCSB, 02/23/2011
   
*/
public class RobotWithFeatures extends Robot implements Shape
{
    /**
     * Constructor for objects of class CoffeeCup
     */
    public RobotWithFeatures(double x, double y, double width, double height,int antennae)
    {
	// construct the basic house shell
	super(x,y,width,height);

	// get the GeneralPath that we are going to append stuff to

	/*

	Circle button1 =
           new Circle (x + .25 * headHeight, y + .25 * headHeight, headHeight/15);

    Circle button2 =
           new Circle (x + .75 * headHeight, y + .25 * headHeight, headHeight/15);
	*/
	// add the windows to the house
	// Look up the meaning of the second parameter of append
	// (Hint--is a method of "GeneralPath")

        GeneralPath wholeHouse = this.get();
        //wholeHouse.append(win1, false);
        //wholeHouse.append(win2, false);
        //wholeHouse.append(win3, false); 
    }

}
