package objects;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class Score {

    GamePanel gp;
    public static int SECRET_CODE = 147;

    public Score(GamePanel gp)
    {
        this.gp = gp;
    }

    public static int score = 0;
    int fontSize = 20;
    Font customFont = new Font("Arial",Font.BOLD,fontSize);
    public static final String FILE_NAME = "highscore.txt";


    public void draw(Graphics2D g2)
    {
        g2.setFont(customFont);
        String scr = String.valueOf(score);

        int x = 10;
        int y = 25;

        int outlineThickness = 1;

        g2.setColor(Color.BLACK);

        for(int i = -outlineThickness; i <= outlineThickness; i++) {
            for(int j = -outlineThickness; j <= outlineThickness; j++) {
                if(i != 0 || j != 0) {
                    g2.drawString(scr, x + i, y + j);
                }
            }
        }

        g2.setColor(Color.WHITE);
        g2.drawString(scr, x, y);
    }

    public static int loadHighScore()
    {
        try
        {
            File file = new File(FILE_NAME);

            if(!file.exists() || file.length() == 0)
            {
                return 0;
            }

            Scanner scanner = new Scanner(file);
            if(scanner.hasNextInt())
            {
                int highScore = scanner.nextInt();
                scanner.close();
                return highScore/SECRET_CODE;
            }
            scanner.close();
            return 0;

        }catch(FileNotFoundException e)
        {
            System.out.println("Error High Score : " + e.getMessage());
            return 0;
        }
    }

    public static void saveHighScore(int newHighScore)
    {
        try
        {
            FileWriter writer = new FileWriter(FILE_NAME);
            newHighScore *= SECRET_CODE;
            writer.write(String.valueOf(newHighScore));
            writer.close();

        } catch (Exception e){
            System.out.println("Error while saving the high score" + e.getMessage());
        }

    }

}
