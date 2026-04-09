package game;
import city.cs.engine.BodyImage;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;
import javax.swing.*;

public class Level3 extends GameLevel {
    public Level3(Game game) {
        super(game);
        createBird(-8, -2f, -12f, -4f); //platform1
        createBird(8, 7f, 4f, 12f); //platform2
        createCoins(15);
        totalCoins = coins.size();
        timeRemaining = 45;

    }

    @Override
    public void create() {
        //add all GameWorld features... platforms etc.
        //make the ground

        Shape shape = new BoxShape(200, 0.5f);
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



        player.setPosition(new Vec2(-8, 10));
        PlayerCollisions pickup = new PlayerCollisions(player, this);
        player.addCollisionListener(pickup);
    }
    @Override
    public String getLevelName(){
        return "LEVEL 3";
    }


}

