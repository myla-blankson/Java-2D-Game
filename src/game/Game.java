package game;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;
import javax.swing.JFrame;

//Starts the program
//Runs the game loop
//updates and rendering
// main game enty point


public class Game {

    //The World in which the bodies move and interact
    private GameWorld world;

    // A graphical display of the world (a specialised JPanel)
    private GameView view;


    public Game() {

        // make the world

        GameWorld gameWorld = new GameWorld(); // creating game world
        UserView view = new UserView(gameWorld, 800, 600);

        PlayerController controller = new PlayerController(gameWorld.getPlayer());
        view.addKeyListener(controller); //registered key event to source

        // add the view to a frame (Java top level window)
        final JFrame frame = new JFrame("CoinHeist");
        frame.add(view);
        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        gameWorld.start();

    }


    public static void main(String[] args) {
        new Game();
    }
}
