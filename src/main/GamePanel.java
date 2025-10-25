package main;


import objects.Bird;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    Bird bird = new Bird();


    @Override
    public void run() {


    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(bird.birdImage,0,0,50,50,null);

    }

}
