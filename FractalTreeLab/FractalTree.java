//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class FractalTree extends JPanel
{
   private final int PANEL_WIDTH = 1200;
   private final int PANEL_HEIGHT = 1500;

   private final double SQ = Math.sqrt(3.0) / 6;

   private final int TOPX = 200, TOPY = 20;
   private final int LEFTX = 60, LEFTY = 300;
   private final int RIGHTX = 340, RIGHTY = 300;

   private int current; //current order

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public FractalTree (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (int x1, int y1, double branchLength, double currentAngle, Graphics page)
   {
         double a = branchLength;
         double b = currentAngle;
         int newY= (int)(y1+branchLength*Math.cos(currentAngle)*0.8);
         int newX= (int)(x1+branchLength*Math.sin(currentAngle)*0.8);
         int newX2=(int)(x1-branchLength*Math.sin(currentAngle)*0.8);
         page.drawLine (x1, y1, newX, newY);
         page.drawLine (x1, y1, newX2 , newY);
         a= (a * 0.8 );
         
         if (a > 0.005)
         {
             drawFractal (newX , newY , a , b ,  page);
             drawFractal (newX2 , newY , a , b ,  page);
             
         }
         
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);
      page.setColor (Color.green);
      drawFractal ( 600,  800,  100.0, 20.0  , page);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
