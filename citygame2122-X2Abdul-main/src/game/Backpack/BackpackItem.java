package game.Backpack;

import game.Player.Ship;

public abstract class BackpackItem {
    protected Ship spaceship;

    //Access to the ship
    public BackpackItem(Ship spaceship){
        this.spaceship = spaceship;
    }

    //abstract method to get a return value form each item/
    public abstract String getType();
    public abstract void operate();


}
