package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class PlayerController implements KeyListener { // remember to register event...
// all methods must be implemented and overridden or class must be declared as abstract...
    private static final float speed = 3;
    private Player player;

    public PlayerController(Player player) {
        this.player = player; // store player object inside PlayerController
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            player.startWalking(-speed); // implementing method from Walker class and applying to Player instance, 'player'
        } else if (code == KeyEvent.VK_RIGHT) {
            player.startWalking(speed * 2);
        } else if (code == KeyEvent.VK_UP) {
            player.jump(5);
        }else if (code == KeyEvent.VK_DOWN) {
            player.jump(-5);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_LEFT) {
            player.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            player.stopWalking();

    }

}




}
