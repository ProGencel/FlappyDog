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

    private final int pipeWidth;
    private final int pipeHeight;
    private final int pipeSpeed = 3;

    public Pipes(GamePanel gp,Bird bird,String direction)
    {

        pipeWidth = bird.birdWidth*2;
        pipeHeight = gp.windowHeight/2 - bird.birdHeight - 25;
        pipeLocX = gp.windowWidth-pipeWidth;
        this.gp = gp;

        getPipeImage(direction);
    }

    public void update()
    {
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
