package game.Gamelevel;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.Backpack.singleBullet;
import game.Backpack.tripleBullet;
import game.SpawnObjects.SpawnAsteroidsLv1;
import game.SpawnObjects.SpawnEnemyLv1;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level2 extends Gamelevel {
    private SpawnAsteroidsLv1 spawnAsteroids;
    private SpawnEnemyLv1 spawnEnemy;
    private SpawnAsteroidsLv1 spawnAsteroidsLv1;

    //declare and fetch level 2 music soundtrack
    private static SoundClip level2music;

    static {
        try {
            level2music = new SoundClip("data/SoundClips/level2.wav");
            level2music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }
    public Level2(Game game) {
        super(game);

        //ships position at the start of the level
        getSpaceShip().setPosition(new Vec2(0, -10));

        //adds single bullet and triple bullet to the backpack
        getSpaceShip().getBackpack().addItem(new singleBullet(getSpaceShip()));
        getSpaceShip().getBackpack().addItem(new tripleBullet(getSpaceShip()));

        //spawns enemies and asteroids
        spawnAsteroids = new SpawnAsteroidsLv1(this,getObstacle_Asteroid(), getSpaceShip());
        spawnEnemy = new SpawnEnemyLv1(this, getEnemies(), getSpaceShip(), this, getGame());



        // restriction walls
        Shape side = new BoxShape(0.5f, 400);
        StaticBody rightside = new StaticBody(this, side);
        rightside.setPosition(new Vec2(10.5f, 0f));
        StaticBody leftside = new StaticBody(this, side);
        leftside.setPosition(new Vec2(-10.5f, 0f));
    }

    @Override
    public boolean isComplete() {
        //when the score is above 15 level 2 complete
        if (getSpaceShip().getScore() >= 15){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public SoundClip backgroundMusic() {
        return level2music;
    }

    @Override
    public Image backgroundImage() {
        Image background  = new ImageIcon("data/Levelbackground/backgroundlv2.png").getImage();
        return background;
    }

    @Override
    public String Getlevel() {
        return "level2";
    }
}

