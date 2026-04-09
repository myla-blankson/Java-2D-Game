package game;

import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

//concrete class
public class Level2 extends GameLevel {
    public Level2(Game game) {
        super(game); // enables inheritance as child class calls parent constructor
        createCoins(10);
        createBird(-8, -2f, -12f, -4f); //platform1
        createBird(8, 7f, 4f, 12f); //platform2
        totalCoins = coins.size();
        timeRemaining = 45;

    }// must be declared abstract... or implement create() method

    @Override
    public void create() {

        //add all GameLevel features... platforms etc.
        //make the ground

        Shape shape = new BoxShape(50, 0.5f);
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


        //player = new Player(this);
        player.setPosition(new Vec2(8, -10));
        PlayerCollisions pickup = new PlayerCollisions(player,this);
        player.addCollisionListener(pickup);

// create 5? coins, perhaps more coins as levels increase and a timer for player to collect as many within an amount of time

        Coin coin1 = new Coin(this);
        coin1.setPosition(new Vec2(5, -5));
        coin1.addCollisionListener(new PlayerCollisions(player,this));
        coins.add(coin1);
        // Once the player comes in contact or overlaps with the coin, the listener is made aware
        // The listener object creates an instance where it will execute its defined collide method
        //(by adding 10 to the score and displaying it with a message)

        Coin coin2 = new Coin(this);
        coin2.setPosition(new Vec2(10, 3));
        coin2.addCollisionListener(new PlayerCollisions(player,this));
        coins.add(coin2);

        // Coin 3
        Coin coin3 = new Coin(this);
        coin3.setPosition(new Vec2(15, -2));
        coin3.addCollisionListener(new PlayerCollisions(player,this));
        coins.add(coin3);

    }
    @Override // concrete
    public String getLevelName() {
        return "LEVEL 2";
    }
}

