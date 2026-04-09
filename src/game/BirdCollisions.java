package game;

import city.cs.engine.CollisionListener;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class BirdCollisions implements CollisionListener {
    private  Bird bird;
    private GameLevel level;
    private float rightBound ;
    private float leftBound;


    public BirdCollisions(Bird bird,  GameLevel level, float rightBound, float leftBound) {
        this.bird = bird;
        this.level = level;

    }
    @Override
    public void collide(CollisionEvent e){
        if (e.getOtherBody() instanceof Player){
            level.loseLife();
            bird.setLinearVelocity(new Vec2(bird.getSpeed(), 0));
        }

    }

}
