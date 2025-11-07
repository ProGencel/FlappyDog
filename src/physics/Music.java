package physics;

import javax.sound.sampled.*;
import java.net.URL;

public class Music{

    Clip clipMusic;
    Clip clipJumpSound;
    Clip clipLose;
    URL[] soundURL = new URL[3];

    public void setSound()
    {
        try
        {
            soundURL[0] = getClass().getResource("/sounds/backgroud.wav");
            soundURL[1] = getClass().getResource("/sounds/jump.wav");
            soundURL[2] = getClass().getResource("/sounds/lose.wav");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setSound(int i)
    {
        try
        {
            if(i == 0)
            {
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[0]);
                clipMusic = AudioSystem.getClip();
                clipMusic.open(ais);
                setSoundLevel(5.0f,0);
            }
            else if(i == 1)
            {
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[1]);
                clipJumpSound = AudioSystem.getClip();
                clipJumpSound.open(ais);
                setSoundLevel(-15.0f,1);
            }
            else if(i == 2)
            {
                AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[2]);
                clipLose = AudioSystem.getClip();
                clipLose.open(ais);
                setSoundLevel(-20.0f,1);
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void playSound(int i)
    {
        if(i == 0)
        {
            if(clipMusic != null)
            {
                clipMusic.start();
            }
        }
        else if(i == 1)
        {
            if(clipMusic != null)
            {
                clipJumpSound.start();
            }
        }
        else if(i == 2)
        {
            if(clipLose != null)
            {
                clipLose.start();
            }
        }
    }

    public void loop()
    {
        clipMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stopSound(int i)
    {
        if(i == 0)
        {
            clipMusic.stop();
        }
        else if(i == 1)
        {
            clipJumpSound.stop();
        }
        else if(i == 2)
        {
            clipLose.stop();
        }
    }

    public void setSoundLevel(float volumeLevel,int i)
    {
        if(i == 0)
        {
            FloatControl gainControl = (FloatControl) clipMusic.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volumeLevel);
        }
        else if(i == 1)
        {
            FloatControl gainControl = (FloatControl) clipJumpSound.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volumeLevel);
        }
        else if(i == 2)
        {
            FloatControl gainControl = (FloatControl) clipLose.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(volumeLevel);
        }
    }
}
