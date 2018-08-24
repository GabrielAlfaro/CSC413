
package tankgame;

/**
 *
 * @author Gabriel
 */
import java.awt.Rectangle;
import java.util.ArrayList;


public class CollisionDetector {
    TankGameEvents gamevent1, gamevent2;
    
    public CollisionDetector(TankGameEvents tge1, TankGameEvents tge2){
        this.gamevent1=tge1;
        this.gamevent2=tge2;
    }
    public void playerVSplayer(Player p1, Player p2){
        PlayerPlane pp1=p1.getPlane();
        PlayerPlane pp2=p2.getPlane();
        Rectangle p1box= new Rectangle(p1.getX(),p1.getY());
        Rectangle p2box = new Rectangle(p2.getX(), p2.getY());  
        if(p1box.intersects(p2box)){
            p1.setVX((int) (-0.5*p1.vx));
            p2.setVX((int)(-0.5*p2.vx));
            
            p1.setVY((int)(-0.5*p1.vy));
            p1.setVY((int)(-0.5*p2.vy));
            //Created collision with players
        }
    }
    public void pBulletVSpPlane(Player player1, Player player2){
        Bullet bullet;
        ArrayList<Bullet> player1Bullet= player1.getPlane().getBulletList();
        for(int i=0;i<player1Bullet.size();i++){
            bullet=player1Bullet.get(i);
            Rectangle bulletHitBox= new Rectangle(bullet.getX(),bullet.getY());
            //check for collision then call the getDamage() method for the player plane 
            //and pass through the damage
        }
       
}    
    
    public void playerVSObstacle(Player player, Object obj){
        //take in a wall object and player and check for collision
        //if collided do the same with playerVSplayer and invert the vx and vy by a little
        
    }
              
        }


    
    
    
    

