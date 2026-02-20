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


    public Game(){

        GameWorld gameWorld = new GameWorld(); // creating game world
        UserView view = new UserView(gameWorld, 800, 600);

    }



    public static void main(String[] args) {
        new Game();
    }
}
