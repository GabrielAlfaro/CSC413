
package rainbowreef2;

/**
 *
 * @author Gabriel
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;


public class PaddleControl extends Observable implements KeyListener {

    private Paddle p1;
    private final int left;
    private final int right;
    
    
    public PaddleControl(Paddle p1, int left, int right){
        this.left=left;
        this.right=right;
        this.p1=p1;
    }
    
    
    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       int keyPressed = e.getKeyCode();
       if(keyPressed==left){
           this.p1.toggleLeftPressed();
       //    System.out.println("Move left");
           
       }
       if(keyPressed==right){
           this.p1.toggleRightPressed();
         // System.out.println("Move right");
       }
     
    }

    @Override
    public void keyReleased(KeyEvent kr) {
        int keyReleased=kr.getKeyCode();
        if(keyReleased==left){
            this.p1.unToggleLeftPressed();
        }
        if(keyReleased==right){
            this.p1.unToggleRightPressed();
        }
        
    }
    
  
    
}