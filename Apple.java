

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
    
    public Apple() throws InterruptedException {
    	Instant start = Instant.now();
    	Thread.sleep(5000);
    	Instant end = Instant.now();
    	
    	System.out.println(Duration.between(start, end));
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

}