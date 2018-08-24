
package tankgame;

/**
 *
 * @author Gabriel
 */
import java.util.Observable;
import java.util.Observer;
import java.awt.event.KeyEvent;

public class TankGameEvents extends Observable {
    //here we use integers to determine what event is
    //happening and call the correct java class
    
    
    //again used from Wingman class example, triggers the changes with the given event
    int eventType;
    final int keyEvent=1;
    final int keyCollision=2;
    int objectCollisionD;
    //no collision damage
    Object event;
    
    public void setValue(KeyEvent e){
        eventType=keyEvent;
        event=e;
        setChanged();
        //trigger notification
        notifyObservers(this);
    }
    public void setValue(String msg){
        eventType=keyCollision;
        event=msg;
        setChanged();
        notifyObservers(this);
    }
    public int getType(){
        return this.eventType;
    }
    public Object getEvent(){
        return this.event;
    }
    
}
