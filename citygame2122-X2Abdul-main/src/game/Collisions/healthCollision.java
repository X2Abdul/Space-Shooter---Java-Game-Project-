package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Player.Ship;

public class healthCollision implements CollisionListener {
    private Ship spaceship;
    public healthCollision(Ship spaceship){
        this.spaceship = spaceship;
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        // destroys the health object and increments 2 to the ship's lives
        if(collisionEvent.getOtherBody() instanceof Ship){
            collisionEvent.getReportingBody().destroy();
            spaceship.setLives(spaceship.getLives()+2);
        }
    }
}
