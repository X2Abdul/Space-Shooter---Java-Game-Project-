package game.Gamelevel;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Animation.Shipanimation;
import game.Collisions.Ship_Encounter;
import game.Controls.ShipController;
import game.Objects.*;
import game.Player.Ship;
import game.SpawnObjects.SpawnAsteroidsLv1;
import game.SpawnObjects.SpawnEnemyLv1;
import org.jbox2d.common.Vec2;


import java.awt.*;
import java.util.Random;

import java.util.random.RandomGenerator;

public abstract class Gamelevel extends World  {

    // declare and initialise Variables
    private Ship SpaceShip;
    private Enemies enemies;
    private Asteroids Obstacle_Asteroid;
    private RandomGenerator random = new Random();
    private int asteroid_yaxis = 0;
    private int enemy_yaxis = 0;
    private SpaceView view;
    private SpawnAsteroidsLv1 spawnAsteroids;
    private SpawnEnemyLv1 spawnEnemy;
    private Game game;
    private lv3Enemy lv2Enemy;
    private ShipController controller;
    private SpawnAsteroidsLv1 spawnAsteroidsLv1;
    private Shipanimation animation;


    public Gamelevel(Game game){
        this.game = game;

        //add the ship(Player) object
        SpaceShip = new Ship(this, game, lv2Enemy, controller, spawnAsteroidsLv1);

        // ship (Player) collisionListener
        Ship_Encounter destroy = new Ship_Encounter(SpaceShip, Obstacle_Asteroid, SpaceShip.getWorld(), enemies, lv2Enemy);
        SpaceShip.addCollisionListener(destroy);

        //adds a platform outside the userview to repositionplayer in the view if the player fall of the view
        Shape platform = new BoxShape(10f, 0.5f);
        StaticBody ground = new StaticBody(this, platform);
        ground.setPosition(new Vec2(0f, -30f));
        ground.addCollisionListener(new ofViewplatformCollision(SpaceShip));

    }







    // absatact meathod which require a return value from each level such as music for each level.
    public abstract boolean isComplete();
    public abstract SoundClip backgroundMusic();
    public abstract Image backgroundImage();
    public abstract String Getlevel();

    //Accessors
    public Ship getSpaceShip(){
        return SpaceShip;
    }

    public Enemies getEnemies() {
        return enemies;
    }
    public Game getGame() {
        return game;
    }

    public Asteroids getObstacle_Asteroid() {
        return Obstacle_Asteroid;
    }

    public SpawnAsteroidsLv1 getSpawnAsteroids() {
        return spawnAsteroids;
    }

    public SpawnEnemyLv1 getSpawnEnemy() {
        return spawnEnemy;
    }

    public Shipanimation getAnimation() {
        return animation;
    }
}
