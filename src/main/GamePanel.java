package main;


import keyBusinesses.KeyHandler;
import objects.Bird;
import physics.Collider;
import physics.PipeManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    final int SPRITE_SIZE = 32;
    final int scale = 2;
    public int size = SPRITE_SIZE*scale;

    public int windowWidth = size*20;
    public int windowHeight = size*10;

    private final int FPS = 60;
    private final int miliSecondBetween2Frames = 1_000 / FPS;

    public Thread gameThread;

    KeyHandler keyH = new KeyHandler();
    Bird bird = new Bird(this, new Collider());
    public PipeManager pipemanager = new PipeManager(this,bird,new Collider());

    public GamePanel()
    {
        setPreferredSize(new Dimension(windowWidth,windowHeight));
        this.setFocusable(true);
        this.setDoubleBuffered(true);

        keyH.setBird(bird);

        this.addKeyListener(keyH);
    }

    public void startThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        while(gameThread!=null)
        {
            long startTime = System.currentTimeMillis();
            update();
            repaint();
            long lastTime = System.currentTimeMillis();

            long betweenTime = lastTime-startTime;

            try {
                if(miliSecondBetween2Frames-betweenTime > 0)
                {
                    Thread.sleep(miliSecondBetween2Frames-betweenTime);
                }
            } catch (InterruptedException e) {
                break;
            }
        }

    }

    public void update()
    {
        bird.update();
        pipemanager.update();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        bird.drawBird(g2);
        pipemanager.draw(g2);
    }

}
