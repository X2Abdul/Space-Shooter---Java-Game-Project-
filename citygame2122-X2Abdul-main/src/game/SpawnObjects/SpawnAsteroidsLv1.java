package game.SpawnObjects;

import city.cs.engine.World;
import game.Objects.Asteroids;
import game.Player.Ship;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.random.RandomGenerator;

public class SpawnAsteroidsLv1 implements ActionListener {

    private World world;
    private Asteroids asteroids;
    private RandomGenerator random = new Random();
    private int count;
    private Timer timer;
    private boolean timestop;
    private Ship spaceship;

    public SpawnAsteroidsLv1(World world, Asteroids asteroids, Ship spaceship){
        this.world = world;
        this.asteroids = asteroids;
        count = 0;

        // creates asteroids object every 2 seconds
        timer = new Timer(2000, this);
        this.spaceship = spaceship;
        timer.start();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        asteroids = new Asteroids(world);
        // places a obejct at random x and 25 y
        asteroids.setPosition(new Vec2((random.nextFloat() * 20) - 10, 25));
        count++;
        //creates 100 and then timer stops
        if(count == 100){
            timer.stop();
        }
        if(count >= 5){
            spawnCollectable spawnhealth = new spawnCollectable(world,spaceship, this);
            spawnhealth.spawnhealth();
        }

    }

//Accessors
    public int getCount(){
        return count;
    }
}
