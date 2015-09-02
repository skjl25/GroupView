import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.*;

import processing.core.*; 

public class GroupView {
	   public static void main(String[] args) {
		   
	   
        	GetCircle points= new GetCircle();
         	JFrame frame = new JFrame("Points");
        	points.setBackground(Color.black);
         	points.setOpaque(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(640, 480);

        	//setting the location of the circle
            frame.add(points);
            //setting the window to particular location
            frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	        frame.setLayout(null);
	        
	        
		   
      }
}
