package game.Collectable;

import city.cs.engine.*;
import game.Player.Ship;
import game.Collisions.healthCollision;

public class health extends DynamicBody {
    //creates health object and load its image
    private static final Shape health = new PolygonShape(-0.389f,-0.845f,
            0.897f,0.334f,
            0.384f,0.778f,
            -0.718f,0.359f,
            -0.961f,-0.243f);
    private static final BodyImage healthpic = new BodyImage("data/Collectables/health.png", 2f);
    private Ship spaceship;

    public health(World w, Ship spaceship) {
        // add image to the object and set its attributes
        super(w, health);
        this.spaceship = spaceship;
        addImage(healthpic);
        this.setGravityScale(0.2f);

        //add collision listener to check when colliding with other objects
        this.addCollisionListener(new healthCollision(spaceship));



    }

}
