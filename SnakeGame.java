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
     
    }
    public static void main(String[] args) throws InterruptedException {
                long startTime = System.currentTimeMillis();
                new SnakeGame();
                long endTime = System.currentTimeMillis();
                long duration = (endTime - startTime);      
                System.out.printf("Game Duration: %d", + duration);
    }

}
