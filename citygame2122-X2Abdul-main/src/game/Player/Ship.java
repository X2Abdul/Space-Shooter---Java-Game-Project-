package game.Player;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import city.cs.engine.*;
import city.cs.engine.Shape;
import game.Animation.Shipanimation;
import game.Backpack.Backpack;
import game.Collisions.singleBulletCollision;
import game.Collisions.tripleBulletCollision;
import game.Controls.ShipController;
import game.Gamelevel.Game;
import game.Gamelevel.Gamelevel;
import game.Objects.lv3Enemy;
import game.SpawnObjects.SpawnAsteroidsLv1;
import game.SpawnObjects.spawnCollectable;
import org.jbox2d.common.Vec2;

/**
 * Creates a Walker Player
 */

public class Ship extends Walker {
    // create a ship shape and gets image
    private static final Shape SpaceShip = new PolygonShape(-0.02f,1.92f,
            1.31f,-0.57f,
            0.74f,-1.96f,
            -0.8f,-1.96f,
            -1.36f,-0.58f,
            -0.06f,1.94f);
    private static final BodyImage ship = new BodyImage("data/Ship/spaceshipdefault.png", 4f);
    private AttachedImage shipimage1;

    private BodyImage ship1 = new BodyImage("data/Ship/spaceship1.png",4);
    private BodyImage ship2 = new BodyImage("data/Ship/spaceship2.png",4);
    private BodyImage ship3 = new BodyImage("data/Ship/spaceship3.png",4);
    private BodyImage ship4 = new BodyImage("data/Ship/spaceship4.png",4);
    private BodyImage ship5 = new BodyImage("data/Ship/spaceship5.png",4);
    private BodyImage ship6 = new BodyImage("data/Ship/spaceship6.png",4);
    private BodyImage ship7 = new BodyImage("data/Ship/spaceship7.png",4);

    private BodyImage[] aniamtionimages = {ship, ship1, ship2, ship3, ship4,ship5,ship6,ship7};

    // Declare variables
    private int Lives;
    private int mag;
    private int Score;
    private Gamelevel gamelevel;
    private Backpack backpack;
    private Game game;
    private lv3Enemy lv2Enemy;
    private ShipController controller;
    private SpawnAsteroidsLv1 spawnAsteroidsLv1;
    private Shipanimation moving = new Shipanimation(this,1, ship1, ship2, ship3, ship4,ship5,ship6,ship7);


