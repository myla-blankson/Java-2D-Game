package game;

import city.cs.engine.*;
import city.cs.engine.CollisionListener;

public class PlayerCollisions implements CollisionListener {
    private Player player;
    public PlayerCollisions (Player player) {
        this.player = player;
    }
    @Override
    public void collide (CollisionEvent e) {
        if (e.getOtherBody() instanceof Coin) {
            player.addScore(player.getScore()+10);
            e.getOtherBody().destroy();
            System.out.println("You collected the coin!"+ "score:"+player.getScore());
            //...
        }
    }
}
