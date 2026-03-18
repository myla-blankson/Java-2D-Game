package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.Timer;
import javax.swing.JFrame;

//Starts the program
//Runs the game loop
//updates and rendering
// main game enty point


public class Game {

    //The World in which the bodies move and interact
    //private GameWorld gameWorld;
    private GameLevel level; //variable level is storing Gamelevel object

    // A graphical display of the world (a specialised JPanel)
    private GameView view;


    public Game() {

        // make the world

        //GameWorld gameWorld = new GameWorld(this); // creating game world
        level = new Level1(this); //Level1(this:game)
        //instead of gameWorld as we now are using levels instead of one gameWorld
        //this is the original and current level; level1
        view = new GameView(level, 600, 800); //make sure all parameters are recognised in GameView class
        view.setZoom(15);

        //register all events in main class always...

        PlayerController controller = new PlayerController(level.getPlayer());
        view.addKeyListener(controller); //registered key event to view (source)

//        registering key event
        view.addMouseListener(new GiveFocus(view));

        level.addStepListener(new Tracker(view, level.getPlayer()) {
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

    public void goToNextLevel() {
        level.stop(); //stop current level
        //get the player for the next level
        Player player = level.getPlayer();
        level = new Level2(this); //new level...
        level.setPlayer(player);  // Set the same player for the new level
        view.setWorld(level);
        view.setZoom(15);
        level.addStepListener(new Tracker(view, player));  // Keep tracking the player in the new level
        level.start();
    }

    //gameWorld now replaced with level
    public void restartLevel() {
        level.stop();  // Stop the current level
        Player player = level.getPlayer();  // Get the existing player
        player.setPosition(new Vec2(0, -10));  // Reset player position back to original
        player.resetScore();  // Reset player score

        // Reset coins
        for (Coin c : level.getCoins()) {
            c.destroy();  // Destroy all coins
        }
        level.createCoins(10);  // create new coins for the current level
        level.totalCoins = level.getCoins().size();  //total of coins = number of coins created

        // Reset level variables
        level.timeRemaining = 10; //change back to 60 after...
        level.collectedCoins = 0;
        level.gameOver = false;
        level.gameWon = false;

        view.setWorld(level);  // Set the view to the current level
        view.setZoom(15);      // Set the zoom for the level

        level.start();  // Restart the level
    }


        public static void main (String[]args){
            new Game();
        }
    } // I can only call methods for level that are defined in GameLevel not the Level subclasses because
    // level is storing GameLevel object -- we're looking at what is stored in GameLevel class, not in Level1 etc...

//perhaps, add sound later...
// add levels...
//add menu, sound, high-scoring, saving and loading state

//if(levelNumber == 1) level = new Level2(this);
//    else if(levelNumber == 2) level = new Level3(this);
