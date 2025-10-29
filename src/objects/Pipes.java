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

    GamePanel gp;
    Bird bird;

    private final int pipeWidth;
    private final int pipeHeight;
    private final int pipeSpeed = 3;
    String pipeDirection;

    public Pipes(GamePanel gp,Bird bird,String direction)
    {

        pipeWidth = bird.birdWidth*2;
        pipeHeight = gp.windowHeight/2 - bird.birdHeight - 25;
        pipeLocX = gp.windowWidth-pipeWidth;
        this.gp = gp;
        this.bird = bird;

        this.pipeDirection = direction;
        getPipeImage(direction);
    }

    public void update()
    {

        int birdLeft = bird.birdPosX;
        int birdRight = bird.birdPosX + bird.birdWidth;
        int birdUp = bird.birdPosY;
        int birdDown = bird.birdPosY + bird.birdHeight;


        int pipeLeft = pipeLocX;
        int pipeRight = pipeLocX + pipeWidth;
        int pipeUp = pipeLocY;
        int pipeDown = pipeLocY + pipeHeight;

        boolean isDmg = false;

        if(pipeDirection.equals("up"))
        {
             isDmg = ((birdRight > pipeLeft && birdRight < pipeRight)
                && (birdUp < pipeDown))
            || ((birdLeft < pipeRight && birdLeft > pipeLeft)
                     && (birdUp < pipeDown));
        }
        else if(pipeDirection.equals("down"))
        {
            isDmg = ((birdRight > pipeLeft && birdRight < pipeRight)
                    && (birdDown > pipeUp))
            || ((birdLeft < pipeRight && birdLeft > pipeLeft)
                    && (birdDown > pipeUp));
        }

        if(isDmg)
        {
            gp.gameThread = null;
        }

        this.pipeLocX-=pipeSpeed;
    }

    public void getPipeImage(String direction)
    {
        try
        {
            if(direction.equals("down"))
            {
                pipeImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pipes/DownPipe.png")));
                this.pipeLocY = gp.windowHeight-pipeHeight;
            }
            else
            {
                pipeImage = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/pipes/UpPipe.png")));
                this.pipeLocY = 0;
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
