package main;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        JFrame window = new JFrame("Flappy Bird Game");
        WindowSettings ws = new WindowSettings();
        GamePanel gp = new GamePanel();
        window.add(gp);

        window.setSize(ws.windowWidth,ws.windowHeight);
        window.setLocationRelativeTo(null);

        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setVisible(true);

    }
}