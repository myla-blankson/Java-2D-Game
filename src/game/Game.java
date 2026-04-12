package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.Timer;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

//Starts the program
//Runs the game loop
//updates and rendering
// main game enty point


public class Game {

    //The World in which the bodies move and interact
    private GameLevel level; //variable level is storing GameLevel object

    // A graphical display of the world (a specialised JPanel)
    private GameView view;
    private PlayerController controller;
    boolean gameStarted = false;
    boolean paused = false;



    public Game() {

        // make the world
        level = new Level1(this); //Level1(this:game)
        //this is the original and current level; level1
        view = new GameView(level, 600, 800);
        view.setZoom(15);

        //register all events in main class always...

        controller = new PlayerController(level.getPlayer(), this);
        view.addKeyListener(controller); //registered key event to view (source)

//        registering key events
        view.addMouseListener(new GiveFocus(view));

        level.addStepListener(new Tracker(view, level.getPlayer()) {
        });

        view.addMouseListener(new MouseAdapter() { // before the game starts, screen must be clicked
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!gameStarted) {
                    startGame();
                    level.startTimer();
                }
            }
        });


        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("Coin Snatcher");
        frame.add(view); //adds view (type GameView which inherited from UserView class) to frame
        // when the x button is pressed, application terminates
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // Make the frame visible
        frame.setVisible(true);

        //instead of gameWorld, change to level as we now have more than one "gameWorld" due to levels
        level.start();
    }
    public boolean isGameStarted(){
        return gameStarted;
    }

    public void startGame(){
        gameStarted = true;
    }
    public void Pause(){
        paused = !paused; //does the opposite
        if (paused) {
            level.stop();
            level.stopLevel();
        }else{
            level.start();
            level.startTimer();
        }
    }



    public void goToNextLevel() {
        System.out.println("Yes, lets go to next level");
        if (level instanceof Level1) {
            level.stopLevel(); //stop current level
            level = new Level2(this); //new level...
        } else if (level instanceof Level2) {
            level.stopLevel();
            level = new Level3(this);
        } else {
            return;
        }
        view.setWorld(level);
        view.setLevel(level);
        controller.updatePlayer(level.getPlayer());
        view.setZoom(15);
        level.addStepListener(new Tracker(view, level.getPlayer()));  // Keep tracking the player in the new level
        level.start();
        level.startTimer();
    }


    //gameWorld now replaced with level
    public void restartLevel() {
        level.stopLevel();
        level = new Level1(this);
        view.setWorld(level);  // Set the view to the current level
        view.setLevel(level); // makes sure level reference is updated
        view.setZoom(15);
        level.addStepListener(new Tracker(view, level.getPlayer()) {});
        controller.updatePlayer(level.getPlayer());
        level.start();  // Restart the level
        level.startTimer();
    }


        public static void main (String[]args){
            new Game();
        }
    } // I can only call methods for level that are defined in GameLevel not the Level subclasses because
    // level is storing GameLevel object -- we're looking at what is stored in GameLevel class, not in Level1 etc...





