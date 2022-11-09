package game.Animation;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import game.Player.Ship;

/**
 * Takes in body images and put them in an array to go through the images to create an animation
 */
public class Shipanimation {
//declare and initialize fields
    private int count = 0;
    private int speed;
    private int frames;
    private int index = 0;
    private Ship s;


// Declares a body image and body image array
    private BodyImage[] images;
    private BodyImage currentimage;

    /**
     * Constructor add the take bodyimage and adds it to the array to cycle though to create an animation
     * @param s
     * @param speed
     * @param args
     */

    public Shipanimation(Ship s, int speed, BodyImage... args) {
        this.s = s;
        this.speed = speed;
        images = new BodyImage[args.length];
        for (int i = 0; i < args.length; i++) {
            images[i] = args[i];
        }
        frames = args.length;

    }

    /**
     * increses the index by 1 and call nextFrame
     */
    public void start() {
        index++;
        if(index > speed){
            index = 0;
            nextFrame();
        }
    }

    /**
     * Cycle through Bodyimage array
     * Adds the images to the player
     */
    public void nextFrame(){
        for(int i = 0; i < frames; i++){
            if(count == i){
                currentimage = images[i];
            }
            AttachedImage a = s.addImage(currentimage);
            s.setShipimage1(a);
        }
        count++;
        if(count > frames){
            count = 0;
        }
    }

    /**
     * Stop the animation
     */
    public void stop() {
        currentimage = images[0];
    }
//Accessors

    /**
     * get current image
     * @return
     */
    public BodyImage getCurrentimage() {
        return currentimage;
    }
}
