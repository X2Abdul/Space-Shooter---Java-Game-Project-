package game.Controls;

import city.cs.engine.AttachedImage;
import city.cs.engine.BodyImage;
import game.Gamelevel.Game;
import game.Gamelevel.Gamelevel;
import game.saveload.SaveLoad;
import game.Player.Ship;
import org.jbox2d.common.Vec2;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;



public class ShipController implements KeyListener {
    //declare variables
    private static final Float flyingSpeed = 7f;

    private Ship SpaceShip;
    private AttachedImage enginefire;
    private Game game;
    private Gamelevel gamelevel;





    public ShipController(Ship SpaceShip, Game game, Gamelevel gamelevel){
        //initialize variables
        this.SpaceShip = SpaceShip;

        this.game = game;
        this.gamelevel = gamelevel;
    }




    @Override
    public void keyTyped(KeyEvent e) {

    }

    //actions performed when key is pressed
    @Override
    public void keyPressed(KeyEvent e) {
        int Key = e.getKeyCode();

        //move left when A is pressed
        if (Key == KeyEvent.VK_A) {
            SpaceShip.startWalking(-flyingSpeed);
            //Start animation
            SpaceShip.startanimation();
        }

        //move right when D is pressed
        else if (Key == KeyEvent.VK_D) {
            SpaceShip.startWalking(flyingSpeed);
            //Start animation
            SpaceShip.startanimation();

        }

        //move up when W is pressed
        else if (Key == KeyEvent.VK_W) {
            SpaceShip.setLinearVelocity(new Vec2(0, 7));
            //Start animation
            SpaceShip.startanimation();
            enginefire = SpaceShip.addImage(new BodyImage("data/Ship/enginefire.png", 2f));
            enginefire.setOffset(new Vec2(0, -3));
        }

        //move down when S is pressed
        else if (Key == KeyEvent.VK_S) {
            SpaceShip.setLinearVelocity(new Vec2(0, -7));
            //Start animation
            SpaceShip.startanimation();
        }

        //toggle through items by pressing the F key
        else if(Key == KeyEvent.VK_F){
            SpaceShip.getBackpack().toggle();
        }

        //press ESCAPE to enter menu
        else if(Key == KeyEvent.VK_ESCAPE){

            game.stoplevel();
            game.addmenu();

        }
        //load level
        if(Key == KeyEvent.VK_L){
            try {
                SaveLoad.load("data/level.txt",game);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            game.setLevel(gamelevel);
        }

        //save level
        else if(Key == KeyEvent.VK_G){
            try {
                SaveLoad.save(gamelevel,"data/level.txt");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            game.setLevel(gamelevel);

        }
    }
    //actions performed when key is realeased
    @Override
    public void keyReleased(KeyEvent e) {
        int Key = e.getKeyCode();

        //stop moving
        if (Key == KeyEvent.VK_A) {
            SpaceShip.stopWalking();

        }
        else if (Key == KeyEvent.VK_D) {
            SpaceShip.stopWalking();

        }
        // remove attached image
        else if (Key == KeyEvent.VK_W){
            SpaceShip.removeAttachedImage(enginefire);

        }


    }
    //update ship to start the next level
    public void updateShip (Ship spaceShip){
        this.SpaceShip = spaceShip;

    }

    //Accessors
    public Float getFlyingSpeed() {
        return flyingSpeed;
    }

}
