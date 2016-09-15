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

public class Mho extends Obstacles{
	//Private data fields
	private int x;
	private int y;
	
	public Mho(){
		
	}
	//Main constructor
	//Constructor formal parameters may vary depending on specifications. 
	public Mho(int width, int height){
		
	}
	/**
	 * paint Mhos individual when called 
	 * @param g - Object of Graphics package
	 */
	
	public BufferedImage imageMaker(String fileName){
		//Name of the file in workspace
		File image = new File(fileName);
		String path = image.getAbsolutePath();
		BufferedImage img = null;
		 try {
             img = ImageIO.read(new File(path));
         } catch (IOException e) {
        	 System.out.println("Oops! There was an error: " + e);
         }
		 return img; 
	}
	
	/**
	 * Randomize location for the Mhos
	 * @return
	 */
	/*
	public int randRange(){
		return 12+(int)(Math.random()*12);
	}
	*/
	
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
