
package tankgame;

/**
 *
 * @author Gabriel
 */
import java.awt.*;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.util.Observer;
import java.util.Observable;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class PlayerPlane extends GameObject implements Observer {
//object that is actually effected
    private int lifePoints, TotalLives,up, down, left, right;
//    private PlayerPlane p1, p2;
    private int x,y,fire, damage;
    private int vx, vy;
    private double angle;
    private Image planeImg;
    //^The image of the player, aka the tank
    private int playerDamage=2;
    private final int r=6;
    private boolean boom;    
    private ArrayList<Bullet> ammo;
    private Image [] healthBars, healthImg;
    private GameObject healthBar;
    private BufferedImage bulletImg;
    private BufferedImage lifeImg;
    
    public PlayerPlane( Image img, int life,int damage, int x, int y, int angle,
                int up, int down, int left, int right, int fire){
        super(img,x,y);
        lifePoints=20;
        this.x=x;
        this.y=y;
        this.angle=angle;
        this.fire=fire;
        this.damage=damage;
        this.up=up;
        this.down=down;
        this.right=right;
        this.left=left;
        this.boom=false;
        this.ammo=new ArrayList<>();
        this.healthBars=new Image[4];
        this.TotalLives=life;
    
                try{
            bulletImg = ImageIO.read(PlayerPlane.class.getResource("/Resources/bulletb.png"));
            
            healthBars[0] = ImageIO.read(PlayerPlane.class.getResource("/Resources/health.png"));
            healthBars[1] = ImageIO.read(PlayerPlane.class.getResource("/Resources/health1.png"));
            healthBars[2] = ImageIO.read(PlayerPlane.class.getResource("/Resources/health2.png"));
            healthBars[3] = ImageIO.read(PlayerPlane.class.getResource("/Resources/health3.png"));
            lifeImg = ImageIO.read(PlayerPlane.class.getResource("/Resources/life.png"));
        }
        catch (Exception e) {
            System.out.print(e.getMessage() + "Player plane: no resources are found");
        }
   
    }
    public void setVX(){
        this.vx=0;
    }
    public void setVY(){
        this.vy=0;
    }
    
    public int getVX(){
        return this.vx;
    }
    public int getVY(){
        return this.vy;
    }
    
    public int getDamage(){
        return this.damage;
    }
/*    public int getPlayerID(){
        return this.playerID;
    }*/
    public ArrayList<Bullet> getBulletList(){
        return this.ammo;
    }


    public boolean getBoom(){
        return this.boom;
    }
    public void reduceHealth(int d){
        if(lifePoints<d)
            this.isDied();
        this.lifePoints -=d;    
        
    }
    public void isDied(){
        
        
        
        
        if(this.TotalLives>1){
            TotalLives --;
            //Spawn a new One
            this.lifePoints=20;
            this.x=0;
            this.y=0;
        }else{
           endGame();            
        }
   
        
    }
   
    
    
    
    //Followed Aiirstrike/Wingman game to implement the healthBar of the tanks
    @Override
    public void draw(Graphics g, ImageObserver obs){
        if(!boom){
            g.drawImage(bulletImg,x,y,obs);
            //check if it only draws a bullet
        if(this.lifePoints>=20){
            healthBar=new GameObject(healthBars[0],x,y+height);
            healthBar.draw(g, obs);
        }    
        if(this.lifePoints<20 && this.lifePoints>=16){    
            healthBar = new GameObject(healthBars[1],x,y+height);
            healthBar.draw(g,obs);
        }
        if(this.lifePoints<16 && this.lifePoints>=10){
            healthBar = new GameObject(healthBars[2],x,y+height);
            healthBar.draw(g,obs);
            }
        if(this.lifePoints<10){
            healthBar = new GameObject(healthBars[0],x,y+height);
            healthBar.draw(g,obs);
        }

        
        }
    }
    private void fire(){
        Bullet playerBullet = new Bullet(bulletImg, x+getX()/2,y+getY()/2,0,0 ,0);
        ammo.add(playerBullet);
        
 
    }
    
    public void endGame(){
        //need to implement when either tank has zero lives
        //
    }
    
    
    public void update(Observable obj, Object arg){
        TankGameEvents ge=(TankGameEvents) arg;
        if(ge.eventType==1){
            KeyEvent e = (KeyEvent) ge.event;
            int keyCode=e.getKeyCode();
            if(keyCode==up){
                vx = (int) Math.round(r * Math.cos(Math.toRadians(angle)));
                vy = (int) Math.round(r * Math.sin(Math.toRadians(angle)));
                x -= vx;
                y -= vy;
                checkBorder();
            }else if(keyCode==down){
                vx = (int) Math.round(r * Math.cos(Math.toRadians(angle)));
                vy = (int) Math.round(r * Math.sin(Math.toRadians(angle)));
                x -= vx;
                y -= vy;
                checkBorder();
            }else if(keyCode==right){
                    this.angle += 3;
            }else if(keyCode==left){
                    this.angle -=3;     
            }else if(keyCode==fire){
                fire();
            }   
        }else if(ge.eventType==2){
            String msg=(String)ge.event;
            String [] msgArray = new String[2];
            StringTokenizer st= new StringTokenizer(msg);
            int i=0;
            while(st.hasMoreTokens()){
                msgArray[i]=st.nextToken();
                i++;
            }
            if(msgArray[0].equals("Collision")){
                int y= Integer.parseInt(msgArray[1]);
                this.reduceHealth(y);
            }
        }
        
    }

    private void checkBorder(){
                if (x < 0) {
            x = 0;
        }
        if (x >= 740) {
            x = 740;
        }
        if (y < 0) {
            y = 0;
        }
        if (y >= 530) {
            y = 530;
        }
    }
    
    
 
}
