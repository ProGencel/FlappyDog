package main;


import background.Background;
import keyBusinesses.KeyHandler;
import objects.Bird;
import objects.Score;
import physics.Collider;
import physics.Music;
import physics.PipeManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    final int SPRITE_SIZE = 32;
    final int scale = 2;
    public int size = SPRITE_SIZE * scale;

    public int windowWidth = size * 20;
    public int windowHeight = size * 10;

    private final int FPS = 60;
    public Thread gameThread;
    public boolean isGameOver = false;
    boolean isLoseSoundPlayed = false;
    public int currentFPS = 0;

    Music music = new Music();
    Score score = new Score(this);
    GameOver go = new GameOver(this, score);
    Background back = new Background(this);
    KeyHandler keyH = new KeyHandler();
    Bird bird = new Bird(this, new Collider());
    public PipeManager pipemanager = new PipeManager(this, bird, new Collider());

    public GamePanel() {
        setPreferredSize(new Dimension(windowWidth, windowHeight));
        this.setFocusable(true);
        this.setDoubleBuffered(true);

        keyH.setBird(bird, this);

        this.addKeyListener(keyH);
        music.setSound();
        playMusic(0);
    }

    public void startThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        int frameCounter = 0;
        long frameTime = 1_000_000_000 / FPS;
        long nextFrameTime = System.nanoTime() + frameTime;

        while (!isGameOver) {

            while (System.nanoTime() >= nextFrameTime) {
                update();
                repaint();
                nextFrameTime += frameTime;
                frameCounter++;
            }

            long timeRemaining = nextFrameTime - System.nanoTime();
            if (timeRemaining > 0) {
                long sleepTime = timeRemaining / 1_000_000;
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            long finish = System.nanoTime();
            if (finish - start >= 1_000_000_000) {

                currentFPS = frameCounter;
                System.out.println("FPS : " + frameCounter);
                frameCounter = 0;
                start = finish;
            }
        }
    }

    public void update() {
        bird.update();
        pipemanager.update();
        back.update();
        go.update();
        if(isGameOver)
        {
            if(!isLoseSoundPlayed)
            {
                playSound(2);
                stopMusic(0);
                isLoseSoundPlayed = true;
            }
        }
    }

    public void gameRestart() {
        pipemanager.setFirstPipes();
        bird.setBirdLoc();
        playMusic(0);
        Score.score = 0;
        isGameOver = false;
        isLoseSoundPlayed = false;
        bird.birdVelocityY = 0;
        //stopMusic(2);
        startThread();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        double scaleX = (double) panelWidth / windowWidth;
        double scaleY = (double) panelHeight / windowHeight;

        g2.scale(scaleX,scaleY);

        back.draw(g2);
        bird.drawBird(g2);
        pipemanager.draw(g2);
        score.draw(g2);

        g2.setColor(new Color(25, 25, 112));
        g2.setFont(new Font("Arial", Font.BOLD, 15));
        g2.drawString("FPS: " + currentFPS, windowWidth - 75, 20);

        if (isGameOver) {
            go.draw(g2);
        }
    }

    public void playMusic(int i) {
        music.setSound(i);
        music.playSound(i);
        music.loop();
    }

    public void playSound(int i) {
        music.setSound(i);
        music.playSound(i);
    }

    public void stopMusic(int i)
    {
        music.stopSound(i);
    }

}
