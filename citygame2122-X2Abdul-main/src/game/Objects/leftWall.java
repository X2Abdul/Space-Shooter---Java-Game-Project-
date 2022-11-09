package game.Objects;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

public class leftWall extends StaticBody {
    //creates a static body for the left side as restriction for the player to stay within
    private static final Shape leftWall = new BoxShape(0.5f,400);
    public leftWall(World w) {
        super(w, leftWall);
    }
}
