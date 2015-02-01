package edu.ucsb.cs56.w15.drawings.neidler.advanced;

import edu.ucsb.cs56.w15.drawings.utilities.GeneralPathWrapper;

import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by nick on 2/1/15.
 */
public class BlankCreditCard extends GeneralPathWrapper implements Shape {
    /**
     Constructor

     @param x x coord of lower left corner of card
     @param y y coord of lower left corner of card
     @param width width of the card
     @param height of card
     */
    public BlankCreditCard(double x, double y, double width, double height)
    {
        double firstStoryHeight = .75 * height;
        double roofHeight = height - firstStoryHeight;

        double firstStoryUpperLeftY = y + roofHeight;

        Rectangle2D.Double firstStory =
                new Rectangle2D.Double(x, firstStoryUpperLeftY ,
                        width, firstStoryHeight);

        Line2D.Double leftRoof =
                new Line2D.Double (x, y + roofHeight,
                        x + width/2.0, y);

        Line2D.Double rightRoof =
                new Line2D.Double (x + width/2.0, y,
                        x + width, y + roofHeight);

        GeneralPath wholeHouse = this.get();
        wholeHouse.append(firstStory, false);
        wholeHouse.append(leftRoof, false);
        wholeHouse.append(rightRoof, false);

    }
}
