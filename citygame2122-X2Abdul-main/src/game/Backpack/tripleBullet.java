package game.Backpack;


import game.Player.Ship;

public class tripleBullet extends BackpackItem {


    public tripleBullet(Ship spaceship) {
        super(spaceship);
    }

    //name of the item
    @Override
    public String getType() {
        return "Triple Bullet";
    }

    // to operate triple bullet
    @Override
    public void operate() {
        spaceship.tripleBullet();

    }
}
