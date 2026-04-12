package game;

import city.cs.engine.*;
import city.cs.engine.CollisionListener;

public class PlayerCollisions implements CollisionListener {
    private Player player;
    private GameLevel level;


    public PlayerCollisions (Player player, GameLevel level) {
        this.player = player;
        this.level = level;

    }// this class
    @Override
    public void collide (CollisionEvent e) {
        if (e.getOtherBody() instanceof Coin) {
            player.addScore(10);
            e.getOtherBody().destroy();
            level.collectCoins(); // changed to 'level' instead of 'gameWorld'
            System.out.println("You collected the coin!"+ "score: "+player.getScore());
        }
    }
}
