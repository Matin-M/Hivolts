import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

import javax.swing.JFrame;

public class HiVoltsMain extends Canvas implements KeyListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<int[]> freeSpacefinder(ArrayList<int[]> freeerSpaces){
		for(int br=1;br<=10;br++){
			for(int br1=1;br1<=10;br1++){
				int[] curentPos={br,br1};
				freeerSpaces.add(curentPos);
//				System.out.println(freeerSpaces.get((br-1)*10+(br1-1))[0]);
//				System.out.println(freeerSpaces.get((br-1)*10+(br1-1))[1]);
			}
		}
		return freeerSpaces;
	}
	public static int RNGesus(int randsize){
		return (int)(1+Math.random()*randsize);
	}
	
	public static void main(String[] args) throws Exception {
		final int xRes = 600;
		final int yRes = 600;
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Canvas canvas = new HiVoltsMain();
		canvas.setSize(xRes, yRes);
		frame.getContentPane().add(canvas);
		frame.setPreferredSize(new Dimension(xRes, yRes));
		frame.setSize(xRes, yRes);
		frame.pack();
		frame.setVisible(true);
		
		
		//Redo try catch
		File save = null;
		String path = null;
		try{
			save = new File("game-field.txt");
			path = save.getAbsolutePath();
		}catch(Exception e){
			System.err.println("The game file was not located! Specific Error: " + e.getMessage());
		}
			File gameField = new File(path);
			Iterator<String> fieldLinesIt = Files.lines(gameField.toPath()).iterator();
			while (fieldLinesIt.hasNext()) {
				String fieldLine = fieldLinesIt.next();
				// initialize game matrix
				System.out.println(fieldLine);
			}
		
		
		Obstacles[][] Matrix = new Obstacles[12][12];
//		ArrayList[][] freeSpaces= new ArrayList[10][10];
		ArrayList<int[]> freeerSpaces= new ArrayList<int[]>();
		freeerSpaces=freeSpacefinder(freeerSpaces);
		int[][]MhoPositions=new int[12][2];
		int[][]FencePositions=new int[20][2];
		for(int br=0;br<12;br++){
			int RNGHelper=RNGesus(freeerSpaces.size());
			MhoPositions[br][0]=freeerSpaces.get(RNGHelper)[0];
			MhoPositions[br][1]=freeerSpaces.get(RNGHelper)[1];
			freeerSpaces.remove(RNGHelper);
		}
		for(int br=0;br<20;br++){
			int RNGHelper=RNGesus(freeerSpaces.size());
			FencePositions[br][0]=freeerSpaces.get(RNGHelper)[0];
			FencePositions[br][1]=freeerSpaces.get(RNGHelper)[1];
			freeerSpaces.remove(RNGHelper);
		}
		
		for(int br=0;br<12;br++){
			System.out.println(MhoPositions[br][0]+", "+MhoPositions[br][1]);
			Matrix[MhoPositions[br][0]][MhoPositions[br][1]]=new Mho();
		}
		System.out.println();
		for(int br=0;br<20;br++){
			System.out.println(FencePositions[br][0]+", "+FencePositions[br][1]);
			Matrix[FencePositions[br][0]][FencePositions[br][1]]=new Fence();
		}
		/*
		for(int i = 0; i < 12; i++){
			for(int x = 0; x < 12; x++){
				if(Matrix[i][x] instanceof Fence){
					
				}else if(){
					
				}else if(){
					
				}
			}
		}
		*/
		
	}
	
	public void 
	
	public HiVoltsMain() {
		init();	
	}
	
	
	public void init() {
		setBackground(Color.white);
		repaint();
	}
	
	
	
	//Test Mhos
	public void pMho(Graphics g){
		Mho test = new Mho();
		System.out.println(getWidth()+" "+getHeight());
		g.drawImage(test.imageMaker(), 162, 162, getWidth()/12, getHeight()/12, null);
	}
	
	public void outerFence(Graphics g){
		Fence outer = new Fence();
		int lineX = getWidth()/12;
		int lineY = getHeight()/12;
		int xmod = 0;
		for(int i = 1; i <= 12; i++){
			g.drawImage(outer.imageMaker(), xmod, 0, getWidth()/12, getHeight()/12, null);
			xmod += lineX; 
		}
		
	}
	
	public void paintGrid(Graphics g){
		//Paint a grid
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
	

	int keyBla;
	/** Paint Method
	 * @param g - object of the graphics package
	 */
	public void paint(Graphics g) {
		pMho(g);
		outerFence(g);
		paintGrid(g);
		
		this.addKeyListener(this);
//		System.out.println(keyBla);
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
