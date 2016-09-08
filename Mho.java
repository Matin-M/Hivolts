import java.awt.Canvas;

public class Mho{
	//Private data fields
	private int x;
	private int y;
	
	//Main constructor
	public Mho(){
		x = randRange();
		y = randRange();
		boolean loopVar = true;
		while(loopVar){
			if(x == 0  x  ){
				
			}
		}
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
