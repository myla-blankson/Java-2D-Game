package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import city.cs.engine.Body;



public class GameWorld extends World{

    private Player player;

    public GameWorld() {


        // creates

        //make the ground
        Shape shape = new BoxShape(22, 0.5f); // shape is
        StaticBody ground = new StaticBody(this, shape);
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

// create 5? coins, perhaps more coins as levels increase and a time for player to collect as many within an amount of time
        //coin1 = new Coin(this);
        //coin1.setPosition(new(Vec2()))

        Coin coin1 = new Coin(this);
        coin1.setPosition(new Vec2(5, -5));
        coin1.addCollisionListener(new PlayerCollisions(player));
        // Once the player comes in contact or overlaps with the coin, the listener is made aware.
        // The listener object creates an instance where it will execute its defined collide method
        //(by adding 10 to the score and displaying it with a message)

        Coin coin2 = new Coin(this);
        coin2.setPosition(new Vec2(10, 3));
        coin2.addCollisionListener(new PlayerCollisions(player));





    }


    public Player getPlayer() {
        return player;
    }

}
