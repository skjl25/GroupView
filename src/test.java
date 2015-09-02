
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Struct;
import java.util.Arrays;
import java.util.StringTokenizer;

import processing.core.*; 
public class test extends PApplet{
	 
	boolean locked=false;
	double bx;
	double by;
	double bdifx = 0.0; 
	double bdify = 0.0; 
	PFont fontA;
	PFont myFont;

	int bs [];
	boolean bover = false;
	int activeVal;
	
	//added for length of array of size of each thread
	int length;
	
	//values for implementing each circle
	int xSize[];
	int ySize[];
	int xLocation[];
	int yLocation[];
	
	//y_axis is the value of size of each thread of newsgroup
	//x_axis is the value of time that start posting posted of each thread of newsgroup
	int y_axis [];
	int x_axis [];

	
	//setup function to set up visualization
	public void setup() {

		threadSize();
		
		y_axis = new int[length];
		x_axis = new int[length];
		y_axis = threadSize();
		

		x_axis = threadStartTime();
		
		xSize = new int [length];
		ySize = new int [length];
		bs = new int [length];
		xLocation = new int [length];
		yLocation = new int [length];

		int i;
		for(i=0; i < length; i++)
		{
			xSize[i] = y_axis[i];
			ySize[i] = y_axis[i];
			xLocation[i] = x_axis[i]/2;
			yLocation[i] = 640 - (ySize[i] * 3);
//		System.out.println("Index is " + i);			
			bs[i] = y_axis[i] / 2;
		}	
		
		activeVal=10;
		size(1080,640);
		background(0);
    	noStroke();
		frameRate(30);
		myFont = loadFont("Garamond-20.vlw"); 
		textFont(myFont,20);
		textMode(SCREEN);
		textAlign(CENTER);
  		
	}
	
	//expanding the size of the circle by placing the cursor of the mouse
	public void expandCircle(int index)
	{
		if (mouseX > xLocation[index]-bs[index] && mouseX < xLocation[index]+bs[index] && 
			      mouseY > yLocation[index]-bs[index] && mouseY < yLocation[index]+bs[index]) 
		{
			    bover = true;  
			    if(!locked) 
			    { 
			    	xSize[index]=200;
			    	ySize[index]=200;
			    	fill(255);
					text ( "Recent Message" ,xLocation[index],yLocation[index]); 
	
			    }
		}
		else 
		{
			xSize[index] = y_axis[index];
			ySize[index] = y_axis[index];
		    bover = false;
		}			

	}
	
	//draw function to draw whole universe
	public void draw() {
		background(0);
		fill(255);        // Step 5: Specify font color

		int i;
		int color1;
		int color2;
		for(i=0; i < length; i++)
		{
			color1 = y_axis[i];
			color2 = y_axis[i];
			fill(color1, 229, 256 - color2);
			ellipse(xLocation[i], yLocation[i], xSize[i], ySize[i]);
			expandCircle(i);
		}
	}

	// Whenever a user presses a key the code written inside keyPressed() is executed.
	public void keyPressed() {
		background(0);
	}
	public void mouseDragged() {
		  if(locked) {
		    bx = mouseX-bdifx; 
		    by = mouseY-bdify; 
		  }
	}
	public void mouseReleased() {
		  locked = false;
	}
	
	//this function shows size of each thread; calculating how many posts are in the thread
	public int [] threadSize() {
	    File posting_num = new File("C:\\size_data.txt");
		StringBuilder contents = new StringBuilder();
		
		try {
			
			BufferedReader input =  new BufferedReader(new FileReader(posting_num));
			try {
				String line = null;
				
				while (( line = input.readLine()) != null){
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			}
			finally {
				input.close();
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
    
		String text_str = contents.toString();
		StringTokenizer st_1 = new StringTokenizer(text_str, " ");
		StringTokenizer st_2 = new StringTokenizer(text_str, " ");
		
		int counter = 0;
		while(st_1.hasMoreTokens()){
			st_1.nextToken();
			counter++;
		}
		counter--;
		int data [] = new int [counter];
		int i = 0;

		String temp = new String();
		while(i < counter){
			temp = st_2.nextToken();
			data[i] = Integer.parseInt(temp);
			i++;

		}
		
		length = counter;

		return data;
	}
	
	//this function shows posted time of starting posting of each thread of newsgroup
	public int [] threadStartTime()
	{
		
	    File posting_time = new File("C:\\time_data.txt");
		StringBuilder contents = new StringBuilder();
		try {
			
			BufferedReader input =  new BufferedReader(new FileReader(posting_time));
			try {
				String line = null;
				
				while (( line = input.readLine()) != null){
					contents.append(line);
					contents.append(System.getProperty("line.separator"));
				}
			}
			finally {
				input.close();
			}
		}
		catch (IOException ex){
			ex.printStackTrace();
		}
    
		String text_str = contents.toString();
		StringTokenizer st_1 = new StringTokenizer(text_str, " ");
		StringTokenizer st_2 = new StringTokenizer(text_str, " ");
		String hour_str = new String();
		String min_str = new String();
		int hour_int = 0;
		int min_int = 0;
		
		int counter = 0;
		while(st_1.hasMoreTokens()){
			st_1.nextToken();
			counter++;
		}
		counter--;
		int data [] = new int [counter];
		int i = 0;
		
		String temp = new String();
		while(i < counter){
			temp = st_2.nextToken();			
			StringTokenizer st_3 = new StringTokenizer(temp, ":");
			hour_str = st_3.nextToken();
			min_str = st_3.nextToken();
			hour_int = Integer.parseInt(hour_str);
			min_int = Integer.parseInt(min_str);
			
			data[i] = hour_int * 60 +min_int;
			i++;

		}
		
		length = counter;

		
		return data;
	}
} 
