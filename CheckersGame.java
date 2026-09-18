import javax.swing.JFrame;
import javax.swing.JLabel;

public class CheckersGame {  
    


    public static void main(String[] args) {          

          JFrame frame = new JFrame();
          JLabel label = new JLabel("Welcome to Checkers!");  

           
          frame.setTitle("Checkers");
          frame.setSize(800,800);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.setVisible(true);
          frame.add(label);

          System.out.println("Game is over!");
    }
          
    }


