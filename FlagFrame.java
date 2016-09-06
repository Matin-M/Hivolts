import java.awt.*;

import javax.swing.JFrame;

public class FlagFrame extends Canvas {
	
	/*Matin Massoudi
	 * Period 4
	 * American Flag project
	 * 
	 */
	
	/**Main Method 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Canvas canvas = new FlagFrame();
		canvas.setSize(1000,1900);
		frame.getContentPane().add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	
	/** FlagFrame constructor to create objects
	 * 
	 */
	public FlagFrame () {
		init();	
	}
	
	
	public void init() {
		setSize(1900,1000);
		//setTitle("American flag");
		setBackground(Color.white);
		repaint();
	}
	

	/** Paints and calls star methods
	 * @param g - object of the graphics package
	 */
	public void paint(Graphics g) {
		
		int width = getWidth();
		int height = getHeight();
		
		
		//Adjusts the resolution so its 1/1.9
		boolean stop = true;
		for(int i = getWidth(); i > 0 ;i--){
			for(int k = getHeight(); k > 0 ;k--){
				if((double)i/k == 1.9){
					height = k;
					width = i;
					stop = false;
					break;	
				}
			}
			if(stop == false){
				break;
			}
			
		}
		
		//Make the stripes
		double stripe = height/13;
		g.setColor(Color.red);
		int four = 0;
		
		//Alternate between red and white
		for(double i = 0; i <= 13; i++){
			g.fillRect(0, (int)(i*stripe), width, (int)(stripe));
			if(i == 7){
				four = (int)(i*stripe);
			}
			if(g.getColor() == Color.red){
				g.setColor(Color.white);
			}else if(g.getColor() == Color.white){
				g.setColor(Color.red);
			}
		}
		
		g.setColor(Color.blue);
		g.fillRect(0, 0, (int)(width*.4), four);
		
		//Make Stars
		makeStars(g, width, height);
	}
	
	/**
	 * Given the following parameters, a single star will be created(Given x and y positions the star will be created in that location).
	 * @param g - object of the graphics package
	 * @param x - x coordinate
	 * @param y - y coordinate
	 */
	public void drawStar(Graphics g, int x, int y, double scaleFactor){
		
		//System.out.println("drawStar method invoked!");
		//Array of x and y coordinates for outer.
		int[] xc = new int[5];
		int[] yc = new int[5];
		int[] xic = new int[5];
		int[] yic = new int[5];
		int[] xc2 = new int[10];
		int[] yc2 = new int[10];
		;
		
		for(int i = 0; i < 5; i++){
			//System.out.println("i: "+i);
			xc[i] = x+(int) (scaleFactor/3 *     Math.cos((i * ((2 * Math.PI) / 5) ) + ((2*Math.PI) / 10)));//Did not have math.pi/10
			yc[i] = y+(int) (scaleFactor/3 *     Math.sin((i * ((2 * Math.PI) / 5) ) + ((2*Math.PI) / 10)));//Did not have math.pi/10
			//System.out.println("Outer : x: "+xc[i]+"   y: "+yc[i]+"  ");
			xic[i] = x+(int) (scaleFactor/6 * Math.cos((i * ((2 * Math.PI) / 5) ) + ((4*Math.PI) / 10) ));//
			yic[i] = y+(int) (scaleFactor/6 * Math.sin((i * ((2 * Math.PI) / 5) ) + ((4*Math.PI) / 10) ));//Use 2pi/10 
			//System.out.println("Inner: x: "+xc[i+1]+"   y: "+yc[i+1]+"  ");
			//System.out.println(scaleFactor);
		}
		
		//Star integration for inner and outer
		for(int i = 0; i < 10; i+=2){
			xc2[i] = xc[i/2];
			yc2[i] = yc[i/2];
			xc2[i+1] = xic[i/2];
			yc2[i+1] = yic[i/2];
		}
		

		//Create the star.
				g.setColor(Color.white);
				g.fillPolygon(yc2, xc2, 10);
				
	}
	
	/**
	 * Used to create multiple stars for the flag. This method is used to organize multiple stars on the flag
	 * @param g - object of the graphics package
	 * @param width - the width of the star
	 * @param height - the height of the star
	 */
	
	public void makeStars(Graphics g, int width, int height){
		//System.out.println("makeStars method invoked!");
		//drawStar actual parameters: (g, y, x, scale factor)
		
		//Starting Stars
		//System.out.println(width+" "+height);
		int x = (int) (0.063*height);
		int y = (int) (0.054*height);
		
		//System.out.println(x+" "+y);
		//Actual offsets
		int m = (int) (0.063*2*height);
		int a = (int) (0.054*2*height);
		
		//Storage values
		int j = x;	
		int k = y;
		
		//Makes the first part of the flag
		for(int i = 1; i <=5; i++){
			j = x;
			for(int z = 0; z<6; z++){
				drawStar(g, k, j, (0.0616* height));//og value is .0616
				j += m;
			}
			k+=a;
		}
		
		//Starting stars
		int x2 = (int) (0.126*height);
		int y2 = (int) (0.108*height);
		
		//System.out.println(x2+" "+y2);
		//Actual offsets
		int m2 = (int) (0.063*2*height);
		int a2 = (int) (0.054*2*height);
		
		//Storage values
		int j2 = x2;	
		int k2 = y2;
		
		//Makes the second part of the flag
		for(int i = 1; i <=4; i++){
			j2 = x2;
			for(int z = 0; z<5; z++){
				drawStar(g, k2, j2, (0.0616 * height));//og value is .0616
				j2 += m2;
			}
			k2+=a2;
		}
			
	}
		
	
	
	
	
}