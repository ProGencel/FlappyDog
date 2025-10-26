package main;


import keyBusinesses.KeyHandler;
import objects.Bird;
import objects.Pipes;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{


    public int windowWidth = 1200;
    public int windowHeight = 650;

    Thread gameThread;

    Bird bird = new Bird(this);
    Pipes pipes = new Pipes(this,bird,"down");


    public void startThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread!=null)
        {
            update();
            repaint();
        }

    }

    public void update()
    {

    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        bird.drawBird(g2);
        pipes.draw(g2);

    }

}
