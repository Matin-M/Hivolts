import java.awt.*;

import javax.swing.JFrame;

public class HiVoltsMain extends Canvas {
	

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Canvas canvas = new HiVoltsMain();
		canvas.setSize(1000,1900);
		frame.getContentPane().add(canvas);
		frame.pack();
		frame.setVisible(true);
	}
	

	public HiVoltsMain() {
		init();	
	}
	
	
	public void init() {
		setSize(1900,1000);
		//setTitle("American flag");
		setBackground(Color.white);
		repaint();
	}
	

	/** Paint Method
	 * @param g - object of the graphics package
	 */
	public void paint(Graphics g) {
	
	}
	
}