import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class HiVoltsMain extends Canvas implements KeyListener {
	/**
	 * 
	 */
	public static int PX=0;
	public static int PY=0;
	public Graphics g;
	public static int arrayPosition = -1;
	public static boolean gameOver=false;
	private static final long serialVersionUID = 1L;
	private Thread keyListener=new Thread(){

		HashSet<Integer> acceptedButtons =
				new HashSet<Integer>(Arrays.asList(81, 87, 69, 65, 83, 68, 90, 88, 67, 70));
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true){
				Sleep(30);
				if(acceptedButtons.contains(keyBla)){
					int RNGHelper=RNGesus(freeerSpaces.size());
					int tempX=PX;
					int tempY=PY;
					if(keyBla==81){
						PX-=1;
						PY-=1;
						fenceCheck();
					}
					else if(keyBla==87){
						PY-=1;
						fenceCheck();
					}
					else if(keyBla==69){
						PX+=1;
						PY-=1;
						fenceCheck();
					}
					else if(keyBla==65){
						PX-=1;
						fenceCheck();
					}
					else if(keyBla==83){
						PX=freeerSpaces.get(RNGHelper)[0];
						PY=freeerSpaces.get(RNGHelper)[1];
						fenceCheck();
					}
					else if(keyBla==68){
						PX+=1;
						fenceCheck();
					}
					else if(keyBla==90){
						PX-=1;
						PY+=1;
						fenceCheck();
					}
					else if(keyBla==88){
						PY+=1;
						fenceCheck();
					}
					else if(keyBla==67){
						PX+=1;
						PY+=1;
						fenceCheck();
					}
					if(PX==tempX&&PY==tempY){
						repaint();
						Sleep(1500);
						freeerSpaces.clear();
						for(int br4=0;br4<12;br4++){
							for(int br5=0;br5<12;br5++){
								if(Matrix[br4][br5]==null){
									int[] pos={br4,br5};
									freeerSpaces.add(pos);
								}
							}
						}
						
						moveMho();
						repaint();
					}
					else if(Matrix[PX][PY]==null){
						freeerSpaces.remove(arrayPosition);
						int[] newPPos={tempX, tempY};
						freeerSpaces.add(newPPos);
						arrayPosition=RNGHelper;
//						System.out.println(PX + ", " + PY);
						repaint();
//						Sleep(3000);
						freeerSpaces.clear();
						for(int br4=0;br4<12;br4++){
							for(int br5=0;br5<12;br5++){
								if(Matrix[br4][br5]==null){
									int[] pos={br4,br5};
									freeerSpaces.add(pos);
								}
							}
						}
						moveMho();
						repaint();
					}
					else if(Matrix[PX][PY] instanceof Fence){
						PX=tempX;
						PY=tempY;
					}
					else if(Matrix[PX][PY] instanceof Mho){
						freeerSpaces.remove(arrayPosition);
						int[] newPPos={tempX, tempY};
						freeerSpaces.add(newPPos);
						arrayPosition=RNGHelper;
//						System.out.println(PX + ", " + PY);
						gameOver=true;
						repaint();
						return;
					}
					Sleep(500);
				}
			}
		}
	};
	public static void Sleep(long ms){
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {

		}
	}
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
	static ArrayList<int[]> freeerSpaces= new ArrayList<int[]>();
	static Obstacles[][] Matrix = new Obstacles[12][12];
	static ArrayList<int[]> MhoPositions= new ArrayList<int[]>();
	static int[][]FencePositions;
	public static void Randomiser(){
		freeerSpaces=freeSpacefinder(freeerSpaces);
//		MhoPositions=new int[12][2];
		FencePositions=new int[20][2];
		for(int br=0;br<12;br++){
			int RNGHelper=RNGesus(freeerSpaces.size());
			MhoPositions.add(freeerSpaces.get(RNGHelper));
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
		arrayPosition=RNGHelper1;
		for(int br=0;br<12;br++){
//			System.out.println(MhoPositions[br][0]+", "+MhoPositions[br][1]);
			Matrix[MhoPositions.get(br)[0]][MhoPositions.get(br)[1]]=new Mho();
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
		HiVoltsMain canvasHiVolts = new HiVoltsMain();
		canvasHiVolts.setSize(1000,1000);
		frame.getContentPane().add(canvasHiVolts);
		frame.pack();
		frame.setVisible(true);
		frame.addKeyListener(canvasHiVolts);

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
	/**
	 * Paints all elements in the game
	 */
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
	/**
	 * Assigns fences
	 * @param g
	 */
	public static void outerFence(Graphics g){
		Fence outer = new Fence();
		for(int i = 0; i <= 11; i++){
			Matrix[i][0]=new Fence();
			Matrix[0][i]=new Fence();
			Matrix[i][11]=new Fence();
			Matrix[11][i]=new Fence();
		}
		
	}
	/**
	 * A grid to help visualize the spots
	 * @param g
	 */
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
	
	/**
	 * Calculates the position of the mhos. mho AI
	 * @param mhoX
	 * @param mhoY
	 * @return
	 */
	public static int[] MhoAlgorithm(int mhoX, int mhoY) {
		// This is the algorithm for the mho objects.
		//Use mho array : MhoPositions and FencePositions
		int xmod= mhoX - PX;
		int ymod = mhoY - PY; 

		if(PX == mhoX){
			if(PY > mhoY){
				mhoY++;
			}else{
				mhoY--;
			}


		}else if(PY == mhoY){
			if(PX > mhoX){
				mhoX++;
			}else{
				mhoX--;
			}


		}else{


			if(Math.abs(xmod) == Math.abs(ymod)){
				if( (xmod != Math.abs(xmod)) && (ymod != Math.abs(ymod)) ){
					mhoX++;
					mhoY++;
				}else if( (xmod == Math.abs(xmod)) && (ymod != Math.abs(ymod)) ){
					mhoX--;
					mhoY++;
				}else if( (xmod == Math.abs(xmod)) && (ymod == Math.abs(ymod)) ){
					mhoX--;
					mhoY--;
				}else if( (xmod != Math.abs(xmod)) && (ymod == Math.abs(ymod)) ){
					mhoX++;
					mhoY--;
				}

			
			}else if(Math.abs(xmod) > Math.abs(ymod)){
				if(xmod<0){
					mhoX++;
				}else{
					mhoX--;
				}
			}else if(Math.abs(ymod) > Math.abs(xmod)){
				if(ymod<0){
					mhoY++;
				}else{
					mhoY--;
				}
			}
			
			
			}
		int[] array = {mhoX, mhoY};

		return array;	


		}
	


	
	/**
	 * Moves the mhos to the correct position
	 */
	public static void moveMho(){
		for(int br1=0;br1<MhoPositions.size();br1++){
			int RNGHelper2=br1;
			int newX1=MhoPositions.get(RNGHelper2)[0];
			int newY1=MhoPositions.get(RNGHelper2)[1];
			int[] newXY=MhoAlgorithm(newX1, newY1);
			newX1=newXY[0];
			newY1=newXY[1];
			System.out.println(newX1 + ", " + newY1);
			if(newX1==PX&&newY1==PY){
				gameOver=true;
			}
			else if(Matrix[newX1][newY1]==null){
				int br=0;
				while(freeerSpaces.get(br)[0]!=newX1||freeerSpaces.get(br)[1]!=newY1){
					br++;
				}
				int[] oldMPos=MhoPositions.get(RNGHelper2);
				MhoPositions.set(RNGHelper2, freeerSpaces.remove(br));
				freeerSpaces.add(oldMPos);
				Matrix[newX1][newY1]=Matrix[oldMPos[0]][oldMPos[1]];
				Matrix[oldMPos[0]][oldMPos[1]]=null;
//			System.out.println(PX + ", " + PY);
			}
			else if(Matrix[newX1][newY1] instanceof Fence){
				freeerSpaces.add(MhoPositions.get(RNGHelper2));
				Matrix[MhoPositions.get(RNGHelper2)[0]][MhoPositions.get(RNGHelper2)[1]]=null;
				MhoPositions.remove(br1);
				br1--;
			}
		}
	}
	
	public BufferedImage imager(String filename){
		//Name of the file in workspace
		File image = new File(filename);
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
	 * Game over screen
	 * @param g
	 */
	public static void GameOver(Graphics g){
		Sleep(5000);
		g.clearRect(0, 0, 1000, 1000);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Ariel", Font.BOLD, 30));
		g.drawString("GAME OVER", 400, 400);
		Sleep(5000);
		System.exit(0);
	}
	static int keyBla;
	
	/**
	 * If all mhos are gone, this page is displayed
	 * @param g
	 */
	public static void Win(Graphics g){
		Sleep(5000);
		g.clearRect(0, 0, 1000, 1000);
		g.setColor(Color.blue);
		g.setFont(new Font("Ariel", Font.BOLD, 30));
		g.drawString("YOU WIN! CONGRADULATIONS!", 300, 300);
		Sleep(5000);
		System.exit(0);
	}
	
	public void fenceCheck(){
		//boolean trash = false;
		if(Matrix[PX][PY] instanceof Fence){
			Sleep(5000);
			Sleep(5000);
			System.exit(0);
		}
		System.out.println("FENCE CHECK INVOKED:  " + (Matrix[PX][PY] instanceof Fence));
	}
	
	/** Paint Method
	 * @param g - object of the graphics package
	 */
	public void paint(Graphics g) {
		this.g = g;
		g.setColor(Color.BLACK);
		this.addKeyListener(this);
		//paintGrid(g);
		outerFence(g);
		paintAll(g);
		g.setColor(Color.GREEN);
		//g.fillOval(getWidth()/12*PX, getHeight()/12*PY, getWidth()/12, getHeight()/12);
		
		g.drawImage(imager("player.png"), getWidth()/12*PX, getHeight()/12*PY, getWidth()/12, getHeight()/12, null);
//		System.out.println(PX+", "+PY);
		
		//fenceCheck();
		
		if(MhoPositions.size() == 0){
			Win(g);
		}
		
		if(gameOver){
			GameOver(g);
		}
		Sleep(100);
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
