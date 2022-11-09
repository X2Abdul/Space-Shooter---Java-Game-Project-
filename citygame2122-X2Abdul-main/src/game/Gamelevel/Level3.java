package game.Gamelevel;

import city.cs.engine.SoundClip;
import game.Backpack.singleBullet;
import game.Backpack.tripleBullet;
import game.Collisions.leftWallCollision;
import game.Collisions.rightWallCollision;
import game.Objects.leftWall;
import game.Objects.lv3Enemy;
import game.Objects.rightWall;
import game.SpawnObjects.SpawnAsteroidsLv1;
import game.SpawnObjects.SpawnEnemyLv1;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Level3 extends Gamelevel {
    private Game game;
    private SpawnAsteroidsLv1 spawnAsteroids;
    private SpawnEnemyLv1 spawnEnemy;
    private lv3Enemy lv2Enemy;

    //declare and fetch level 3 music soundtrack
    private static SoundClip level3music;

    static {
        try {
            level3music = new SoundClip("data/SoundClips/level3.wav");
            level3music.loop();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }


    public Level3(Game game){
        super(game);

        //ships position at the start of the level
        getSpaceShip().setPosition(new Vec2(0, -10));

        //adds single bullet and triple bullet to the backpack
        getSpaceShip().getBackpack().addItem(new singleBullet(getSpaceShip()));
        getSpaceShip().getBackpack().addItem(new tripleBullet(getSpaceShip()));

        //spawns lv3 enemy and set its position
        lv2Enemy = new lv3Enemy(this, game, getSpaceShip());
        lv2Enemy.setPosition(new Vec2(0,12));

        //restriction walls and add collision listener to bounce the lv3 enemy side to side
        leftWall leftWall = new leftWall(this);
        leftWall.setPosition(new Vec2(-10.5f,0));
        leftWall.addCollisionListener(new leftWallCollision(lv2Enemy));

        rightWall rightWall = new rightWall(this);
        rightWall.setPosition(new Vec2(10.5f,0));
        rightWall.addCollisionListener(new rightWallCollision(lv2Enemy));

    }

    @Override
    public boolean isComplete() {
        // when score is more than 2 and all the enemies are destroyed level 3 complete
        if(getSpaceShip().getScore() >= 2){
            System.out.println("done");
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public SoundClip backgroundMusic() {
        return level3music;
    }

    @Override
    public Image backgroundImage() {
        Image background  = new ImageIcon("data/Levelbackground/backgroundlv3.png").getImage();
        return background;
    }

    @Override
    public String Getlevel() {
        return "level3";
    }
}
