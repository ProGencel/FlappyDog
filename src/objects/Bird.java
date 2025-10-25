package objects;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Objects;

public class Bird {

    public BufferedImage birdImage;

    public Bird()
    {
        getBirdImage();
    }

    public void getBirdImage() {
        try
        {
            birdImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/bird/bird.png")));
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
