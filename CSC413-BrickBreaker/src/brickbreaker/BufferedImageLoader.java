
package rainbowreef2;

/**
 *
 * @author Gabriel
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;


public class BufferedImageLoader {
   // private BufferedImage image;
    
    private BufferedImage image;
    
    public BufferedImage loadImage(String path){
        try{
            //simple bufferedImage loader
            image= ImageIO.read(getClass().getResource(path));
        }catch(IOException ex){
           ex.printStackTrace();
        }

        return image;
 
    }
    
    
}