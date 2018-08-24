
package rainbowreef2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Gabriel
 */
public class Brick extends GameObject implements Observer{
    
private int x,y;
private BufferedImage brickImg;    
private int type;

private int width,height;
    public Brick(BufferedImage img, int x, int y, int brickType) {
        super(img, x, y);
        this.width=img.getWidth();
        this.height=img.getHeight();
        this.type=brickType;
        this.brickImg=img;
        this.x=x;
        this.y=y;
    }
    //0=brick[0]/breakable
    //1=brick[1]/breakable
    //2=enemy/breakable
    //3=bricklife/breakable
    //4=brickDouble/breakable
    //5=wall/unbreakable
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

    public int getType(){
    //determine whether a brick is breakable or not    
        return type;
    }

    public void render(Graphics g){
        g.drawImage(brickImg,x,y,null);   
    }
    
    @Override
    public void update(Observable o, Object arg) {
        //Don't know what to add to update for brick
        //collision already called
    }

}