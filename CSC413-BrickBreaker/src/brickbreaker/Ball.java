
package rainbowreef2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Gabriel
 */
public class Ball extends GameObject implements Observer{
    //Ball is a game object, inherits attributes of the general game object
    private int vx=3;
    private int vy=-3;
    boolean showBall;
    private int type;//brick type
    
    public int livesSet=3;
    
    private BufferedImage ball;
    //check graphic dimensions
    private int width,height;
    
    public Ball(BufferedImage img,int x, int y){
        super(img,x,y);
       this.x=x;
       this.y=y;
       this.showBall=true; 
       this.width=img.getWidth();
       this.height=img.getHeight(); 
    }
    
    
    //needed for collision
    //getters and setters
    public int getVX(){
        return vx;
    }
    public void setVX(int vx){
        this.vx=vx;
    }
    public int getVY(){
        return vy;
    }
    public void setVY(int vy){
        this.vy=vy;
    }
    
    public void setX(int a){
        this.x=a;
    }
    public void setY(int b){
        this.y=b;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    
    public int getLives(){
        return this.livesSet;
    }
    public void setLives(int l){
        this.livesSet=l;
    }
    
    public void setImg(BufferedImage img){
        this.ball=img;
    }

    //from observable
    @Override
    public void update(Observable o, Object arg) {   
                
        x +=vx;//making the ball go +x by default
        y +=vy;//making the ball also go -y by defualt
        checkBallBorder();
        
    }

    public void checkBallBorder(){
        
        if(x>=605 || x<0){
           this.setVX(this.getVX()*-1);           
        }
        if(y>=415){
            resetBall();
           //this.setVX((this.getVX()*-1));
           //^To test collisions
            this.setVY((this.getVY()*-1));            
            //lose a life
            this.livesSet--;
        }
        if(y<0){
            this.setVY(this.getVY()*-1);
        }//ball bounce off the ceiling 
        
    }
    
    public void resetBall(){
        //reset the ball next to paddle to avoid creating a ball inside a brick
        this.setX(320);
        this.setY(340);
    }

    public void render(Graphics g) {
        //draw the ball image
        g.drawImage(ball, x, y, null);
    }

}
