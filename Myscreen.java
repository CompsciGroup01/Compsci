import javax.swing.JFrame;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import sun.audio.*;
// declare a public class, give it some functionality from another class - JFrame
// extends allows you to inherit from existing class
public class Myscreen extends JFrame {

   // Constructor method - runs first when class template is instantiated
   public Myscreen() {
      this.setSize(600,400);
      this.setDefaultCloseOperation(EXIT_ON_CLOSE);
      this.setVisible(true);
      this.setTitle("Poopy Pants");

   }
   
   public static void main(String[] args){

      Myscreen screen = new Myscreen();
      Mycanvas canvas = new Mycanvas();
      screen.getContentPane().add(canvas);
      playIt();
   }

   public static void playIt() {
      try {
         InputStream in = new FileInputStream("../javastuff/fresh.wav");
         AudioStream as = new AudioStream(in);
         AudioPlayer.player.start(as);
      } catch (IOException e) {
         System.out.println("can not find file");
         }
     }
      
  }

