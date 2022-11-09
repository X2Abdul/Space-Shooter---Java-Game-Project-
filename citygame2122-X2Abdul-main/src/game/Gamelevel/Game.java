package game.Gamelevel;
import city.cs.engine.SoundClip;
import game.Controls.ShipController;
import game.Controls.MouseControl;
import game.Menu.Menu;
import game.Player.Ship;

import javax.swing.*;


public class Game {
    //Declare and initialise Variable.
    private Ship Spaceship;
    private Gamelevel currentLevel;
    private SpaceView view;
    private SoundClip gameMusic;
    private ShipController controller;
    private MouseControl mouse;
    private JFrame frame;
    private JPanel panel;
    private Menu menu;

    public Game(){
        // creating level 1 at the start of the game.
        currentLevel = new Level1(this);

        // View and Menu frames
        view = new SpaceView(currentLevel, 400,800,currentLevel.getSpaceShip());
        menu = new Menu(currentLevel, 400, 800, this);
        currentLevel.backgroundMusic().play();

        //mouse and keyboard Listeners and step listeners
        mouse = new MouseControl(view, currentLevel.getSpaceShip());
        view.addMouseListener(mouse);
        controller = new ShipController(currentLevel.getSpaceShip(), this,currentLevel);
        view.addKeyListener(controller);


        //creates Frame which the game will be played in
        frame = new JFrame("City Game");

        //adds menu frame at the start
        frame.add(menu);
        frame.setSize(400,800);




        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        //frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        currentLevel.start();
    }

    /**
     * Switches levels
     */
    public void nextLevel(){
        // Stops the current level and the music. then start the next level with its music
        if(currentLevel instanceof Level1){
            currentLevel.stop();
            currentLevel.backgroundMusic().stop();
            currentLevel = new Level2(this);
            currentLevel.backgroundMusic().play();
            view.setWorld(currentLevel);
            controller.updateShip(currentLevel.getSpaceShip());
            mouse.updateShip(currentLevel.getSpaceShip());
            view.updateShip(currentLevel.getSpaceShip(), currentLevel);
            currentLevel.start();
        }
        else if(currentLevel instanceof Level2){
            currentLevel.stop();
            currentLevel.backgroundMusic().stop();
            currentLevel = new Level3(this);
            currentLevel.backgroundMusic().play();
            view.setWorld(currentLevel);
            controller.updateShip(currentLevel.getSpaceShip());
            mouse.updateShip(currentLevel.getSpaceShip());
            view.updateShip(currentLevel.getSpaceShip(), currentLevel);
            currentLevel.start();

        }
        else if(currentLevel instanceof Level3){
            System.exit(0);
        }
    }

    /**
     * Stops the current level
     */
    public void stoplevel(){
        currentLevel.backgroundMusic().stop();
        currentLevel.stop();
    }

    /**
     * Plays the currentlevel
     */
    public void playlevel(){
        currentLevel.start();
        currentLevel.backgroundMusic().play();
    }
    /**
     * Restart the game
     */
    public void restart(){
        //stops the current level and loads level 1
        currentLevel.stop();
        currentLevel.backgroundMusic().stop();
        currentLevel = new Level1(this);
        currentLevel.backgroundMusic().play();
        view.setWorld(currentLevel);
        controller.updateShip(currentLevel.getSpaceShip());
        mouse.updateShip(currentLevel.getSpaceShip());
        view.updateShip(currentLevel.getSpaceShip(), currentLevel);
        currentLevel.start();
    }
    /**
     * Load the saved level
     * @param currentLevel
     */
    public void setLevel(Gamelevel currentLevel){
        // loads the level said in the file
        if(currentLevel instanceof Level1){
            currentLevel.stop();
            currentLevel.backgroundMusic().stop();
            currentLevel = new Level1(this);
            currentLevel.backgroundMusic().play();
            view.setWorld(currentLevel);
            controller.updateShip(currentLevel.getSpaceShip());
            mouse.updateShip(currentLevel.getSpaceShip());
            view.updateShip(currentLevel.getSpaceShip(), currentLevel);
            currentLevel.start();
        }
        else if(currentLevel instanceof Level2){
            currentLevel.stop();
            currentLevel.backgroundMusic().stop();
            currentLevel = new Level2(this);
            currentLevel.backgroundMusic().play();
            view.setWorld(currentLevel);
            controller.updateShip(currentLevel.getSpaceShip());
            mouse.updateShip(currentLevel.getSpaceShip());
            view.updateShip(currentLevel.getSpaceShip(), currentLevel);
            currentLevel.start();
        }
        else if(currentLevel instanceof Level3){
            currentLevel.stop();
            currentLevel.backgroundMusic().stop();
            currentLevel = new Level3(this);
            currentLevel.backgroundMusic().play();
            view.setWorld(currentLevel);
            controller.updateShip(currentLevel.getSpaceShip());
            mouse.updateShip(currentLevel.getSpaceShip());
            view.updateShip(currentLevel.getSpaceShip(), currentLevel);
            currentLevel.start();
        }
    }

    // removes the menu from the frame
    public void cutmenu(){
        frame.remove(menu);
        frame.repaint();
        frame.add(view);
        frame.validate();
    }

    // adds the menu to the frame
    public void addmenu(){
        frame.remove(view);
        frame.repaint();
        frame.add(menu);
        frame.validate();

    }

    // accessors
    public Ship getSpaceship() {
        return Spaceship;
    }
    public Gamelevel getCurrentLevel(){
        return currentLevel;
    }
    public JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        new Game();
    }




}
