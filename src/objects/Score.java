package objects;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Score {

    GamePanel gp;

    public Score(GamePanel gp)
    {
        this.gp = gp;
    }

    public static int score = 0;
    int fontSize = 20;
    Font customFont = new Font("Arial",Font.BOLD,fontSize);

    public void draw(Graphics2D g2)
    {
        g2.setFont(customFont);
        String scr = String.valueOf(score);
        g2.drawString(scr,10,20);
    }

}
