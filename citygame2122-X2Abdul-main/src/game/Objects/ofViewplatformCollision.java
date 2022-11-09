package game.Objects;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Player.Ship;
import org.jbox2d.common.Vec2;

public class ofViewplatformCollision implements CollisionListener {
    private Ship spaceship;

    public ofViewplatformCollision(Ship spaceship){
        this.spaceship = spaceship;
    }

    //this collision listener brings back the player to the view and destory the asteroid and enemy object
    @Override
    public void collide(CollisionEvent collisionEvent) {
        if(collisionEvent.getOtherBody() instanceof Ship){
            spaceship.setPosition(new Vec2(0,-15));
        }

        else if(collisionEvent.getOtherBody() instanceof Asteroids){
            collisionEvent.getOtherBody().destroy();
        }

        else if(collisionEvent.getOtherBody() instanceof Enemies){
            collisionEvent.getOtherBody().destroy();
        }

    }
}
