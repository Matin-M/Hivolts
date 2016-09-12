import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Mho{
	//Private data fields
	private int x;
	private int y;
	
	public Mho(){
		
	}
	//Main constructor
	//Constructor formal parameters may vary depending on specifications. 
	public Mho(int width, int height){
		this.x = randRange();
		this.y = randRange();
		
		//This is to ensure that none of the mohos land on the outer fencing
		boolean loopVar = true;
		while(loopVar){
			if((x == 0) || (y == 0) || (x == width) || (y == height)){
				this.x = randRange();
				this.y = randRange();
				loopVar = false;
			}
		}
	}
	/**
	 * paint Mhos individual when called 
	 * @param g - Object of Graphics package
	 */
	public JLabel paintMho(){
		System.out.print("got");
		
		File file = new File("Java.png");
		final String path = file.getAbsolutePath();
		ImageIcon icon = new ImageIcon(path);
		JLabel label = new JLabel("Image and Text", icon, JLabel.CENTER);

		return label;
	}
	
	/**
	 * Randomize location for the Mhos
	 * @return
	 */
	public int randRange(){
		return 12+(int)(Math.random()*12);
	}
	
	
	//Getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}


	
}