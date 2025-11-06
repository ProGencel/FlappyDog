package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame("Flappy Bird Game");
        GamePanel gp = new GamePanel();
        window.add(gp);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setResizable(false);

        gp.startThread();

    }
}