package physics;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Music{

    Clip clip;
    URL[] soundURL = new URL[2];

    public void setSound()
    {
        try
        {
            soundURL[0] = getClass().getResource("/sounds/backgroud.wav");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setFile(int i)
    {
        try
        {
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void playSound()
    {
        if(clip != null)
        {
            clip.start();
        }
    }

    public void loop()
    {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopSound()
    {
        clip.stop();
    }
}
