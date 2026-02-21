package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


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

// create 5? coins, perhaps more coins as levels increase and a time for player to collect as many within an amount of time
        //coin1 = new Coin(this);
        //coin1.setPosition(new(Vec2()))





    }


    public Player getPlayer() {
        return player;
    }
}
