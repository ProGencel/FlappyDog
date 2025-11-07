package objects;

import keyBusinesses.KeyHandler;
import main.GamePanel;
import physics.Collider;

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

    public final int pipeWidth;
    public int pipeHeight;
    private final int pipeSpeed = 4;
    String pipeDirection;

    public Collider coll;

    public Pipes(GamePanel gp,Bird bird,String direction,Collider coll)
    {

        pipeWidth = bird.birdWidth * 3;
        pipeHeight = gp.size * 12; //64 * 6


        pipeLocX = gp.windowWidth-pipeWidth;
        this.gp = gp;
        this.bird = bird;
        this.coll = coll;

        this.pipeDirection = direction;
        getPipeImage(direction);
    }


    public void setCollision()
    {
        int gapUp = -1;
        int gapDown = -1;
        int gapLeft;
        int gapRight;


        if(pipeDirection.equals("down"))
        {
            gapUp = 30;
            gapDown = 30;
        }
        else if(pipeDirection.equals("up"))
        {
            gapUp = 0;
            gapDown = 30;
        }
        gapLeft = 50;
        gapRight = 107;

        coll.x = pipeLocX + gapLeft;
        coll.y = pipeLocY + gapUp;
        coll.width = pipeWidth - gapRight;
        coll.height = pipeHeight - gapDown;
    }

    public void update()
    {

        setCollision();

        int birdLeft = bird.coll.x;
        int birdRight = bird.coll.x + bird.coll.width;
        int birdUp = bird.coll.y;
        int birdDown = bird.coll.y + bird.coll.height;

        int pipeLeft = coll.x;
        int pipeRight = coll.x + coll.width;
        int pipeUp = coll.y;
        int pipeDown = coll.y + coll.height;

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

            if(birdRight >= pipeRight && birdRight <= pipeRight+3)
            {
                Score.score++;
            }

        }

        if(isDmg)
        {
            gp.stopMusic(0);
            gp.isGameOver = true;
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
        g2.setColor(Color.black);
        //g2.drawRect(coll.x,coll.y,coll.width,coll.height);  //Hit box
        //g2.drawRect(pipeLocX,pipeLocY,pipeWidth,pipeHeight);
    }

}
