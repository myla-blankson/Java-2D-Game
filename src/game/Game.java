package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;

//Starts the program
//Runs the game loop
//updates and rendering
// main game enty point


public class Game {

    //The World in which the bodies move and interact
    private GameWorld gameWorld;

    // A graphical display of the world (a specialised JPanel)
    private GameView view;



    public Game() {

        // make the world

        GameWorld gameWorld = new GameWorld(); // creating game world
        view = new GameView(gameWorld,600, 800); //make sure all parameters are recognised in GameView class
        view.setZoom(15);

        PlayerController controller = new PlayerController(gameWorld.getPlayer());
        view.addKeyListener(controller); //registered key event to view (source)

//        registering key event
        view.addMouseListener(new GiveFocus(view));

        gameWorld.addStepListener(new Tracker(view, gameWorld.getPlayer()) {});

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


        gameWorld.start();



    }







    public static void main(String[] args) {
        new Game();
    }
}
//perhaps, add sound later...
// add levels...
