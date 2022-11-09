package game.Menu;

import game.Gamelevel.Game;
import game.Gamelevel.Gamelevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *Creates menu buttons and set button bounds
 * Also Action Listener to each button
 *
 */

public class Menu extends  JPanel {

    //declare and name buttons
    JButton quit = new JButton("Quit");
    JButton play = new JButton("Play");
    JButton restart = new JButton("Restart");

    //Declare variables
    private Gamelevel currentlevel;
    private Game game;


    /**
     * Initialize the params
     * Calls the Button meathods to create buttons
     * @param currentlevel
     * @param width
     * @param height
     * @param game
     */
    public Menu(Gamelevel currentlevel, int width, int height, Game game) {
        // Initialize variables
        this.currentlevel = currentlevel;
        this.game = game;

        //layout null to use absolute positioning
        setLayout(null);


        //add Button from the meathods below
        addplayButton();
        addrestartButton();
        addquitButton();
    }

    /**
     * Adds the play button
     * Set bounds to button
     * Adds the action listener to the button to perform the action when clicked
     */
    public void addplayButton(){
        add(play);
        play.setBounds(150,200, 100, 50);
        //this action listener starts or resumes the game
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.cutmenu();
                game.playlevel();

            }
        });
    }

    /**
     * Adds the restart button
     * Set bounds to button
     * Adds the action listener to the button to perform the action when clicked
     */
    public void addrestartButton(){
        add(restart);
        restart.setBounds(150, 300, 100,50);
        restart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.cutmenu();
                game.restart();

            }
        });
    }

    /**
     * Adds the play button
     * Set bounds to button
     * Adds the action listener to the button to perform the action when clicked
     */
    public void addquitButton(){
        add(quit);
        quit.setBounds(150,400,100,50);
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
