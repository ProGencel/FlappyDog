package keyBusinesses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean isUp = false;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_SPACE)
        {
            isUp = true;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_SPACE)
        {
            isUp = false;
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {}

}
