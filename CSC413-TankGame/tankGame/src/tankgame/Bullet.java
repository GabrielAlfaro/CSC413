
package tankgame;

/**
 *
 * @author Gabriel
 */
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Observable;
public class Bullet extends GameObject{
    //check extension

    boolean visible;
    public int x,y;
    private int vx, vy;
    //create the trajectory of the bullet
    private double angle;
    private int bulletCap=30;
    private int bulletSpeed=2;
    final int r=6;

    //HardCoded Already in TankGameWorld
    //will be taken as a paremeter here
    private int damage=2;
    //DO I need to pass through damage or keep it as a local variable
    private Image img;
    
    public Bullet(Image img, int x, int y, int vx, int vy, int angle){
    super(img, x,y);
    //calling Game Object to draw bullet
    
       this.x=x;
        this.y=y;
        this.vx=vx;
        this.vy=vy;
        this.angle=angle;
        //this.img=img;
        this.visible=true;
        this.img=img;
        
    }
    
    public int getDamage(){
        return this.damage;
    }
    public boolean getShow(){
        return this.visible;
    }
    public void setShow(boolean s){
        this.visible=s;
    }
        
    public void update(int x, int y, double angle){
        vx=(int) Math.round(r*Math.cos(Math.toRadians(angle)));
        vy=(int) Math.round(r*Math.sin(Math.toRadians(angle))); 
        x +=vx;
        y +=vy;
        //updating the bullet to only move forward
        
        }
    
    @Override
    public void draw(Graphics g, ImageObserver obs){
        
        if(visible)
        g.drawImage(img, x, y, null);
        //Image, int, int, observer
    }
    



}