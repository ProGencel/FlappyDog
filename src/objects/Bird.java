package objects;

import main.GamePanel;
import physics.GravityManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Bird {

    GamePanel gp;
    GravityManager gm = new GravityManager();

    public BufferedImage birdImage;
    public int birdPosX;
    public int birdPosY;

    public double birdVelocityY = 0;
    public int birdSpeedY = 1;

    protected final int birdHeight = 70;
    protected final int birdWidth = 70;

    boolean isJump = false;

    public String isCollision()
    {
        int birdUp = birdPosY;
        int birdDown = birdPosY + birdHeight;

        if(birdUp <= 0)
        {
            return "upCollision";
        }
        else if(birdDown >= gp.windowHeight)
        {
            return "downCollision";
        }
        return "noCollision";
    }

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

    public void jumpBird()
    {
        birdVelocityY = -8.5;
    }

    public void update()
    {

        birdPosY+= gm.getGravity(birdSpeedY);
        birdPosY+= this.birdVelocityY;
        if(this.birdVelocityY != 0)
        {
            this.birdVelocityY+= 0.2;
        }

        if(isCollision().equals("upCollision"))
        {
            birdPosY = 0;
            birdVelocityY = 0;      /* <----When we dont do that bird tries to jump and collision try to get bird the 0 location
                                    and bird look like up down up down*/
            birdPosY+= gm.getGravity(birdSpeedY);
        }
        else if(isCollision().equals("downCollision"))
        {
            birdPosY = gp.windowHeight - birdHeight;


        }
    }

    public void drawBird(Graphics2D g2)
    {
        g2.drawImage(birdImage,birdPosX,birdPosY,birdWidth,birdHeight,null);
    }
}
