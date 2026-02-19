package game;

import city.cs.engine.*;


public class Player extends Walker {
    private static final Shape playerShape = new PolygonShape(
            -0.11f,2.8f,
            0.87f,1.48f,
            0.99f,0.29f,
            0.24f,-2.32f,
            -1.12f,-2.27f,
            -1.24f,1.21f);

    }


    private static final BodyImage playerImage = new BodyImage("data/player.png", 5f);
    //creating an invariable, limited access image for the player using BodyImage as a type
    private int score;
    private boolean isAlive;


    public Player(World world) {
        super(world, playerShape);
        addImage(playerImage);
        score = 0;
        isAlive = true;
    }

    private void addImage(BodyImage playerImage) {
    }


    public void setScore (int score){
        this.score = score; // change to if player collides with coins, coins increments
    }
    public int getScore () {
        return score; // make coins methods public so that i can access and use to modify here
    }
    public boolean isAlive () {
        return isAlive;








}



