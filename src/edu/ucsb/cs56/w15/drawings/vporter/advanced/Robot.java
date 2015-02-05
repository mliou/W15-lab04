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
   A vector drawing of a house that implements
   the Shape interface, and so can be drawn, as well as
   rotated, scaled, etc.
      
   @author Victor Porter 
   @version for CS56, Winter 11, UCSB
   
*/
public class Robot extends GeneralPathWrapper implements Shape
{
    /**
       Constructor

       @param x x coord of upper left corner of the head
       @param y y coord of upper left corner of the head
       @param width width of the house
       @param height of house (including first story and second story)
     */
    public Robot(double x, double y, double width, double height)
    {
        
        double headHeight = .25 * height;
        double armHeight = .5 * height;
	      double bodyHeight = .45 * height;
      	double legHeight = .3 * height;
        double armWidth = .5 * headHeight;
        double legWidth = armWidth;
        
        double headUpperLeftY = y;
	      double armUpperLeftY = y + headHeight + .25 * bodyHeight;
      	double bodyUpperLeftY = y + headHeight;
      	double legUpperLeftY = y + headHeight + bodyHeight;
 	
       	double headUpperLeftX = x;
	      double bodyUpperLeftX = x - .25 * bodyHeight;
      	double arm1UpperLeftX = x - .5 * bodyHeight;
      	double arm2UpperLeftX = x + headHeight + .25 * bodyHeight;
      	double leg1UpperLeftX = x;
      	double leg2UpperLeftX = x + .5 * headHeight;
        
        // Make the first story
        
        Rectangle2D.Double head = 
            new Rectangle2D.Double(x, y , headHeight, headHeight);
                          
        Rectangle2D.Double body = 
            new Rectangle2D.Double (bodyUpperLeftX, bodyUpperLeftY, bodyHeight, bodyHeight);

        Rectangle2D.Double arm1 =
            new Rectangle2D.Double (arm1UpperLeftX, armUpperLeftY, armWidth, armHeight);

        Rectangle2D.Double arm2 =
            new Rectangle2D.Double (arm2UpperLeftX, armUpperLeftY, armWidth, armHeight);

        Rectangle2D.Double leg1 =
            new Rectangle2D.Double (leg1UpperLeftX, legUpperLeftY, legWidth, legHeight);

        Rectangle2D.Double leg2 =
            new Rectangle2D.Double (leg2UpperLeftX, legUpperLeftY, legWidth, legHeight);

        Rectangle2D.Double mouth =
            new Rectangle2D.Double (x + .25 * headHeight, y + .6 * headHeight, .5 * headHeight, .25 * headHeight);

        Circle eye1 =
           new Circle (x + .25 * headHeight, y + .25 * headHeight, headHeight/10);

        Circle eye2 =
           new Circle (x + .75 * headHeight, y + .25 * headHeight, headHeight/10);
       
        GeneralPath wholeRobot = this.get();
        wholeRobot.append(head, false);
        wholeRobot.append(body, false);
        wholeRobot.append(arm1, false); 
        wholeRobot.append(arm2, false);
        wholeRobot.append(leg1, false); 
        wholeRobot.append(leg2, false); 
        wholeRobot.append(mouth, false); 
        wholeRobot.append(eye1, false);
        wholeRobot.append(eye2, false);
        
    }

}
