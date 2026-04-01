package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;


public class Player extends Walker {
    private static final Shape playerShape = new PolygonShape( // fixtures, enable us to detect interactions
            -0.11f, 2.8f,
            0.87f, 1.48f,
            0.99f, 0.29f,
            0.24f, -2.32f,
            -1.12f, -2.27f,
            -1.24f, 1.21f);
    private static final BodyImage imageRight = new BodyImage("data/playerRight.png", 4f);
    private static final BodyImage imageLeft = new BodyImage("data/playerLeft.png", 4f);
    //creating an invariable, limited access image for the player using BodyImage as a type

    private int score;
    private boolean isAlive;

    public Player(World gameWorld) { //World enables player to be used on any level
        super(gameWorld, playerShape);
        addImage(imageRight);
        score = 0;
        isAlive = true;
    }

    @Override
    public void startWalking(float speed) {
        super.startWalking(speed);
        if (speed < 0){
            removeAllImages();
            addImage(imageLeft);
        }
        else{
            removeAllImages();
            addImage(imageRight);
        }

    }


    public void addScore(int score) {
        this.score += score; //  if player collides with coins, collected amount increments...
    }

    public int getScore() {
        return score;
    }

    public void resetScore() {
        score = 0;
    }

    public boolean isAlive() {
        return isAlive;
    }

}







