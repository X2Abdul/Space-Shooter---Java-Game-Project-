package game.Collisions;

import city.cs.engine.*;
import game.Objects.Asteroids;
import game.Objects.Enemies;
import game.Player.Ship;
import game.Objects.lv3Enemy;
import org.jbox2d.common.Vec2;

public class Ship_Encounter implements CollisionListener, StepListener {
    //Declare variables
    private Ship SpaceShip;
    private int counter;
    private boolean isstarted;
    private AttachedImage explosion;
    private Asteroids Obstacle_Asteroid;
    private World world;
    private Enemies enemies;
    private lv3Enemy lv2Enemy;


    public Ship_Encounter(Ship ship, Asteroids Obstacle_Asteroid, World world, Enemies enemy, lv3Enemy lv2Enemy){
        //Intialize variables
        this.SpaceShip = ship;
        counter = 0;
        isstarted = false;
        ship.getWorld().addStepListener(this);
        this.Obstacle_Asteroid = Obstacle_Asteroid;
        this.world = world;
        this.enemies = enemy;
        this.lv2Enemy = lv2Enemy;

    }



    @Override
    public void collide(CollisionEvent e) {
        //Collsion between asteroids and the player
        if(e.getOtherBody() instanceof Asteroids){
            SpaceShip.explosion();
            SpaceShip.setLives(SpaceShip.getLives()-1);
            explosion = SpaceShip.addImage(new BodyImage("data/Ship/explosion.gif",2));
            e.getOtherBody().destroy();
            isstarted = true;
            if(SpaceShip.getLives()== 0){
                 SpaceShip.destroy();
                world.stop();
            }

        }
        //Collsion between enemy and the player
        else if (e.getOtherBody() instanceof Enemies){
            SpaceShip.explosion();
            SpaceShip.setLives(SpaceShip.getLives()-2);
            explosion= SpaceShip.addImage(new BodyImage("data/Ship/explosion.gif",2));
            e.getOtherBody().destroy();
            isstarted = true;
            if(SpaceShip.getLives()== 0){
                SpaceShip.destroy();
                world.stop();
            }
        }
        //Collision between lv3enemy and the payer
        else if( e.getOtherBody() instanceof lv3Enemy){
            SpaceShip.explosion();
            SpaceShip.setLives(SpaceShip.getLives()-2);
            explosion= SpaceShip.addImage(new BodyImage("data/Ship/explosion.gif",2));
            SpaceShip.setPosition(new Vec2(0,-15));
            e.getOtherBody().setPosition(new Vec2(0,18));
            ((lv3Enemy) e.getOtherBody()).setAngularVelocity(0);
            ((lv3Enemy) e.getOtherBody()).setLinearVelocity(new Vec2(-5,0));
            isstarted = true;


        }




    }
//steop listener to difplay explosion for smal amount of time and then remove
    @Override
    public void preStep(StepEvent stepEvent) {
        if(isstarted){
            counter++;
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        if (counter == 20){
            SpaceShip.removeAttachedImage(explosion);
            isstarted = false;
            counter  = 0;
        }

    }
}
