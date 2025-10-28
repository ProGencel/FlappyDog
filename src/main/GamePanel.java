package main;


import keyBusinesses.KeyHandler;
import objects.Bird;
import objects.Pipes;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{


    public int windowWidth = 1200;
    public int windowHeight = 650;

    private final int FPS = 60;
    private final int miliSecondBetween2Frames = 1_000 / FPS;

    Thread gameThread;

    KeyHandler keyH = new KeyHandler();
    Bird bird = new Bird(this);
    Pipes pipeDown = new Pipes(this,bird,"down");
    Pipes pipeUp = new Pipes(this,bird,"up");


    public GamePanel()
    {
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
                throw new RuntimeException(e);
            }
        }

    }

    public void update()
    {
        pipeDown.update();
        pipeUp.update();
        bird.update();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        bird.drawBird(g2);
        pipeDown.draw(g2);
        pipeUp.draw(g2);

    }

}
