package objects;

import main.GamePanel;
import physics.Collider;
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

    protected int birdHeight;
    protected int birdWidth;

    Collider coll;

    public String isCollision()
    {
        int birdUp = coll.y;
        int birdDown = coll.y + coll.height;

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

    public Bird(GamePanel gp, Collider coll)
    {
        this.birdHeight = gp.size;
        this.birdWidth = gp.size;

        this.gp = gp;
        this.coll = coll;

        birdPosX = gp.windowWidth/2 - birdWidth/2;
        birdPosY = gp.windowHeight/2 - birdHeight/2;
        getBirdImage();
    }

    private void setCollider()
    {
        coll.x = birdPosX + 5;
        coll.y = birdPosY + 14;
        coll.width = birdWidth - 8;
        coll.height = birdHeight - 30;
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

        setCollider();

        if(isCollision().equals("upCollision"))
        {
            birdPosY = -14;
            birdVelocityY = 0;      /* <----When we dont do that bird tries to jump and collision try to get bird the 0 location
                                    and bird look like up down up down*/
            birdPosY+= gm.getGravity(birdSpeedY);
        }
        else if(isCollision().equals("downCollision"))
        {
            birdPosY = gp.windowHeight - (birdHeight - 14);
            birdVelocityY = 0;

        }
    }

    public void drawBird(Graphics2D g2)
    {

        setCollider();
        g2.drawImage(birdImage,birdPosX,birdPosY,birdWidth,birdHeight,null);
        g2.setColor(Color.black);
        //g2.drawRect(coll.x, coll.y, coll.width, coll.height);
        //Hit Box
    }
}
