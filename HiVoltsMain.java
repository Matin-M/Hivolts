import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Iterator;

import javax.swing.JFrame;

public class HiVoltsMain extends Canvas implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Canvas canvas = new HiVoltsMain();
		canvas.setSize(1000,1900);
		frame.getContentPane().add(canvas);
		frame.pack();
		frame.setVisible(true);
		
		File save = new File("game-field.txt");
		String path = save.getAbsolutePath();
		
	//	File gameField = new File("C:\\Users\\Ivo\\workspace\\Hivolts\\game-field.txt");
		File gameField = new File(path);
		Iterator<String> fieldLinesIt = Files.lines(gameField.toPath()).iterator();
		while (fieldLinesIt.hasNext()) {
			String fieldLine = fieldLinesIt.next();
			// initialize game matrix
			System.out.println(fieldLine);
		}
//		[][] Matrix; 
	}
	

	public HiVoltsMain() {
		init();	
	}
	
	
	public void init() {
		setSize(1900,1000);
		setBackground(Color.white);
		repaint();
	}
	

	int keyBla;
	/** Paint Method
	 * @param g - object of the graphics package
	 */
	public void paint(Graphics g) {
		this.addKeyListener(this);
		System.out.println(keyBla);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		repaint();
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		keyBla=arg0.getKeyCode();
//		System.out.println("keyPressed:" + arg0.getKeyCode());
	}


	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		keyBla=0;
//		System.out.println("keyReleased:" + e.toString());
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("keyTyped:" + e.toString());
	}
	
}
