import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import javax.swing.JFrame;

public class HiVoltsMain extends Canvas implements KeyListener {
	/**
	 * 
	 */
	public static int PX=0;
	public static int PY=0;
	private static final long serialVersionUID = 1L;
	private Thread keyListener=new Thread(){

		HashSet<Integer> acceptedButtons =
				new HashSet<Integer>(Arrays.asList(81, 87, 69, 65, 83, 68, 90, 88, 67));
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(acceptedButtons.contains(keyBla)){
					int tempX=PX;
					int tempy=PY;
					if(keyBla==81){
						PX-=1;
						PY-=1;
					}
					else if(keyBla==87){
						PY-=1;
					}
					else if(keyBla==69){
						PX+=1;
						PY-=1;
					}
					else if(keyBla==65){
						PX-=1;
					}
					else if(keyBla==83){
						PX=PX;
					}
					else if(keyBla==68){
						PX+=1;
					}
					else if(keyBla==90){
						PX-=1;
						PY+=1;
					}
					else if(keyBla==88){
						PY+=1;
					}
					else if(keyBla==67){
						PX+=1;
						PY+=1;
					}
					
					repaint();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}
	};

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
		return (int)(1+Math.random()*(randsize-1));
	}
	
	static Obstacles[][] Matrix = new Obstacles[12][12];
	public static void Randomiser(){
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
		int RNGHelper1=RNGesus(freeerSpaces.size());
		PX=freeerSpaces.get(RNGHelper1)[0];
		PY=freeerSpaces.get(RNGHelper1)[1];
		freeerSpaces.remove(RNGHelper1);
		for(int br=0;br<12;br++){
//			System.out.println(MhoPositions[br][0]+", "+MhoPositions[br][1]);
			Matrix[MhoPositions[br][0]][MhoPositions[br][1]]=new Mho();
		}
//		System.out.println();
		for(int br=0;br<20;br++){
//			System.out.println(FencePositions[br][0]+", "+FencePositions[br][1]);
			Matrix[FencePositions[br][0]][FencePositions[br][1]]=new Fence();
		}

	}

	public static void main(String[] args) throws Exception {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Canvas canvas = new HiVoltsMain();
		canvas.setSize(1000,1000);
		frame.getContentPane().add(canvas);
		frame.pack();
		frame.setVisible(true);

		/*
		File gameField = new File("C:\\Users\\Ivo\\workspace\\Hivolts\\game-field.txt");
		Iterator<String> fieldLinesIt = Files.lines(gameField.toPath()).iterator();
		while (fieldLinesIt.hasNext()) {
			String fieldLine = fieldLinesIt.next();
			// initialize game matrix
			System.out.println(fieldLine);
		}
//		ArrayList[][] freeSpaces= new ArrayList[10][10];
 * */

		Randomiser();
	}
	

	public HiVoltsMain() {
		keyListener.start();
		init();	
	}
	
	
	public void init() {
		setSize(1000,1000);
		setBackground(Color.white);
		repaint();
	}
	public void paintAll(Graphics g){
		for(int i = 0; i < 12; i++){
			for(int n = 0; n < 12; n++){
//				System.out.println(n+"  "+i);
				if(Matrix[i][n] instanceof Fence){
					g.drawImage(Matrix[i][n].imageMaker(), getWidth()/12*i, getHeight()/12*n, getWidth()/12, getHeight()/12, null);
//					System.out.println("fence excecuted");
				}else if(Matrix[i][n] instanceof Mho){
					g.drawImage(Matrix[i][n].imageMaker(), getWidth()/12*i, getHeight()/12*n, getWidth()/12, getHeight()/12, null);
//					System.out.println("mho excecuted");
				}
			}
		}
		
	}
	
	public static void outerFence(Graphics g){
		Fence outer = new Fence();
		for(int i = 0; i <= 11; i++){
			Matrix[i][0]=new Fence();
			Matrix[0][i]=new Fence();
			Matrix[i][11]=new Fence();
			Matrix[11][i]=new Fence();
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


	static int keyBla;
	/** Paint Method
	 * @param g - object of the graphics package
	 */
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		this.addKeyListener(this);
		paintGrid(g);
		outerFence(g);
		paintAll(g);
		g.setColor(Color.GREEN);
		g.fillOval(getWidth()/12*PX, getHeight()/12*PY, getWidth()/12, getHeight()/12);
		System.out.println(PX+", "+PY);
//		System.out.println(keyBla);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
