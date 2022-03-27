



import java.awt.Color;
import java.awt.Graphics;
import java.time.Duration;
import java.time.Instant;
 
public class Apple {
    
	 private int axisX, axisY, x, y;
    
    public Apple(int axisX, int axisY, int squareSize) {
        this.axisX = axisX;
        this.axisY = axisY;
        x= y = squareSize;
    }  
    
	public void draw(Graphics g) {
    	g.setColor(Color.RED);
    	g.fillRect(axisX * x , axisY * y, x, y);
    }
   

    public int getaxisX() {
    	return (axisX);
    }
    
    public int getaxisY() {
    	return axisY;
    }



public static void main(String[] args) throws InterruptedException {
    long startTime = System.currentTimeMillis();
    new SnakeGame();
    long endTime = System.currentTimeMillis();
    long duration = (endTime - startTime);      
    System.out.printf("Game Duration: %d", + duration);
}
}
