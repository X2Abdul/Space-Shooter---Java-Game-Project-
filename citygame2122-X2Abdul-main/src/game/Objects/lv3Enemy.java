package game.Objects;

import city.cs.engine.*;
import game.Collisions.enemyBulletCollision;
import game.Gamelevel.Game;
import game.Player.Ship;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class lv3Enemy extends DynamicBody {
    // create lv3enemy object shape and get image
    private static final Shape l2enemy = new PolygonShape(-0.763f,0.888f, 0.757f,0.868f, 0.013f,-0.932f);
    private static final BodyImage enemy = new BodyImage("data/EnemiesandObtacles/lv2enemy.png", 4f);

    //declare varables
    private int count;
    private Game game;
    private Ship spaceship;

    // gets explo souneffect
    private static SoundClip explo;
    static {
        try {
            explo = new SoundClip("data/SoundClips/explo2.wav");

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }
    public lv3Enemy(World w, Game game, Ship spaceship) {
        //add image to the object and set its attributes
        super(w, l2enemy);
        this.spaceship = spaceship;
        addImage(enemy);
        this.game = game;
        this.setGravityScale(0);
        this.setLinearVelocity(new Vec2(5,0));
        count  = 6;
    }
    // make a bullet for the lv3 enemy and added collision listener
    public void shoot(){
        DynamicBody bullet = new DynamicBody(this.getWorld(), new CircleShape(1f));

        bullet.addImage(new BodyImage("data/Bullet/enemybullet.png", 1f));
        bullet.setPosition(new Vec2(this.getPosition().x, this.getPosition().y - 3));
        bullet.setLinearVelocity(new Vec2(spaceship.getPosition()));bullet.setGravityScale(1);
        bullet.addCollisionListener(new enemyBulletCollision(spaceship));
    }



    // plays explo and reposition after getting shot
    public void death(){
        explo.play();
        this.shoot();
        count--;
        if(count != 0){
            this.setPosition(new Vec2(0,18));
            this.setAngularVelocity(0);
            this.setLinearVelocity(new Vec2(-5,0));
        }
        else if(count == 0){
            this.destroy();
            if(game.getCurrentLevel().isComplete()){
                game.nextLevel();
            }
        }

    }

    //Accessors
    public int getCount(){ return count;}
    public void setCount(int count1){this.count = count1;}
}
