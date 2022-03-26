import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
 
import javax.swing.JPanel;
 
public class Game extends JPanel implements Runnable, KeyListener {
 
    private static final long serialVersionUID = 6L;
 
    public static final int X = 420, Y = 420;

	private static final long FRAME_TIME = 0;
    
    private Thread thread;
    private boolean running = false;
 
    private SnakeBody sb;
    private ArrayList<SnakeBody> snake;
 
    private Apple apple;
    private ArrayList<Apple> apples;
    
    private Random r;
    
    private int axisX = 10, axisY = 10;
    private int size = 8;
 
    private boolean  up,down,right,left;
    
    private int moves = 0;

	private Component board;

	private Component side;



	public Game() {
        setFocusable(true);
        
        addKeyListener(this);
        setPreferredSize(new Dimension(X, Y));
 
        r = new Random();
        
        snake = new ArrayList<SnakeBody>();
        apples = new ArrayList<Apple>();
        
        start();
    }
 
    
	public void Game1() throws InterruptedException  {
		this.r = new Random();
		
		new LinkedList<>();
		while(true) {
			long start = System.nanoTime();
			
			board = null;
			board.repaint();
			side = null;
			side.repaint();
			long delta = (System.nanoTime() - start) / 1000000L;
			if(delta < FRAME_TIME) {
				try {
					Thread.sleep(FRAME_TIME - delta);
				} catch(Exception e) {
					e.printStackTrace();
				}
				long end = System.nanoTime();
				System.out.println("Took "+(end - start) + " ns"); 
			}
		}
	}
    public void move() {
        if (snake.size() == 0) { 
        }
        
        if(apples.size() == 0) {
            int axisX = r.nextInt(40);
            int axisY = r.nextInt(40) ;
           
            apple = new Apple(axisX, axisY, 10);
            apples.add(apple);
        }
        
        for(int i = 0; i < apples.size(); i++) {
            if(axisX == apples.get(i).getaxisX() && axisY == apples.get(i).getaxisY()) 
            {
                size++;
                apples.remove(i);
                i++;
            }
        }
        
        for(int i =0; i < snake.size(); i++) {
            if(axisX == snake.get(i).getaxisX() && axisY == snake.get(i).getaxisY())
            {
                if(i != snake.size() - 1) {
                    stop();
                }
            }
        }
        if(axisX < 0 || axisX > 40 || axisY < 0 || axisY > 40) {
            stop();
        }
        
        
        moves++;
        
        if(moves > 900000) {
            if(right) axisX++;
            if(left) axisX--;
            if(up) axisY--;
            if(down) axisY++;
            
            moves = 0;
            
            sb = new SnakeBody(axisX, axisY, 10);
            snake.add(sb);
            
            if(snake.size() > size) {
                snake.remove(0);
            }
        }
    }
 
    public void paint(Graphics g) {
        g.clearRect(0, 0, X, Y);
        g.setColor(Color.PINK);
        g.fillRect(0, 0, X, Y);
        
        g.setColor(Color.BLUE);
        for (int i = 0; i < X / 10; i++) {
            g.drawLine(i * 10, 0, i * 10, Y);
        }
        for (int i = 0; i < Y / 10; i++) {
            g.drawLine(0, i * 10, X, i * 10);
        }
        for (int i = 0; i < snake.size(); i++) {
            snake.get(i).draw(g);
        }
        for(int i = 0; i < apples.size(); i++) {
            apples.get(i).draw(g);
        }
 
    }
 
    public void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }
 
    public void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
    }
 
  
	public void run() {
		
		while (running) {
		move();
        repaint();
		}
}
   
   // Problem Slicing 2 
    @Override
	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		
		if(k == KeyEvent.VK_UP) {up = true;
		left = false;
        right = false;
        }
        
		if(k == KeyEvent.VK_DOWN) {down = true;
		left = false;
        right = false;
		}
		if(k == KeyEvent.VK_LEFT) {left = true;
		up = false;
        down = false;
		}
		if(k == KeyEvent.VK_RIGHT) {right = true;
		up = false;
        down = false;
		}
    }
    
        	
    @Override
    public void keyReleased(KeyEvent arg0) {    
    }
    public void keyTyped(KeyEvent arg0) {   
    }  
}
