package game.Gamelevel;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import game.Backpack.singleBullet;
import game.SpawnObjects.SpawnAsteroidsLv1;
import game.SpawnObjects.SpawnEnemyLv1;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level1 extends Gamelevel {
    //Declare variables
    private SpawnAsteroidsLv1 spawnAsteroids;
    private SpawnEnemyLv1 spawnEnemy;
    private Game game;
    private game.SpawnObjects.spawnCollectable spawnCollectable;
    private game.Collectable.mag mag;

    // declares and initialise level 1 music
    private static SoundClip level1music;
    static {
        try {
            level1music = new SoundClip("data/SoundClips/level1.wav");
            level1music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }





    public Level1(Game game){
        super(game);

        //set ship's position at the start of the level
        getSpaceShip().setPosition(new Vec2(0, -10));

        //spawn enemies and asteriods
        spawnAsteroids = new SpawnAsteroidsLv1(this,getObstacle_Asteroid(), getSpaceShip());
        spawnEnemy = new SpawnEnemyLv1(this, getEnemies(), getSpaceShip(), this, getGame());

        //adds the sngle bullet to the backpack as the first item
        getSpaceShip().getBackpack().addItem(new singleBullet(getSpaceShip()));

        //restrictionwalls to keep the player in the view
        Shape side = new BoxShape(0.5f, 400);
        StaticBody rightside = new StaticBody(this, side);
        rightside.setPosition(new Vec2(10.5f, 0f));
        StaticBody leftside = new StaticBody(this, side);
        leftside.setPosition(new Vec2(-10.5f, 0f));
    }



    @Override
    public boolean isComplete() {
        //when score is higer than 10 level 1 complete
        if(getSpaceShip().getScore() >= 10){
            System.out.println("done");
            return true;
        }
        else{
            return false;
        }
    }

    //returns the level 1 music
    @Override
    public SoundClip backgroundMusic() {
        return level1music;
    }

    //returns the level 1 background image
    @Override
    public Image backgroundImage() {
        Image background  = new ImageIcon("data/Levelbackground/background.png").getImage();
        return background;
    }

    //return the name of the level
    @Override
    public String Getlevel() {
        return "level1";
    }
}
