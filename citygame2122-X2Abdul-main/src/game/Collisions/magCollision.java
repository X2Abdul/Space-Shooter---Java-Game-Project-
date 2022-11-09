package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Player.Ship;

public class magCollision implements CollisionListener {
    private Ship spaceship;
    public magCollision(Ship spaceship){
        this.spaceship = spaceship;
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        //when collision with ship add 20 to mag variable and deatroy mag object
        if(collisionEvent.getOtherBody() instanceof Ship){
            collisionEvent.getReportingBody().destroy();
            spaceship.setMag(spaceship.getMag()+20);
        }
    }
}
