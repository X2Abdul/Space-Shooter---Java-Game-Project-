package game.Controls;

import game.Player.Ship;
import game.Gamelevel.SpaceView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseControl implements MouseListener {
    private SpaceView view;
    private Ship Spaceship;



    public MouseControl(SpaceView view, Ship Spaceship) {
        this.view = view;
        this.Spaceship = Spaceship;




    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //play shootsound when single bullet is equipped
        if(Spaceship.getBackpack().getCurrentItem().getType() == "Single Bullet" & Spaceship.getMag() > 0){
            Spaceship.shootsound();
        }

        //play triplebulletsound when triple bullet is equipped
        else if(Spaceship.getBackpack().getCurrentItem().getType() == "Triple Bullet" & Spaceship.getMag() > 0){
            Spaceship.triplebulletsound();
        }

        //to use the item
        Spaceship.getBackpack().getCurrentItem().operate();





    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //check when the mouse is in the view
        view.requestFocus();

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    // update ship at the start of each level
    public void updateShip (Ship spaceShip){
        this.Spaceship = spaceShip;
    }
}
