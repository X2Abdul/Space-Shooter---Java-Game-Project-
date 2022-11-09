package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import game.Collectable.health;
import game.Collectable.mag;
import game.Gamelevel.Game;
import game.Gamelevel.Gamelevel;
import game.Objects.Asteroids;
import game.Objects.Enemies;
import game.Player.Ship;
import game.Objects.lv3Enemy;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class tripleBulletCollision implements CollisionListener {
    private lv3Enemy lv2Enemy;
    private Ship Spaceship;
    private Gamelevel currentlevel;
    private Game game;
    private static SoundClip explo;
    static {
        try {
            explo = new SoundClip("data/SoundClips/explo2.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    public tripleBulletCollision(lv3Enemy lv2Enemy, Ship spaceship, Gamelevel currentlevel, Game game){
        this.currentlevel = currentlevel;
        this.lv2Enemy = lv2Enemy;
        this.Spaceship = spaceship;
        this.game = game;
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        //Collision between the triple bullet and the lv3enemy
        if (collisionEvent.getOtherBody() instanceof lv3Enemy) {
            // destroy lv3enemy and add 2 to the score variable
            ((lv3Enemy) collisionEvent.getOtherBody()).death();
            Spaceship.setScore(Spaceship.getScore() + 2);
            collisionEvent.getReportingBody().destroy();
        }

        //Collision between the triple bullet and the asteroid
        else if (collisionEvent.getOtherBody() instanceof Asteroids) {
            // destroy asteroids and add 1 to the score variable
            explo.play();
            collisionEvent.getOtherBody().destroy();
            collisionEvent.getReportingBody().destroy();
            Spaceship.setScore(Spaceship.getScore() + 1);


        }

        //Collision between the triple bullet and the enemies
        else if (collisionEvent.getOtherBody() instanceof Enemies) {
            // destroy enemies and add 1 to the score variable
            ((Enemies) collisionEvent.getOtherBody()).death();
            collisionEvent.getReportingBody().destroy();
            Spaceship.setScore(Spaceship.getScore() + 1);
            if (currentlevel.isComplete()) {
                game.nextLevel();
            }
        }
        //Collision between bullet and the mag object
        else if (collisionEvent.getOtherBody() instanceof mag) {
            //destroy bullet
            collisionEvent.getReportingBody().destroy();
        }
        //Collision between bullet and the health object
        else if (collisionEvent.getOtherBody() instanceof health) {
            //destroy bullet
            collisionEvent.getReportingBody().destroy();
        }
    }

    }
