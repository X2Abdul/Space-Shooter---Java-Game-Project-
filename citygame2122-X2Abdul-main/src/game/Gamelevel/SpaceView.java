package game.Gamelevel;

import city .cs.engine.UserView;
import game.Player.Ship;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SpaceView extends UserView implements KeyListener {
    //Declare variables

    private Ship Spaceship;
    private Gamelevel currentlevel;

    public SpaceView(Gamelevel currentlevel, int width, int height, Ship s) {
        // Initialize variables
        super(currentlevel, width, height);
        this.Spaceship = s;
        this.currentlevel = currentlevel;
    }
    protected void paintBackground(Graphics2D g){
        //draws a background for each level by taking the value form the abstract meathod
        g.drawImage(currentlevel.backgroundImage(),0,0,this);
    }


    protected void paintForeground (Graphics2D g){
        // paints lives, mag and score on top of the screen
        Font font0 = new Font("arial", Font.BOLD, 20);

        g.setFont(font0);
        g.setColor(Color.WHITE);
        g.drawString("Lives: " + Spaceship.getLives(), 20,20);
        g.drawString("Mag: " + Spaceship.getMag(), 20, 40);
        g.drawString("Score: " + Spaceship.getScore(),20, 60);

        //paint you lose when lives is 0
         if(Spaceship.getLives() <= 0){
            Font font2 = new Font ("arial", Font.BOLD, 50);
            g.setFont(font2);
            g.setColor(Color.CYAN);
            g.drawString("You Lose", 100, 400);
            currentlevel.stop();
            System.exit(0);

        }
    }

    //update ship at the start of each level
    public void updateShip (Ship spaceShip, Gamelevel currentlevel){
        this.Spaceship = spaceShip;
        this.currentlevel = currentlevel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
