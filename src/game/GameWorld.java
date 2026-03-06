package game;

import city.cs.engine.*;
import org.jbox2d.common.Timer;
import org.jbox2d.common.Vec2;
import city.cs.engine.Body;



public class GameWorld extends World {

    private Player player;
    private boolean gameWon = false;
    private boolean gameOver = false;
    private int timeRemaining = 60;
    private Timer timer;


    public GameWorld() {


        //make the ground
        Shape shape = new BoxShape(22, 0.5f);
        StaticBody ground = new StaticBody(this, shape); //enabling fixtures...
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.addImage(new BodyImage("./data/ground.png", 1f));

        Shape platformShape = new BoxShape(2.5f, 0.5f); // creating default shape of platforms

        StaticBody platform1 = new StaticBody(this, platformShape); //creating a non-moving platform with this particular (box) shape
        platform1.setPosition(new Vec2(-8, -4f));
        platform1.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform2 = new StaticBody(this, platformShape);// another platform...
        platform2.setPosition(new Vec2(8, 5.5f));
        platform2.addImage(new BodyImage("./data/platform.png", 1f));


        player = new Player(this);
        player.setPosition(new Vec2(8, -10));
        PlayerCollisions pickup = new PlayerCollisions(player);
        player.addCollisionListener(pickup);

// create 5? coins, perhaps more coins as levels increase and a timer for player to collect as many within an amount of time

        Coin coin1 = new Coin(this);
        coin1.setPosition(new Vec2(5, -5));
        coin1.addCollisionListener(new PlayerCollisions(player));
        // Once the player comes in contact or overlaps with the coin, the listener is made aware
        // The listener object creates an instance where it will execute its defined collide method
        //(by adding 10 to the score and displaying it with a message)

        Coin coin2 = new Coin(this);
        coin2.setPosition(new Vec2(10, 3));
        coin2.addCollisionListener(new PlayerCollisions(player));

        // Coin 3
        Coin coin3 = new Coin(this);
        coin3.setPosition(new Vec2(15, -2));
        coin3.addCollisionListener(new PlayerCollisions(player));

        // Coin 4
        Coin coin4 = new Coin(this);
        coin4.setPosition(new Vec2(-6, 3));
        coin4.addCollisionListener(new PlayerCollisions(player));

        // Coin 5
        Coin coin5 = new Coin(this);
        coin5.setPosition(new Vec2(-10, -7));
        coin5.addCollisionListener(new PlayerCollisions(player));

        // Coin 6
        Coin coin6 = new Coin(this);
        coin6.setPosition(new Vec2(0, 7));
        coin6.addCollisionListener(new PlayerCollisions(player));

        // Coin 7
        Coin coin7 = new Coin(this);
        coin7.setPosition(new Vec2(20, -6));
        coin7.addCollisionListener(new PlayerCollisions(player));

        // Coin 8
        Coin coin8 = new Coin(this);
        coin8.setPosition(new Vec2(18, 5));
        coin8.addCollisionListener(new PlayerCollisions(player));

        // Coin 9
        Coin coin9 = new Coin(this);
        coin9.setPosition(new Vec2(-15, -3));
        coin9.addCollisionListener(new PlayerCollisions(player));

        // Coin 10
        Coin coin10 = new Coin(this);
        coin10.setPosition(new Vec2(-12, 6));
        coin10.addCollisionListener(new PlayerCollisions(player));


        // could create an array storing multiple coins in random areas...


    }


    public Player getPlayer() {
        return player;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public boolean isGameWon() {
            return gameWon;
        }




    }