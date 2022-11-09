package game.Objects;

import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

public class rightWall extends StaticBody {
    //creates a static body for the right side as restriction for the player to stay within
    private static final Shape rightWall = new BoxShape(0.5f,400);
    public rightWall(World w) {
        super(w, rightWall);
    }
}
