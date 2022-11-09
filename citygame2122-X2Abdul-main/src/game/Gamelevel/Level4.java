package game.Gamelevel;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;

public class Level4 extends Gamelevel {



    //declare and fetch level 4 music soundtrack
    private static SoundClip level4music;
    static {
        try {
            level4music = new SoundClip("data/SoundClips/level4.wav");
            level4music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    public Level4(Game game){
        super(game);

    }
    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public SoundClip backgroundMusic() {
        return level4music;
    }

    @Override
    public Image backgroundImage() {
        return null;
    }

    @Override
    public String Getlevel() {
        return null;
    }
}
