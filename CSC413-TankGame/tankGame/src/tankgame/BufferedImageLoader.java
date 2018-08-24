/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tankgame;

/**
 *
 * @author Gabriel
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
public class BufferedImageLoader {
        private BufferedImage image;

    public BufferedImage loadImage(String path) {

        try {
            image = ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return image;
    }
      
}