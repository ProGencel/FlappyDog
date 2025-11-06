package main;

import objects.Score;

import java.awt.*;

public class GameOver {

    GamePanel gp;
    Score score;

    Rectangle gameOverPanel = new Rectangle();
    Color color = new Color(34, 139, 34, 240);

    public GameOver(GamePanel gp, Score score)
    {
        this.gp = gp;
        this.score = score;

        gameOverPanel.width = gp.windowWidth - 2*330;
        gameOverPanel.height = gp.windowHeight - 2*150;
        gameOverPanel.x = (gp.windowWidth - gameOverPanel.width)/2;
        gameOverPanel.y = (gp.windowHeight - gameOverPanel.height)/2;
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(color);
        g2.fillRect(gameOverPanel.x, gameOverPanel.y, gameOverPanel.width, gameOverPanel.height);

        g2.setColor(Color.black);
        int score1 = Score.loadHighScore();
        g2.drawString(String.valueOf(score1),gameOverPanel.x+100, gameOverPanel.y+100);
    }

    public void update()
    {
        if(gp.isGameOver)
        {
            if(Score.score>Score.loadHighScore())
            {
                Score.saveHighScore(Score.score);
            }
        }
    }

}
