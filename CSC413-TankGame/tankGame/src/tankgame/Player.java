
package tankgame;

/**
 *
 * @author Gabriel
 */
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Player extends JComponent implements Observer{
    //attributes to a tank player given and set
    private int x;
    private int y;
    //coords
    int vx;
    int vy;
    //velocity
    private final int r=6;
    private int life;

    double angle;
    private BufferedImage tankImg;
    
    private int up, down, left, right, fire;
    private int pDamage=2;
    
    private boolean UpPressed;
    private boolean DownPressed;
    private boolean LeftPressed;
    private boolean RightPressed;
    private boolean ShootPressed;
    
    private boolean WPressed;
    private boolean SPressed;
    private boolean APressed;
    private boolean DPressed;
    private boolean EPressed;//shooting for player2
    
    private PlayerPlane myTankPlane;
    
    public Player(int life,int x, int y, double angle, int up,
            int down, int left, int right, int fire, BufferedImage img){
        this.x=x;
        this.y=y;
        this.angle=angle; 
        this.up=up;
        this.down=down;
        this.left=left;
        this.right=right;
        this.fire=fire;
        this.tankImg=img;
            try{
        tankImg=ImageIO.read(getClass().getClassLoader().getResource("\\Resources\\Tank.jpg"));
        

    }catch(IOException ex){
        System.out.println(ex.getMessage());      
    } 
     myTankPlane= new PlayerPlane((Image)tankImg, this.life,pDamage,0,0,0,up, down,left,right,
             fire );        
     
     myTankPlane= new PlayerPlane((Image)tankImg, this.life,pDamage,550,600,0,up,down,left,right,
            fire);
     
    }
    
    public PlayerPlane getPlane(){
        return this.myTankPlane;
    }
    
    public void setX(int x){
        this.x=x;
    }
    public void setY(int y){
        this.y=y;
    }
    public void setVX(int vx){
        this.vx=vx;
    }
    public void setVY(int vy){
        this.vy=vy;
    }
    public void setAngle(double angle){
        this.angle=angle;     
    }
    public void setImg(BufferedImage i){
        this.tankImg=i;
    }


    public boolean isAlive(){
        return !myTankPlane.getBoom();
    }
    
    
    
    //if control is pressed 
    public void toggleUpPressed(){
        this.UpPressed=true;
    }
    public void toggleDownPressed(){
        this.DownPressed=true;
    }
    public void toggleLeftPressed(){
        this.LeftPressed=true;
    }
    public void toggleRightPressed(){
        this.RightPressed=true;
    }
    public void toggleShootPressed(){
        this.ShootPressed=true;
    }
    //Controls for WASD
    public void toggleWPressed(){
        this.WPressed=true;
    }
    public void toggleSPressed(){
        this.SPressed=true;
    }
    public void toggleAPressed(){
        this.APressed=true;
    }
    public void toggleDPressed(){
        this.DPressed=true;
    }
    public void toggleEPressed(){
        this.EPressed=true;
    }
    //if control is not pressed 
    
    public void unToggleUpPressed(){
        this.UpPressed=false;
    }
    public void unToggleDownPressed(){
        this.DownPressed=false;
    }        
    public void unToggleLeftPressed(){
        this.LeftPressed=false;
    }
    public void unToggleRightPressed(){
        this.RightPressed=false;
    }
    public void unToggleShootPressed(){
        this.ShootPressed=false;
    }
    public void UnToggleWPressed(){//up
        this.WPressed=false;
    }
    public void UnToggleSPressed(){//down
        this.DPressed=false;
    }    
    public void UnToggleAPressed(){//left
        this.APressed=false;
    }    
    public void UnToggleDPressed(){//right
        this.DPressed=false;
    }    
    public void unToggleEPressed(){
        this.EPressed=false;
    }
    
    
    
    
    @Override
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        AffineTransform rotation = AffineTransform.getTranslateInstance(x, y);
    
        
        rotation.rotate(Math.toRadians(angle), tankImg.getWidth() / 2, tankImg.getHeight() / 2);

        
        Graphics2D graphic2D = (Graphics2D) g;
        graphic2D.drawImage(tankImg, rotation, null);
        
        System.out.println(this.toString());
    }    
    
    
    
public void update(Observable o, Object o1){
    if(this.UpPressed){
        this.moveForwards();
    }
    if(this.DownPressed){
        this.moveBackwards();
    }
    if(this.LeftPressed){
        this.rotateLeft();
    }
    if(this.RightPressed){
        this.rotateRight();
    }
    if(this.ShootPressed){
       this.shootBullet();
       //--------------------
    }
    if(this.WPressed){//if forward
        this.moveForwards();
    }
    if(this.SPressed){//if down
        this.moveBackwards();
    }
    if(this.APressed){//if left
        this.rotateLeft();
    }
    if(this.DPressed){//if right
        this.rotateRight();
    }
    if(this.EPressed){//if tank2 fired
        this.shootBullet();
    }
    
    this.repaint();
}
    

    private void rotateLeft(){
        this.angle -=3;
    }
    private void rotateRight(){
        this.angle +=3;
    }
////////////////////////////////    
    private void moveBackwards(){
        vx=(int)Math.round(r*Math.cos(Math.toRadians(angle)));
        vy=(int)Math.round(r*Math.sin(Math.toRadians(angle)));
        x -=vx;
        y -=vy;
        checkBorder();
    }
    private void moveForwards(){
       vx=(int)Math.round(r*Math.cos(Math.toRadians(angle)));
       vy=(int)Math.round(r*Math.sin(Math.toRadians(angle)));  
       x +=vx;
       y +=vy;
       checkBorder();
    }
    private void shootBullet(){
        Bullet b;
     //   b= new Bullet();
     //create a new bullet and pass through the coords
    }
    private void checkBorder(){
        if(x<0){x=0;}
        if(x>=740){x=740;}
        if(y<0){y=0;}
        if(y>=720){y=720;}
    }
    

    
    
}
