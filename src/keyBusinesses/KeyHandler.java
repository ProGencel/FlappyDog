package keyBusinesses;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean isW,isS,isA,isD;

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W)
        {
            System.out.println("w ok");
            isW = true;
        }
        if(code == KeyEvent.VK_S)
        {
            isS = true;
        }
        if(code == KeyEvent.VK_A)
        {
            isA = true;
        }
        if(code == KeyEvent.VK_D)
        {
            isD = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W)
        {
            System.out.println("w nok");
            isW = false;
        }
        if(code == KeyEvent.VK_S)
        {
            isS = false;
        }
        if(code == KeyEvent.VK_A)
        {
            isA = false;
        }
        if(code == KeyEvent.VK_D)
        {
            isD = false;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

}
