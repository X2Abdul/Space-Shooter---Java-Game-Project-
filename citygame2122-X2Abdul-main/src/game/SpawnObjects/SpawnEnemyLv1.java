package game.SpawnObjects;

import city.cs.engine.World;
import game.Objects.Enemies;
import game.Gamelevel.Game;
import game.Gamelevel.Gamelevel;
import game.Player.Ship;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.random.RandomGenerator;

public class SpawnEnemyLv1 implements ActionListener {
    private World world;
    private Enemies enemies;
    private int count;
    private Timer y;
    private Ship Spaceship;
    private Gamelevel gamelevel;
    private Game game;



    private RandomGenerator random = new Random();


    public SpawnEnemyLv1(World world, Enemies enemies, Ship spaceship, Gamelevel gamelevel, Game game){
        this.gamelevel = gamelevel;
        this.enemies = enemies;
        this.Spaceship = spaceship;
        this.world = world;
        this.game = game;
        count = 0;
        y = new Timer(4000, this);
        y.setInitialDelay(10000);
        y.start();




    }
    //spawn enemies at a randon x and 25 y 50 times every 4 seconds with intial delay opf 10 seconds
    @Override
    public void actionPerformed(ActionEvent e) {
        enemies = new Enemies(world, Spaceship, gamelevel, game);
        enemies.setPosition(new Vec2((random.nextFloat() * 20) - 10, 25));
        count++;
        if(count == 50){
            y.stop();
        }

    }
}