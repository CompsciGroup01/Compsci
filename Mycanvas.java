import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;
import sun.audio.*;
import java.awt.Rectangle;

public class Mycanvas extends Canvas implements KeyListener,MouseListener {
   Image img = Toolkit.getDefaultToolkit().getImage("../javastuff/cp3.png");
   int x = 10;
   int y = 10;
   Image img1 = Toolkit.getDefaultToolkit().getImage("../javastuff/yoda.png");
   int xcord = 400;
   int ycord = 10;
   Rectangle rect = new Rectangle(200,200,100,100);

   public Mycanvas() {
      this.setSize(600,400);
      this.setFocusable(true);
      this.addKeyListener(this);
      this.addMouseListener(this);
  }

   public void mouseClicked(MouseEvent e) {
      x = e.getX();
      y = e.getY();
      this.repaint();
      playIt("../javastuff/boing.wav");
      }
   public void mouseEntered(MouseEvent e) {
      System.out.println(e);
      }  
   public void mouseExited(MouseEvent e) {
      System.out.println(e);
      }  
   public void mousePressed(MouseEvent e) {
      System.out.println(e);
      }  
   public void mouseReleased(MouseEvent e) {
      System.out.println(e);
      }  
   public void paint(Graphics g) {
      g.setColor(Color.ORANGE);
      g.fillOval(100,100,30,30);
      g.drawImage(img,x,y,100,100,this);
      g.drawRect((int)rect.getX(),(int)rect.getY(),(int)rect.getWidth(),(int)rect.getHeight());
      g.drawImage(img1,xcord,ycord,100,100,this);}

   public static void playIt(String Song) {
       try {
         InputStream in = new FileInputStream(Song);
         AudioStream as = new AudioStream(in);
         AudioPlayer.player.start(as);
       }catch (IOException e) {
         System.out.println("can not find file");
       }
   }

   @Override
   public void keyPressed(KeyEvent e) {
      if (rect.contains(x,y)) {
         playIt("../javastuff/girl.wav");
         x = 10;
         y = 10;
         this.repaint();
         return;
      }
      if (x > 600) {
         x = x - 60;
      }
      if (x < 0) {
         x = x +60;
      }
      if (y > 400) {
        y = y - 60;
      }
      if (y < 0) {
       y = y + 60;
      }

      if (e.getKeyCode() == 39) {
         x = x + 5;
      playIt("../javastuff/holycow.wav");
      }
      this.repaint();
      
      if (e.getKeyCode() == 37) {
         x = x - 5;
      playIt("../javastuff/jordan.wav");
      }
      this.repaint();

      if (e.getKeyCode() == 38) {
         y = y - 5;
      playIt("../javastuff/hello.wav");

      }
      this.repaint();

      if (e.getKeyCode() == 40) {
         y = y + 5;
      playIt("../javastuff/zero.wav");
      }
      this.repaint();
   }
   
   @Override
   public void keyReleased(KeyEvent e) {
      System.out.println("released");
   }
   @Override
   public void keyTyped(KeyEvent e) {
      System.out.println("typed");
      }
}

