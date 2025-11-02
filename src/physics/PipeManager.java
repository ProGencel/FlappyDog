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
        for(int i = 0;i<numberOfPipes/2;i++)
        {
            setPipes();
        }
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
            }
        }
    }

    public void setPipes()
    {
        for(int i = 0;i<numberOfPipes;i+=2)
        {
            Pipes p1 = pipe.get(i);
            Pipes p2 = pipe.get(i+1);
            Random rand = new Random();
            int randNum = 200;

            int p1Y = rand.nextInt(randNum) - randNum/2;

            p1.pipeHeight = p1.pipeHeight - p1Y;
            p2.pipeHeight = Pipes.totalPipeHeight - p1.pipeHeight;
        }

        for(int i = 0;i<numberOfPipes;i+=2)
        {
            Pipes p1 = pipe.get(i);
            Pipes p2 = pipe.get(i+1);
            int pipesGap = (gp.windowWidth-((numberOfPipes)/2 - 1) * p1.pipeWidth) / 4; //( windows width - pipecollider*numberofpipes ) / 5

            if(i != 0)
            {
                p1.setCollision();
                Pipes tempP = pipe.get(i-2);

                p1.pipeLocX = tempP.pipeLocX + p1.pipeWidth + pipesGap;
                p2.pipeLocX = p1.pipeLocX;
            }
//            else
//            {
//                Pipes tempP = pipe.get(numberOfPipes-1);
//                p1.pipeLocX = tempP.pipeLocX + p1.pipeWidth + pipesGap;
//                p2.pipeLocX = p1.pipeLocX;
//            }
        }

        for(int i = 0;i<numberOfPipes;i+=2)
        {
            Pipes p1 = pipe.get(i);     //Up
            Pipes p2 = pipe.get(i+1);   //Down

            p1.pipeLocY = 0;
            p2.pipeLocY = gp.windowHeight - p2.pipeHeight;
        }
    }

    public void draw(Graphics2D g2)
    {
        for(int i =0;i<numberOfPipes;i++)
        {
            Pipes p = pipe.get(i);
            p.draw(g2);
        }
    }

}
