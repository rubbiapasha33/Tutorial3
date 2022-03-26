
import java.awt.Color;
import java.awt.Graphics;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;

public class SnakeBody {
   
    private int axisX, axisY, x, y;
    
    private boolean running = false;
 
    private SnakeBody sb;
    private ArrayList<SnakeBody> snake;
 
    private int size = 8;
 
    private boolean right = true, left = false, up = false, down =false;
    
    private int moves = 0;
   
    public SnakeBody() throws InterruptedException {
    	Instant start = Instant.now();
    	Thread.sleep(5000);
    	Instant end = Instant.now();
    	System.out.println(Duration.between(start, end));
    }
    
    public SnakeBody(int axisX, int axisY, int squareSize) {
        this.axisX = axisX;
        this.axisY = axisY;
        x = y = squareSize;
    }
    
    	public void run() throws InterruptedException {
        	Instant start = Instant.now();
        	Thread.sleep(5000);
        	Instant end = Instant.now();
        	sb.run();
        	System.out.println(Duration.between(start, end));
    		
    		while (running) {
    		move();
            repaint();
    		}
    }  
    
    private void repaint() {
			
			
		}
	public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(axisX * x, axisY * y, x, y);
    }
    public int getaxisX1() {
        return axisX;
    }
    public void setaxisX(int axisX) {
        this.axisX = axisX;
    }
    public int getaxisY() {
        return axisY;
    }
    public void setaxisY(int axisY) {
        this.axisY = axisY;
    }
	public int getaxisX() {
		return 0;
	}
	
	public void move() {
        if (snake.size() == 0) {
            sb = new SnakeBody(axisX, axisY, 10);
            snake.add(sb);
        }
    
        for(int i =0; i < snake.size(); i++) {
            if(axisX == snake.get(i).getaxisX() && 
                    axisY == snake.get(i).getaxisY()) {
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
	private void stop() {		
	}
 
}