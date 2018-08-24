
package tankgame;

/**
 *
 * @author Gabriel
 */

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.image.BufferedImage;

public class PlayerControl extends KeyAdapter {
    private TankGameEvents TankEvents;
    //general player controls to generalize button pressing
    public PlayerControl(){
        
    }

    public PlayerControl(TankGameEvents ge){
        this.TankEvents=ge;
    }

    @Override
    public void keyPressed(KeyEvent e){
        TankEvents.setValue(e);
    }
       
}
