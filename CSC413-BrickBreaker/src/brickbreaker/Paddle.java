
package rainbowreef2;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComponent;


public class Paddle extends GameObject implements Observer{
   private int x;
 //  private int vx;
   private int score;
   
   //width and height of the paddle
   private int width,height;
   private BufferedImage paddleImg;
   private boolean LeftPressed;
   private boolean RightPressed;
   int paddleLives;
   private BufferedImage lives;

   
   public Paddle(BufferedImage paddle,int x  , int y){
       super(paddle,x,y);
       this.y=y;
       this.x=x;
      this.paddleLives=3;
       this.paddleImg=paddle;
       this.score=0;
       this.width=paddle.getWidth();
       this.height=paddle.getHeight();
       
       
       try {
           //  this.vx=vx;
           lives=ImageIO.read(Paddle.class.getResource("/res/katchSmall.jpg"));
       } catch (IOException ex) {
           System.out.print(ex.getMessage()+"Paddle Lives Image not found");
       }

   } 
   
   //getters and setters
   //setters and getters for y are not needed since its a constant
   public void setX(int a){
       this.x=a;
   }
   public int getX(){
       return this.x;
   }
 
   public int getScore(){
       return this.score;
   }
   
   public void addScore(int s){
       this.score +=s;
   }
     
   //Implement Later
   public void setLives(int b){
       this.paddleLives=b;
   }
   
   public int getLives(){
       return this.paddleLives;
   }
   
   public void reduceLives(int l){
       this.paddleLives -=l;
       //reduce lives per ball going past +Y border
   }
   

    //booleans for whether the paddle moves
   public void toggleLeftPressed(){
       this.LeftPressed=true;
   } 
   public void toggleRightPressed(){
       this.RightPressed=true;
   }
   public void unToggleLeftPressed(){
       this.LeftPressed=false;
   }
   public void unToggleRightPressed(){
       this.RightPressed=false;
   } 
   
   
   
   @Override
    public void update(Observable o, Object o1){
        //dynamic binding
        if(this.LeftPressed){
            this.moveLeft();
           // this.x +=3;
        }
        if(this.RightPressed){
            this.moveRight();
           // this.x -=3;
        }
     //   this.repaint();
    }    
    
    private void moveLeft(){
        x -=3;
       // System.out.println(x);
        checkBorder();
    }    
    private void moveRight(){
        x +=3;
        // System.out.println(x);
        checkBorder();
    }    
    private void checkBorder(){
        if(x<0){
            x=0;
        }
        if(x>=615){
            x=615;
        }       
    }    


   @Override
    public void render(Graphics g,ImageObserver obs) {
        g.drawImage(paddleImg,x,410,obs);
        int num=0;
        for(int i=0;i<paddleLives;i++){
            GameObject livesObj= new GameObject(this.lives,num+i*50,440);
            livesObj.render(g,obs);
            //live coutner
        }      
    }
    
}