    //declare and fetch shooting souneffects
    private static SoundClip bulletshoot;
    static{
        try{
            bulletshoot = new SoundClip("data/SoundClips/laser9.mp3");

        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    private static SoundClip triplebulletsound;
    static{
        try{
            triplebulletsound = new SoundClip("data/SoundClips/triplebullet.wav");

        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    private static SoundClip explosion;
    static {
        try {
            explosion = new SoundClip("data/SoundClips/explo1.wav");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            //code in here will deal with any errors
            //that might occur while loading/playing sound
            System.out.println(e);
        }
    }

    /**
     * Constructor of Ship which initialize the param, fields and set ship's attributes
     * @param gamelevel
     * @param game
     * @param lv2Enemy
     * @param controller
     * @param spawnAsteroidsLv1
     */
    public Ship(Gamelevel gamelevel, Game game, lv3Enemy lv2Enemy, ShipController controller, SpawnAsteroidsLv1 spawnAsteroidsLv1) {
        super(gamelevel, SpaceShip);
        //add image to the object
        shipimage1 = addImage(ship);

        //shipmove = new Animation(shipanimation,10);

        //initialze the variables
        this.spawnAsteroidsLv1 = spawnAsteroidsLv1;
        this.game = game;
        this.controller = controller;
        this.gamelevel = gamelevel;
        this.lv2Enemy = lv2Enemy;
        backpack = new Backpack();
        this.setGravityScale(0);
        Lives = 5;
        mag = 15;
        Score = 0;

    }
    //start player animation

    /**
     * Calls start meathod from aniamtion
     */
    public void startanimation(){
        moving.start();
    }


    /**
     * Creates bullet object and image
     * Set bullet position, linear velocity and gravity
     * Destroy bullet when mag = 0
     * Adds bullet collision listener
     */
    //creates single objects to make a single bullet and add collision listener
    public void shooting(){
        DynamicBody bullet = new DynamicBody(this.getWorld(), new CircleShape(0.3f));

        bullet.addImage(new BodyImage("data/Bullet/bullet.png", 0.3f));
        if(mag > 0) {
            bullet.setPosition(new Vec2(this.getPosition().x , this.getPosition().y+3));
            bullet.setLinearVelocity(new Vec2(0, 10));
            bullet.setGravityScale(0);
            mag--;
        }
        //stop shooting when mag is 0
        else if  (mag == 0){
            bullet.destroy();
        }
        //spawn collectable mag when mag variable is 5
        if(mag == 5){
            spawnCollectable spawnmag= new spawnCollectable(this.getWorld(), this, spawnAsteroidsLv1);
            spawnmag.spawnmag();
        }

        bullet.addCollisionListener(new singleBulletCollision(this, gamelevel, game, lv2Enemy));
    }

    /**
     * Create 3 bullet Object with images and set position
     * Destroy when mag = 0
     * Adds collision listener to all 3 bullet objects
     * Spawn mag object when mag variable less than 5
     */
    //creates 3 objects to make a triple bullet and add collision listener
    public void tripleBullet(){
        //bullet1
        DynamicBody bullet1 = new DynamicBody(this.getWorld(), new CircleShape(0.3f));
        DynamicBody bullet2 = new DynamicBody(this.getWorld(), new CircleShape(0.3f));
        DynamicBody bullet3 = new DynamicBody(this.getWorld(), new CircleShape(0.3f));
        if(mag> 0) {
            bullet1.addImage(new BodyImage("data/Bullet/bullet.png", 0.3f));
            bullet1.setPosition(new Vec2(this.getPosition().x, this.getPosition().y + 3));
            bullet1.setLinearVelocity(new Vec2(0, 10));
            bullet1.setGravityScale(0);
            bullet1.addCollisionListener(new tripleBulletCollision(lv2Enemy, this, gamelevel, game));

            //bullet2

            bullet2.addImage(new BodyImage("data/Bullet/bullet.png", 0.3f));
            bullet2.setPosition(new Vec2(this.getPosition().x + 1, this.getPosition().y + 3));
            bullet2.setLinearVelocity(new Vec2(1, 10));
            bullet2.setGravityScale(0);
            bullet2.addCollisionListener(new tripleBulletCollision(lv2Enemy, this, gamelevel, game));

            // bullet3

            bullet3.addImage(new BodyImage("data/Bullet/bullet.png", 0.3f));
            bullet3.setPosition(new Vec2(this.getPosition().x - 1, this.getPosition().y + 3));
            bullet3.setLinearVelocity(new Vec2(-1, 10));
            bullet3.setGravityScale(0);
            bullet3.addCollisionListener(new tripleBulletCollision(lv2Enemy, this, gamelevel, game));

            mag -= 3;

        }
        else if (mag <= 0){
            bullet1.destroy();
            bullet2.destroy();
            bullet3.destroy();
        }
        if(mag <= 5){
            spawnCollectable spawnmag= new spawnCollectable(this.getWorld(), this, spawnAsteroidsLv1);
            spawnmag.spawnmag();
        }


    }

    /**
     * Plays bullet SoundClip
     */
    //play soundeffects
    public void shootsound(){
        bulletshoot.play();
    }

    /**
     * Plays triplebullet SoundClip
     */
    public void triplebulletsound(){
        triplebulletsound.play();
    }

    /**
     * Plays explosion SoundClip
     */
    public void explosion(){
        explosion.play();
    }

    // Accessors
    /**
     * Access to the backpack
     * @return backpack
     */
     // get backpack
    public Backpack getBackpack(){
        return backpack;
    }

    /**
     * Access to explosion Sounclip
     * @return
     */
    public SoundClip getExplosion(){
        return explosion;
    }

    /**
     * Access to Lives
     * @return
     */

    public int getLives(){
        return Lives;
    }

    /**
     * Set value to Lives
     * @param Lives
     */
    public void setLives(int Lives){
        this.Lives = Lives;
    }

    /**
     * Access to Mag
     * @return
     */
    public int getMag(){
        return mag;
    }

    /**
     * Set value to Mag
     * @param mag1
     */
    public void setMag(int mag1){
        this.mag = mag1;
    }

    /**
     * Access to Score
     * @return
     */
    public int getScore(){
        return Score;
    }

    /**
     * Set value to Score
     * @param score
     */
    public void setScore(int score){
        this.Score = score;
    }

    public AttachedImage getShipimage1() {
        return shipimage1;
    }
    public void setShipimage1(AttachedImage shipimage1){
        this.shipimage1 = shipimage1;
    }
}
