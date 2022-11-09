package game.SpawnObjects;

import city.cs.engine.World;
import game.Collectable.health;
import game.Collectable.mag;
import game.Player.Ship;
import org.jbox2d.common.Vec2;

import java.util.Random;
import java.util.random.RandomGenerator;

public  class spawnCollectable {

    private Ship spaceship;
    private World world;
    private SpawnAsteroidsLv1 spawnAsteroidsLv1;
    private RandomGenerator random = new Random();

    public spawnCollectable(World world, Ship spaceship, SpawnAsteroidsLv1 spawnAsteroidsLv1){
        this.spawnAsteroidsLv1 = spawnAsteroidsLv1;
        this.spaceship = spaceship;
        this.world = world;
    }
    //spawn mag when mag variable is less than 5
    public void spawnmag(){
        if(spaceship.getMag() <= 5) {
            mag mag = new mag(world, spaceship);
            mag.setPosition(new Vec2((random.nextFloat() * 20) - 10, 12));
        }
    }

    // spawn health object when lives variable is less than 2
    public void spawnhealth(){
        if(spaceship.getLives() <= 2){
            health health = new health(world, spaceship);
            health.setPosition(new Vec2((random.nextFloat() * 20) - 10, 12));
        }
    }
}
