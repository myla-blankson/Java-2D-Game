package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class GameWorld extends World{

    public GameWorld() {


        // creates

        //make the ground
        Shape shape = new BoxShape(11, 0.5f); // shape is
        StaticBody ground = new StaticBody(this, shape);
        ground.setPosition(new Vec2(0f, -11.5f));
        ground.addImage(new BodyImage("./data/ground.png", 1f));

        Shape platformShape = new BoxShape(2.5f, 0.5f);
        StaticBody platform = new StaticBody(this, platformShape); //creating a non-moving platform with this particular (box) shape

        StaticBody platform2 = new StaticBody(this, platformShape);// another platform


// create 5? coins, perhaps more coins as levels increase and a time for player to collect as many within an amount of time


        // create clouds, trees in background?


    }



}
