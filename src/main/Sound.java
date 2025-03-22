package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class Sound {

    Clip clip;
    URL[] soundURL = new URL[10];

    public Sound() {

        soundURL[0] = getClass().getResource("/sound/music/Final_Fantasy_Theme_Harp.wav");
        soundURL[1] = getClass().getResource("/sound/sfx/Fanfare.wav");
        soundURL[2] = getClass().getResource("/sound/sfx/Collect_1.wav");
        soundURL[3] = getClass().getResource("/sound/sfx/Collect_2.wav");
        soundURL[4] = getClass().getResource("/sound/sfx/Door_Slam.wav");

    }

    public void setFile(int i) {

        try {

            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);

        } catch (Exception _) {

        }
    }

    public void play() {

        clip.start();
    }

    public void loop() {

        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {

        clip.stop();
    }
}
