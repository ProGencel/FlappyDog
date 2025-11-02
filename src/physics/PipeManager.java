package physics;

import main.GamePanel;
import objects.Bird;
import objects.Pipes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PipeManager {

    int numberOfPipes = 8;
    GamePanel gp;

    List<Pipes> pipe = new ArrayList<>(numberOfPipes);
    public PipeManager(GamePanel gp, Bird bird, Collider coll)
    {
        this.gp = gp;
        for(int i = 0;i<numberOfPipes/2;i++)
        {
            pipe.add(new Pipes(gp,bird,"up",new Collider()));
            pipe.add(new Pipes(gp,bird,"down",new Collider()));
        }
        setPipes();
    }

    public void update()
    {
        for(int i = 0;i<numberOfPipes;i+=2)
        {
            Pipes p1 = pipe.get(i);
            Pipes p2 = pipe.get(i+1);
            p1.update();
            p2.update();

            if(p1.pipeLocX+p1.pipeWidth < 0)
            {
                p1.pipeLocX = gp.windowWidth;
                p2.pipeLocX = p1.pipeLocX;
                setRandomYForPipes(p1,p2);
            }
        }
    }

    public void setRandomYForPipes(Pipes p1, Pipes p2)
    {
        Random rand = new Random();
        int randNum = gp.size*7;
        int horGap = gp.size*2;

        p1.pipeLocY = rand.nextInt(randNum) - gp.size*12;
        p2.pipeLocY = p1.pipeLocY + p1.pipeHeight + horGap;
    }

    public void setPipes()
    {
        for(int i = 0;i<numberOfPipes;i+=2)
        {
            Pipes p1 = pipe.get(i);
            Pipes p2 = pipe.get(i+1);
            setRandomYForPipes(p1,p2);

        }

        for(int i = 0;i<numberOfPipes;i+=2)
        {
            Pipes p1 = pipe.get(i);
            Pipes p2 = pipe.get(i+1);
            int pipesGap = (gp.windowWidth-((numberOfPipes)/2 - 1) * p1.pipeWidth) / 4;

            if(i != 0)
            {
                p1.setCollision();
                Pipes tempP = pipe.get(i-2);

                p1.pipeLocX = tempP.pipeLocX + p1.pipeWidth + pipesGap;
                p2.pipeLocX = p1.pipeLocX;
            }
        }
    }

    public void draw(Graphics2D g2)
    {
        for(int i = 0;i<numberOfPipes;i++)
        {
            Pipes p = pipe.get(i);
            p.draw(g2);
        }
    }

}
