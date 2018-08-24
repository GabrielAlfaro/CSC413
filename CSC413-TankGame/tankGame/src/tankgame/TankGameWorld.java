
package tankgame;

/**
 *
 * @author Gabriel
 */
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.KeyEvent;


public class TankGameWorld  extends JFrame implements Runnable {
   /*
    I tried following the structure of the Wingman example game 
    and based the majority of my function calls on Wingman
    Project doesn't run.
    
    
    */
    
    
    
    Graphics2D g2;
    private BufferedImageLoader loader;
    private BufferedImage bimg;
    
    private Thread thread;
    public BufferedImage playerImg, playerImg2, powerUp, bullets, gameBackground;
    
    
    Player player1, player2;
    
    PlayerControl p1c, p2c;
    int bulletDamage=2;
   
    public BufferedImage bullet;
    public BufferedImage background;
    BufferedImage UnBwalls;
    BufferedImage Bwalls;
    final int playerPlane=10;
    final int bulletD=2;
    
    static int scrWidth=740;
    static int scrHeight=540;
    static int worldWidth=1920;
    static int worldHeight=1440;
    CollisionDetector CD;
    JFrame frame;
    TankGameEvents ge1, ge2;
 //   private BufferedImage bulletBill;
    static ArrayList<Bullet> ammo = new ArrayList<Bullet>(10000);
    //private final TankGameEvents tge;
    
    public void init(){
        setFocusable(true);
        setBackground(Color.white);
    try{
        playerImg=ImageIO.read(getClass().getClassLoader().getResource("\\Resources\\Tank.jpg"));
        playerImg2=ImageIO.read(getClass().getClassLoader().getResource("\\Resources\\Tank.jpg"));
        gameBackground=ImageIO.read(getClass().getClassLoader().getResource("\\Resources\\GBackground.png"));
    }catch(IOException ex){
        System.out.println(ex.getMessage());
    }          
     player1 = new Player(3,0,0,0,KeyEvent.VK_UP,KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,KeyEvent.VK_RIGHT,KeyEvent.VK_ENTER,  playerImg);
     player2 = new Player(3,1000,1200,0, KeyEvent.VK_W, KeyEvent.VK_S, KeyEvent.VK_A, KeyEvent.VK_D, KeyEvent.VK_SPACE,  playerImg2);
     //Two Player objects being initialized and created

  
    if(player1==null){
        System.out.println("Player 1 is N/A");
    }
    if(player2==null){
        System.out.println("Player 2 is N/A");
    }
 
     ge1 = new TankGameEvents();
     ge2= new TankGameEvents();
     
     
     ge1.addObserver(player1.getPlane());
     ge2.addObserver(player2.getPlane());
     PlayerControl key1 = new PlayerControl(ge1);
     PlayerControl key2 = new PlayerControl(ge2);
     
     addKeyListener(key1);
     addKeyListener(key2);
     
     CD = new CollisionDetector(ge1, ge2);
     

 
 }
    public void drawBackgroundImage(){
        //draw background with splitscreen and minimap
   
    }
    
    public void drawGame(){
        g2.setColor(Color.white);
        
       
        
        if(!player1.isAlive()){
            g2.drawString("Player2 Wins!", TOP_ALIGNMENT, TOP_ALIGNMENT);
        } else if(!player2.isAlive()){
            g2.drawString("Player 1 Wins!", TOP_ALIGNMENT, TOP_ALIGNMENT);
        }
        else{
            
            CD.playerVSplayer(player1, player2);
            CD.pBulletVSpPlane(player1, player2);
            //Did not fully implement Collision
            
            
            
            
                        for (int i = 0; i < player1.getPlane().getBulletList().size(); i++) {
                if ((player1.getPlane().getBulletList().get(i)).getShow()) {
                    player1.getPlane().getBulletList().get(i).update(player1.getX(), player1.getY(),player1.angle);
                } else {
                    player1.getPlane().getBulletList().remove(i);
                }
            }
            //update player2's bullet list
            for (int i = 0; i < player2.getPlane().getBulletList().size(); i++) {
                if ((player2.getPlane().getBulletList().get(i)).getShow()) {
                    player2.getPlane().getBulletList().get(i).update(player2.getWidth(), player2.getHeight(),player2.angle);
                } else {
                    player2.getPlane().getBulletList().remove(i);
                }
            }
            
        }
        
    }

    @Override
    public void paint(Graphics g){
        if(bimg==null){
            Dimension windowSize=getSize();
            bimg=(BufferedImage) createImage(windowSize.width,
            windowSize.width);
            g2=bimg.createGraphics();
        }

        g.drawImage(bimg, 0,0, this);      
    }
    
    
    public void start(){
        System.out.println();
        thread=new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        //setting this main thread to the minimal priority of execution
        thread.start();
    }
    
    @Override
    public void run(){
        Thread me= Thread.currentThread();
        while(thread==me){
            repaint();
            try{
                thread.sleep(1000/144);
            }catch(InterruptedException e){
                break;
            }
            
        }
    }
    
    public static void main(String[] args) {
       // Thread x;
       final TankGameWorld tgw = new TankGameWorld();
        tgw.init();
        //Instantiate and initialize the Tank Game
        JFrame f= new JFrame("Tank Game");
     /*
        f.addWindowListener(new WindowAdapter(){       
    });
*/
        /*
        Getting an error for adding a window to a container
        Tried to remove f and extend other methods but it still doesn't work
        */
        
        f.getContentPane().add("Center", tgw);

        f.pack();
        f.setSize(new Dimension(scrWidth, scrHeight));
        //set the size of the scren window in game
        f.setVisible(true);
        f.setResizable(false);
        tgw.start();
        
    }

       
    
}
