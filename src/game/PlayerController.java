package game;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class PlayerController implements KeyListener { // remember to register event...
// all methods must be implemented and overridden or class must be declared as abstract...
    // implementing an interface means that you will define the methods (polymorphism)
    private static final float speed = 8;
    private Player player;
    private HashMap<Body, BodyImage> hiddenImages = null;

    public PlayerController(Player player) {
        this.player = player; // store player object inside PlayerController
    }

    public void setBody(Player player) {
        this.player = player;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println("Key Pressed: " + code);  // Debugging line
        if (code == KeyEvent.VK_LEFT) {
            player.startWalking(-speed); // implementing method from Walker class and applying to Player instance, 'player'
        } else if (code == KeyEvent.VK_RIGHT) {
            player.startWalking(speed);
        } else if (code == KeyEvent.VK_UP) {
            player.jump(20);
        }else if (code == KeyEvent.VK_DOWN) {
            player.jump(-20);
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println("Key Pressed: " + code);
        if (code == KeyEvent.VK_LEFT) {
            player.stopWalking();
        } else if (code == KeyEvent.VK_RIGHT) {
            player.stopWalking();

        }

    }
    public void updatePlayer (Player NewPlayer){
        player = NewPlayer;

    }




}
