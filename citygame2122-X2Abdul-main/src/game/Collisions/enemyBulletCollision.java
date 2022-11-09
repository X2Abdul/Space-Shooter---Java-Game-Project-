package game.Collisions;

import city.cs.engine.*;
import game.Player.Ship;

public class enemyBulletCollision implements CollisionListener, StepListener {
    //Declare variables
    private Ship spaceship;
    private AttachedImage explosion;
    private int counter;
    private boolean isstarted;

    public enemyBulletCollision(Ship spaceship){
        //initialse variables
        this.spaceship = spaceship;
        counter = 0;
        isstarted = false;

        //adding step listener
        spaceship.getWorld().addStepListener(this);

    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        //when enemy bullet collision with ship soundeeffect is play and explosion gif is played
        if(collisionEvent.getOtherBody() instanceof Ship){
            spaceship.explosion();
            collisionEvent.getReportingBody().destroy();
            explosion = spaceship.addImage(new BodyImage("data/Ship/explosion.gif",2));
            spaceship.setLives(spaceship.getLives()-1);
            isstarted = true;
        }
    }

    //this allow the explosion gif to be visible for certain period of time
    @Override
    public void preStep(StepEvent stepEvent) {
        if(isstarted){
            counter++;
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {
        if (counter == 20){
            spaceship.removeAttachedImage(explosion);
            isstarted = false;
            counter  = 0;
        }

    }
}
