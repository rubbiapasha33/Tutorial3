
import java.time.Duration;
import javax.swing.JFrame;
 
public class SnakeGame {
	
	public SnakeGame() throws InterruptedException {
		JFrame snakegame = new JFrame();
        Game game = new Game();
        
        snakegame.add(game);
        snakegame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        snakegame.setTitle("Snake");
        snakegame.setResizable(false);
        snakegame.pack();
        snakegame.setLocationRelativeTo(null);
        snakegame.setVisible(true);     
        
        long startTime = System.currentTimeMillis();
        Thread.sleep(1000 * 4);
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);  
        System.out.format("Milli = %s, ( S_Start : %s, S_End : %s ) \n", duration, startTime, endTime );
        System.out.println("Human-Readable format : "+millisToShortDHMS( duration ) );
    }

	private String millisToShortDHMS(long duration) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) throws InterruptedException {
	
		new SnakeGame();

	}

}
