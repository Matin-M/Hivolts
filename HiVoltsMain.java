import java.awt.*;

import javax.swing.*;

public class HiVoltsMain extends JPanel {
	
	static JFrame frame;

	public static void main(String[] args) {
		frame = new JFrame("HiVolts");
		frame.setSize(1200, 1200);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(new HiVoltsMain());
		//frame.pack();
		
	}
	public HiVoltsMain(){
		setLayout(new GridLayout(12,12));
	}
	
	
	public void Mhos(){
		Mho test = new Mho(123,1233);
		add(test.paintMho());
		
	}
	
	
	/**Make a Grid for testing
	 * 
	 * @param g - Object of the graphics package
	 */
	public void Grid(Graphics g){
		int lineX = getWidth()/12;
		int lineY = getHeight()/12;
		
		int xmod = lineX;
		for(int i = 1; i <= 12; i++){
			g.drawLine(xmod, 0, xmod, getHeight());
			xmod += lineX; 
		}
		
		int ymod = lineY;
		for(int i = 1; i <= 12; i++){
			g.drawLine(0, ymod, getWidth(), ymod);
			ymod += lineY; 
		}
	}
	
	/** Paint Method
	 * @param g - Object of the graphics package
	 */
	@Override
	public void paint(Graphics g) {
		Grid(g);
		Mhos();
		
	}
	
}