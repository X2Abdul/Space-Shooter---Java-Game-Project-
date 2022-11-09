package game.Backpack;

import game.Player.Ship;

public class singleBullet extends BackpackItem {
    public singleBullet(Ship spaceship) {
        super(spaceship);
    }

    @Override
    public String getType() {
        return "Single Bullet";
    }

    //to operate this item
    @Override
    public void operate() {
        spaceship.shooting();
    }
}
