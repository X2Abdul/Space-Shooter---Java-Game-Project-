package game.Objects;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Asteroids extends Walker {
    //create asteriods object and add image
    private static final Shape Obstacle_Asteroid = new PolygonShape(0.056f,0.972f, 1.218f,0.34f, 1.056f,-0.593f, 0.235f,-0.939f, -0.956f,-0.738f, -1.291f,0.212f);
    private static final BodyImage Asteroid = new BodyImage("data/EnemiesandObtacles/bolder.png", 2f);

    //Declare variables
    private boolean timer;
    private int count;
    private int Lives;

    // adds object images and set its attributes
    public Asteroids (World world) {
        // adds object images and set its attributes
        super(world, Obstacle_Asteroid);
        addImage(Asteroid);
        this.setGravityScale(0.3f);

        //initialise variables
        timer = true;
        count = 0;
        System.out.println(count);
        Lives = 2;

    }


    // Accessors
    public int getLives(){return Lives;}
    public void setLives(int lives){this.Lives = lives;}

}
