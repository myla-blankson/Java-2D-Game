package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import city.cs.engine.Body;
import javax.swing.Timer;
import city.cs.engine.World;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public abstract class GameLevel extends World implements ActionListener { // abstract class
    protected Player player;
    private boolean gameWon = false;
    protected boolean gameOver = false;
    protected int collectedCoins = 0;
    protected int totalCoins = 10;
    protected int timeRemaining = 10;
    protected Timer timer;
    protected Game game;
//protected to enable level classes to easily access and modify the fields
    //as abstract classes cannot be instantiated, they behave as a base class that other classes can inherit from
    //this enables polymorphism and reusable code

    public GameLevel(Game game) {
        this.game = game;

        player = new Player(this);
        player.setPosition(new Vec2(0, -10));

        timer = new Timer(1000, this);
        timer.start();

        define();

    }
    public Player getPlayer() {
        return player;
    }
    public int getTimeRemaining() {
        return timeRemaining;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public boolean isGameOver() {
        return gameOver;
    }
    public void CollectCoins() {
        collectedCoins++;
    }


    public int getCollectedCoins() {
        return collectedCoins; //maybe multiply by a value to gain more points?
    }


    public abstract void define();


    @Override
    public void actionPerformed(ActionEvent ae) {
        timeRemaining--;
        if (collectedCoins == totalCoins) {
            gameWon = true;
            timer.stop(); // try to implement 'play again' or 'next level'
            game.goToNextLevel();
        } else if (timeRemaining <= 0 && collectedCoins < totalCoins) {
            gameOver = true;
            game.restartLevel();


        }
    }



}
