package objects;

import keyBusinesses.KeyHandler;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Pipes {

    public int pipeLocX;
    public int pipeLocY;

    BufferedImage pipeImage;
    KeyHandler keyH = new KeyHandler();

    private int pipeWidth;
    private int pipeHeight;

    public Pipes(GamePanel gp,Bird bird,String direction)
    {

        getPipeImage(direction);
        pipeWidth = bird.birdWidth*2;
        pipeHeight = gp.windowHeight/2 - bird.birdHeight - 25;
        pipeLocX = gp.windowWidth-pipeWidth;
        pipeLocY = gp.windowHeight-pipeHeight;

    }

    public void update()
    {
        if(keyH.isA)
        {
            System.out.println("a");
        }
        if(keyH.isD)
        {
            System.out.println("d");
        }
    }

    public void getPipeImage(String direction)
    {
        try
        {
            if(direction.equals("down"))
            {
                pipeImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pipes/DownPipe.png")));
            }
            else
            {
                pipeImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pipes/UpPipe.png")));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2)
    {
        g2.drawImage(pipeImage,pipeLocX,pipeLocY,pipeWidth,pipeHeight,null);
    }

}
