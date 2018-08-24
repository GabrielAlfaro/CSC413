/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rainbowreef2;

/**
 *
 * @author Gabriel
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;

public class GameObject {
    //Paddle and Ball will be super() passed
    //through and drawn
    protected int x,y;
    protected BufferedImage bimg;
   // protected int vx,vy;
    protected int width,height;
    protected int vx,vy;
    
    public GameObject(BufferedImage img,int x, int y){
        this.x=x;
        this.y=y;
        this.bimg=img;
        this.width=img.getWidth();
        this.height=img.getHeight();
    }
    
    public int getX(){
        return this.x;
    }
    
    public int getY(){
        return this.y;
    }
    
    public void setX(int a){
        this.x=a;
    }
    
    public void setY(int b){
        this.y=b;
    }
        public int getWidth(){
        return this.width;
    }
    
    public int getVX(){
        return this.vx;
    }    
    public int getVY(){
        return this.vy;
    }    
    public void setVX(int q){
        this.vx=q;
    }
    public void setVY(int w){
        this.vy=w;
    }    
        
    public int getHeight(){
        return this.height;
    }
    public BufferedImage getImg(){
        return this.bimg;
    }

    //Used same format as Airstrike game
    //Passing in paddle and ball and enemys as objects
    public void render(Graphics g,ImageObserver obs){
        g.drawImage(bimg, x, y, obs);
    }
    
}
