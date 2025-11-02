package background;

import main.GamePanel;

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

    GamePanel gp;

    public Background(GamePanel gp)
    {
        this.gp = gp;

        try
        {
            Clouds = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Clouds.png")));
            Grass_Mountains = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Grass_Mountains.png")));
            Rock_Mountains = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Rock_Mountains.png")));
            Sky = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/background/Sky.png")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void moveImg(BufferedImage img)
    {

        int width = img.getWidth();
        int height = img.getHeight();


       for(int i = 0;i<height;i++)
       {
           int firstColor = img.getRGB(0,i);

           for(int j = 1;j<width;j++)
           {
               int secondColor = img.getRGB(j,i);
               img.setRGB(j - 1,i,secondColor);
           }
           img.setRGB(width-1,i,firstColor);
       }
    }

    int cout = 0;

    public void update()
    {
        if(cout == Integer.MAX_VALUE)
        {
            cout = 0;
        }
        cout++;
        moveImg(Sky);

        if(cout % 2 == 0)
        {
            moveImg(Clouds);
        }
        if(cout % 3 == 0)
        {
            moveImg(Rock_Mountains);
        }
        if(cout % 4 == 0)
        {
            moveImg(Grass_Mountains);
        }
    }

    public void draw(Graphics2D g2)
    {
        int diff = gp.windowHeight-gp.windowWidth;
        g2.drawImage(Sky,0,diff,gp.windowWidth,gp.windowWidth,null);
        g2.drawImage(Clouds,0,diff,gp.windowWidth,gp.windowWidth,null);
        g2.drawImage(Rock_Mountains,0,diff,gp.windowWidth,gp.windowWidth,null);
        g2.drawImage(Grass_Mountains,0,diff,gp.windowWidth,gp.windowWidth,null);
    }
}
