package game.Backpack;

import game.Player.Ship;

public class Flash extends BackpackItem {
    public Flash(Ship spaceship) {
        super(spaceship);
    }

    @Override
    public String getType() {
        return "Flash";
    }

    @Override
    public void operate() {

    }
}
