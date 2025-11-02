package main;


import keyBusinesses.KeyHandler;
import objects.Bird;
import physics.Collider;
import physics.PipeManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{


    public int windowWidth = 1200;
    public int windowHeight = 650;

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
                Thread.sleep(miliSecondBetween2Frames-betweenTime);
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

        pipemanager.draw(g2);
        bird.drawBird(g2);
    }

}
