package game;

import city.cs.engine.*;
import city.cs.engine.CollisionListener;

public class PlayerCollisions implements CollisionListener {
    private Player player;
    private GameWorld gameWorld;


    public PlayerCollisions (Player player, GameWorld gameWorld) {
        this.player = player;
        this.gameWorld = gameWorld;

    }// this class
    @Override
    public void collide (CollisionEvent e) {
        if (e.getOtherBody() instanceof Coin) {
            player.addScore(10);
            e.getOtherBody().destroy();
            gameWorld.CollectCoins();
            System.out.println("You collected the coin!"+ "score:"+player.getScore());
            //...
        }
    }
}
