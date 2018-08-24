
package tankgame;

/**
 *
 * @author Gabriel
 */
import java.awt.*;

public interface Collidable {
    Rectangle getBounds();
    void handleCollision(Collidable with);
    boolean isCollidable();
}
