package background;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Background {

    BufferedImage Clouds;
    BufferedImage Grass_Mountains;
    BufferedImage Rock_Mountains;
    BufferedImage Sky;

    public Background()
    {
        try
        {
            Clouds = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Clouds.png")));
            Grass_Mountains = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Grass_Mountains.png")));
            Rock_Mountains = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Rock_Mountains.png")));
            Sky = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Sky.png")));
        } catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
