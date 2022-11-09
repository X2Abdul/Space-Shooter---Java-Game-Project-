package game.Collisions;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import game.Objects.lv3Enemy;
import org.jbox2d.common.Vec2;

public class rightWallCollision implements CollisionListener {
    private lv3Enemy lv2Enemy;

    public rightWallCollision(lv3Enemy lv2Enemy){
        this.lv2Enemy = lv2Enemy;
    }
    @Override
    public void collide(CollisionEvent collisionEvent) {
        //allows the lv3enemy to bounce of the wall to move to the opposite side
        if(collisionEvent.getOtherBody() instanceof lv3Enemy){
            lv2Enemy.setLinearVelocity(new Vec2(-5,0));
            lv2Enemy.setAngularVelocity(0);
        }

    }
}
