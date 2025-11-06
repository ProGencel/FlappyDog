package keyBusinesses;

import main.GamePanel;
import objects.Bird;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    Bird bird;
    GamePanel gp;

    public void setBird(Bird bird,GamePanel gp)
    {
        this.bird = bird;
        this.gp = gp;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_SPACE)
        {
            bird.jumpBird();
        }
        if(code == KeyEvent.VK_R)
        {
            if(gp.isGameOver)
            {
                gp.gameRestart();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

}
