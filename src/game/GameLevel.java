package game;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import city.cs.engine.Body;
import javax.swing.Timer;
import city.cs.engine.World;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;




public abstract class GameLevel extends World implements ActionListener { // abstract class
    protected Player player;
    protected boolean gameWon = false;
    protected boolean gameOver = false;
    protected int collectedCoins = 0;
    protected List<Coin> coins;
    protected int totalCoins;
    protected int timeRemaining = 10;
    protected Timer timer;
    protected Game game;

//protected to enable level classes to easily access and modify the fields
    //as abstract classes cannot be instantiated, they behave as a base class that other classes can inherit from
    //this enables polymorphism and reusable code

    // I can only call methods defined in GameLevel not the Level subclasses

    public GameLevel(Game game) {
        this.game = game;

        coins = new ArrayList<>();

        player = new Player(this); //player is set in the world
        player.setPosition(new Vec2(0, -10));
        create();

        timer = new Timer(1000, this);
        timer.start();



    }

    public void setPlayer(Player player) {
        this.player = player;
        player.setPosition(new Vec2(8, -10));  // Reset player position to start point
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

    public void collectCoins() {
        collectedCoins++;
    }


    public int getCollectedCoins() {
        return collectedCoins; //maybe multiply by a value to gain more points?
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void stopLevel(){
        this.stop();
        timer.stop();

    }// by creating these two methods, we enable encapsulation to avoid the problem of multiple timers
    public void startTimer() {
        if (timer != null) timer.stop(); // this checks first if a timer exists and then stops it.
        timer = new Timer(1000, this);// it avoids a null pointer exception (no object existing)
        timer.start();
    }

    public void stopTimer() {
        if (timer != null) timer.stop();
    }

    public void createCoins(int numCoins) {
        for (Coin c : coins) {
            c.destroy();  // Destroy all coins
        }

            coins.clear();  // deletes old coins (from list) if restarting

            for (int i = 0; i < numCoins; i++) { //for the total amount of coins, create an object Coin
                Coin coin = new Coin(this);
                // random positions with spacing
                float x = (float) (Math.random() * 80 - 40);
                float y = (float) (Math.random() * 8 - 2);
                coin.setPosition(new Vec2(x, y));
                coin.addCollisionListener(new PlayerCollisions(player, this)); //make sure each coin is detected

                coins.add(coin);  // store in  list
            } // or create abstract method createCoins() here, and then actually define in other concrete classes like Level1
            totalCoins = coins.size();
        }//that would demonstrate polymorphism ...




        public abstract void create ();


        @Override
        public void actionPerformed (ActionEvent ae){
            if (gameOver || gameWon) {
                timer.stop();
                return;
            }

            timeRemaining--;
            if (collectedCoins == totalCoins) {
                gameWon = true;
                timer.stop(); // try to implement 'play again' or 'next level'
                // delay before going to next level
                javax.swing.Timer delay = new javax.swing.Timer(2000, e -> {
                    game.goToNextLevel();
                });
                delay.setRepeats(false); // fire only once
                delay.start();
            } else if (timeRemaining <= 0 && collectedCoins < totalCoins) {
                gameOver = true;
                timer.stop();
                // delay before
                javax.swing.Timer delay = new javax.swing.Timer(2000, e -> {
                    game.restartLevel();
                });
                delay.setRepeats(false); // fire only once
                delay.start();


            }
        }


    }

