package main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.net.URL;

public class Sound {

    Clip clip;
    URL[] soundURL = new URL[20];

    public Sound() {


        soundURL[0] = getClass().getResource("/sound/music/Final_Fantasy_Theme_Harp.wav");
        soundURL[1] = getClass().getResource("/sound/sfx/Fanfare.wav");
        soundURL[2] = getClass().getResource("/sound/sfx/Collect_1.wav");
        soundURL[3] = getClass().getResource("/sound/sfx/Collect_2.wav");
        soundURL[4] = getClass().getResource("/sound/sfx/Door_Slam.wav");
        soundURL[5] = getClass().getResource("/sound/music/The_Legend_Of_Zelda_Title.wav");
        soundURL[6] = getClass().getResource("/sound/music/The_Legend_Of_Zelda_Title_Piano.wav");
        soundURL[7] = getClass().getResource("/sound/sfx/Dying.wav");
        soundURL[8] = getClass().getResource("/sound/sfx/Hit_Enemy_1.wav");
        soundURL[9] = getClass().getResource("/sound/sfx/Receive_Life.wav");
        soundURL[10] = getClass().getResource("/sound/sfx/Sword_Swing.wav");
        soundURL[11] = getClass().getResource("/sound/sfx/Hit_Enemy.wav");
        soundURL[12] = getClass().getResource("/sound/sfx/Cursor.wav");
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
    public void setVolume(float volume ) {
        FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        volumeControl.setValue(volume);
    }
}
