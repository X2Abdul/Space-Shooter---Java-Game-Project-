package game.Collectable;

import city.cs.engine.*;
import game.Player.Ship;
import game.Collisions.magCollision;

public class mag extends DynamicBody {
    //creates a shap of a mag object and get image
    private static final Shape Magazine = new PolygonShape(-0.389f,-0.845f,
            0.897f,0.334f,
            0.384f,0.778f,
            -0.718f,0.359f,
            -0.961f,-0.243f);
    private static final BodyImage mag = new BodyImage("data/Collectables/mag.png", 1f);
    private Ship spaceship;
    public mag(World w, Ship spaceship) {
        //add image to the object and set attributes
        super(w, Magazine);
        this.spaceship = spaceship;
        addImage(mag);
        this.setGravityScale(0.2f);
        this.addCollisionListener(new magCollision(spaceship));
    }

}
