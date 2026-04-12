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
        createCoins(15);
        createBird(-8, -2f, -12f, -4f); //platform1
        createBird(8, 7f, 4f, 12f); //platform2
        createBird(20, -1f, 16f, 24f);//platform3
        createBird(-20, 4f, -24f, -16f);//platform4
        createBird(32, 6f, 28f, 36f);//platform5
        createCoins(10);
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
        //ground.addImage(new BodyImage("./data/ground.png", 1f));

        Shape platformShape = new BoxShape(2.5f, 0.5f); // creating default shape of platforms

        StaticBody platform1 = new StaticBody(this, platformShape); //creating a non-moving platform with this particular (box) shape
        platform1.setPosition(new Vec2(-8, -4f));
        platform1.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform2 = new StaticBody(this, platformShape);// another platform...
        platform2.setPosition(new Vec2(8, 5.5f));
        platform2.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(20, -3f));
        platform3.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform4 = new StaticBody(this, platformShape);
        platform4.setPosition(new Vec2(-20, 2f));
        platform4.addImage(new BodyImage("./data/platform.png", 1f));

        StaticBody platform5 = new StaticBody(this, platformShape);
        platform5.setPosition(new Vec2(32, 4f));
        platform5.addImage(new BodyImage("./data/platform.png", 1f));


        //player = new Player(this);
        player.setPosition(new Vec2(8, -10));
        PlayerCollisions pickup = new PlayerCollisions(player,this);
        player.addCollisionListener(pickup);

// create 5? coins, perhaps more coins as levels increase and a timer for player to collect as many within an amount of time



    }
    @Override // concrete
    public String getLevelName() {
        return "LEVEL 2";
    }
}

