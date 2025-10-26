package objects;

import keyBusinesses.KeyHandler;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.util.Objects;

public class Bird {

    GamePanel gp;

    public BufferedImage birdImage;
    public int birdPosX;
    public int birdPosY;

    protected final int birdHeight = 70;
    protected final int birdWidth = 70;

    public Bird(GamePanel gp)
    {
        this.gp = gp;

        birdPosX = gp.windowWidth/2 - birdWidth/2;
        birdPosY = gp.windowHeight/2 - birdHeight/2;
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

    int state = 0;

    public void update(KeyHandler keyH)
    {
        if(keyH.isUp)
        {
            for(int i = 0;i<10;i++)
            {
                birdPosY--;
            }
            state++;

                System.out.println("a");
                for(int i = 0;i<10;i++)
                {
                    birdPosY++;
                }
        }
    }

    public void drawBird(Graphics2D g2)
    {
        g2.drawImage(birdImage,birdPosX,birdPosY,birdWidth,birdHeight,null);
    }
}
