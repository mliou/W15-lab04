package edu.ucsb.cs56.w15.drawings.jaredbjensen.advanced;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;  // single lines
import java.awt.geom.Ellipse2D;  // ellipses and circles
import java.awt.geom.Rectangle2D; // for the bounding box
import java.awt.Rectangle;  // squares and rectangles
import java.awt.geom.GeneralPath; // combinations of lines and curves
import java.awt.geom.AffineTransform; // translation, rotation, scale
import java.awt.Shape; // general class for shapes
import java.awt.Color; // class for Colors
import java.awt.Stroke;
import java.awt.BasicStroke;


import edu.ucsb.cs56.w15.drawings.utilities.ShapeTransforms;
import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

/**
 * A class with static methods for drawing various pictures
 * 
 * @author Phill Conrad 
 * @author Jared Jensen
 * @version for CS56, lab04, Winter 2015
 */


public class AllMyDrawings
{
    /** Draw a picture with a few computers 
     */

    public static void drawPicture1(Graphics2D g2) {

	Computer c1 = new Computer(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	

	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLUE); g2.draw(c2);
	
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// Draw two computers with screen on
	
	ComputerWithScreenOn cs1 = new ComputerWithScreenOn(50,350,40,75);
	ComputerWithScreenOn cs2 = new ComputerWithScreenOn(200,350,200,100);
	
	g2.draw(cs1);
	g2.setColor(new Color(0x8F00FF)); g2.draw(cs2);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A few computers by Jared Jensen", 20,20);
    }


	/** Draw a picture with a few computers with screens on
     	*/

    public static void drawPicture2(Graphics2D g2) {

	
	ComputerWithScreenOn large = new ComputerWithScreenOn(100,50,225,150);
	Computer smallCC = new Computer(20,50,40,30);
	ComputerWithScreenOn tallSkinny = new ComputerWithScreenOn(20,150,20,40);
	Computer shortFat = new Computer(20,250,40,20);
	
	g2.setColor(Color.RED);     g2.draw(large);
	g2.setColor(Color.GREEN);   g2.draw(smallCC);
	g2.setColor(Color.BLUE);    g2.draw(tallSkinny);
	g2.setColor(Color.MAGENTA); g2.draw(shortFat);
	
	Computer c1 = new Computer(100,250,50,75);
	g2.setColor(Color.CYAN); g2.draw(c1);
	
	// Make a black computer that's half the size, 
	// and moved over 150 pixels in x direction
	Shape c2 = ShapeTransforms.scaledCopyOfLL(c1,0.5,0.5);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	g2.setColor(Color.BLACK); g2.draw(c2);
	
	// Here's a house that's 4x as big (2x the original)
	// and moved over 150 more pixels to right.
	c2 = ShapeTransforms.scaledCopyOfLL(c2,4,4);
	c2 = ShapeTransforms.translatedCopyOf(c2,150,0);
	
	// We'll draw this with a thicker stroke
	Stroke thick = new BasicStroke (4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);       
	
	// for hex colors, see (e.g.) http://en.wikipedia.org/wiki/List_of_colors
	// #002FA7 is "International Klein Blue" according to Wikipedia
	// In HTML we use #, but in Java (and C/C++) its 0x
	
	Stroke orig=g2.getStroke();
	g2.setStroke(thick);
	g2.setColor(new Color(0x002FA7)); 
	g2.draw(c2); 
	
	// Draw two houses with Windows
	
	ComputerWithScreenOn cs1 = new ComputerWithScreenOn(50,350,40,75);
	ComputerWithScreenOn cs2 = new ComputerWithScreenOn(200,350,200,100);
	
	g2.draw(cs1);
	g2.setColor(new Color(0x8F00FF)); 

	// Rotate the second house 45 degrees around its center.
	Shape cs3 = ShapeTransforms.rotatedCopyOf(cs2, Math.PI/4.0);

	g2.draw(cs3);
	
	// @@@ FINALLY, SIGN AND LABEL YOUR DRAWING
	
	g2.setStroke(orig);
	g2.setColor(Color.BLACK); 
	g2.drawString("A bunch of computers by Jared Jensen", 20,20);
    }
  
    /** Draw a different picture with a few computers
     */

    public static void drawPicture3(Graphics2D g2) {
	
	// label the drawing
	
	g2.drawString("Some computers with screens on by Jared Jensen", 20,20);

	
	// Draw some computers
	
       ComputerWithScreenOn large = new ComputerWithScreenOn(100,250,100,75);
       ComputerWithScreenOn smallCC = new ComputerWithScreenOn(20,50,40,30);
       ComputerWithScreenOn other = new ComputerWithScreenOn(30,400,75,60);
       
       g2.setColor(Color.RED);     g2.draw(large);
       g2.setColor(Color.GREEN);   g2.draw(smallCC);
       g2.setColor(Color.BLACK);  g2.draw(other);
       
       
    }
    

}
