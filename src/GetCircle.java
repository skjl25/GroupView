import java.awt.*;
import javax.swing.*;

import java.awt.geom.*;
import java.awt.dnd.*;


public class GetCircle extends JPanel {
	double xCoord=0.0;
	double yCoord=0.0;

	//Done by John Lee
    public void paintComponent(Graphics g)
    {

    	super.paintComponent(g); 
    	Graphics2D g2d = (Graphics2D) g;
           	
    	//Creating the circle
//    	GradientPaint gradient=new GradientPaint(50,180,Color.white,80,210,Color.white,true);
  //  	GradientPaint gradient2=new GradientPaint(50,180,Color.white,80,210,Color.white,true);
    	

    	Ellipse2D.Double circle = new Ellipse2D.Double(0,380,60,60);
    	Ellipse2D.Double circle2 = new Ellipse2D.Double(0,200,100,100);
       	Ellipse2D.Double circle3 = new Ellipse2D.Double(20,20,140,140);
        
       	
//       	circle.
//    	g2d.setColor(Color.white);
    	g2d.setColor(new Color(46, 229,138));
    	g2d.fill(circle);
        g2d.draw(circle);
     //   g2d.se
    	g2d.setColor(new Color(107, 229,46));
    	g2d.fill(circle2);
        g2d.draw(circle2);
        
    	g2d.setColor(new Color(168,229,46));
    	g2d.fill(circle3);
        g2d.draw(circle3);
       
        repaint();
    }
    
}

