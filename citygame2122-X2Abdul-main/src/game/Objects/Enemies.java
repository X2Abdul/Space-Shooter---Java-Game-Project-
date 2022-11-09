package game.Objects;

import city.cs.engine.*;
import game.Gamelevel.Game;
import game.Gamelevel.Gamelevel;
import game.Player.Ship;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Enemies extends Walker{
    // creates an enemy object and get its image
    public static final Shape Enemies = new PolygonShape(-0.02f,1.92f,
            1.31f,-0.57f,
            0.74f,-1.96f,
            -0.8f,-1.96f,
            -1.36f,-0.58f,
            -0.06f,1.94f);
    public static final BodyImage enemies = new BodyImage("data/EnemiesandObtacles/enemy.png", 4f);

    //declare variables
    private int lives;
    private Ship Spaceship;
    private Gamelevel gamelevel;
    private Game game;

    // adds the soundeffect
    private static SoundClip explo;
    static {
        try {
            explo = new SoundClip("data/SoundClips/explo2.wav");

        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }


    public Enemies(World world, Ship Spaceship, Gamelevel gamelevel, Game game) {
        //initialise variables
        super(world, Enemies);
        this.Spaceship = Spaceship;
        this.gamelevel = gamelevel;
        this.game = game;
        lives = 2;

        //adds image to the object and set its attributes
        addImage(enemies);
        this.setGravityScale(0.1f);

    }




    //instruction when the enemy object is in collision with weapons
    public void death(){
        //-1 lives when collision with the bullet
        this.setLives(this.getLives()-1);

        // play explo soundeffect when lives is 0 and destroy the object
        if(this.getLives() == 0) {
            explo.play();
            this.destroy();
        }
    }

    // Accessors
    public int getLives(){
        return lives;
    }
    public void setLives (int lives1){
        this.lives = lives1;
    }

}
