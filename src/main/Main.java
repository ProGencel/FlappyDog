package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame("Flappy Bird Game");
        GamePanel gp = new GamePanel();
        window.add(gp);

        window.setSize(gp.windowWidth,gp.windowHeight);
        window.setLocationRelativeTo(null);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

        gp.startThread();

    }
}