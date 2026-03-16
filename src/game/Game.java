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
    private GameLevel level;

    // A graphical display of the world (a specialised JPanel)
    private GameView view;



    public Game() {

        // make the world

        //GameWorld gameWorld = new GameWorld(this); // creating game world
        level = new Level1(this);
        //instead of gameWorld as we now are using levels instead of one gameWorld
        //this is the original level; level1
        view = new GameView(level,600, 800); //make sure all parameters are recognised in GameView class
        view.setZoom(15);

        PlayerController controller = new PlayerController(level.getPlayer());
        view.addKeyListener(controller); //registered key event to view (source)

//        registering key event
        view.addMouseListener(new GiveFocus(view));

        level.addStepListener(new Tracker(view, level.getPlayer()) {});


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

        //instead of gameWorld, change to level as we now have more than one gameWorld due to levels
        level.start();





    }

    public void goToNextLevel(){
        level.stop();
        level = new Level2(this); // cannot instantiate abstract classes so we created Level1 and Level1 objects
        view.setWorld(level);
        level.start();

    }
    //gameWorld now replaced with level
    public void restartLevel(){
        level.stop();
        level = new Level1(this); //
        view.setWorld(level);
        level.start();
    }




    public static void main(String[] args) {
        new Game();
    }
}
//perhaps, add sound later...
// add levels...
