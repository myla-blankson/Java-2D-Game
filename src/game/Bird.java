package game;


import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Bird extends DynamicBody {
    private static final Shape birdShape = new BoxShape(1f, 0.5f); //fixtures...
    private static final BodyImage birdRight = new BodyImage("data/FlappyBirdImageRight.png", 2f);
    private static final BodyImage birdLeft = new BodyImage("data/FlappyBirdImageLeft.png", 2f);
    private float speed = 3f;

    public Bird(World world, float x, float y) {
        super(world, birdShape);
        setPosition(new Vec2(x, y));
        addImage(birdRight);
        setGravityScale(0); //stops it falling
        setLinearVelocity(new Vec2(speed, 0)); //starts moving right
    }

    public void reverse() {
        speed = -speed;
        setLinearVelocity(new Vec2(speed, 0));
        if (speed < 0) {
            removeAllImages();
            addImage(birdLeft);
        }else  {
            addImage(birdRight);
        }

        }

    public float getSpeed() {
        return speed;
    }
}
