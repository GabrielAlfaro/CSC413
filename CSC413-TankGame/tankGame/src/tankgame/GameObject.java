
package tankgame;

import java.awt.Image;
import java.awt.*;
import java.awt.image.ImageObserver;

/**
 *
 * @author Gabriel
 */

public class GameObject {
protected int x, y;
protected double angle;
protected Image ObjImg;
protected int width, height;
    public GameObject(Image img, int x, int y){
        //General game object that takes in an image and draws the object that called GameObject
        //wil draw the tanks and bullets
        this.ObjImg=img;
        this.x=x;
        this.y=y;
        this.angle=angle;
        this.width=ObjImg.getWidth(null);
        this.height=ObjImg.getHeight(null);
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
    public void setX(int c){
        this.x=c;
    }
    public void setY(int z){
        this.y=z;
    }

    
    public void draw(Graphics g, ImageObserver obs){
        g.drawImage(ObjImg, x,y, obs);
    }
    
    

}
