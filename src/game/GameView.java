package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;

//DESCRIBES RENDERING...

public class GameView extends UserView{

    private final Image background;
    //private GameWorld gameWorld; // storing my GameWorld here as a variable so that I can easily access it
    private GameLevel level;
    public GameView(GameLevel level, int width, int height) {
        super(level, width, height);
        this.level = level;

        background = new ImageIcon("data/forest.png").getImage();

    }

//    public GameWorld getGameWorld() { // this method essentially allows me to get my world to apply the methods
//        return gameWorld;
//    }
    public GameLevel getGameLevel() {
        return level;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 40, this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);


        // font and colour
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 15));

        // Draw score
        g.drawString("Score: " + level.getPlayer().getScore(), 20, 30);
        //to access the player, I must access it where it was defined in GameWorld (using the variable i stored my GameWorld in)...
        // add timer
        g.drawString("Time: " + level.getTimeRemaining(), 20, 60);
        //this getTimeRemaining method will give the player a certain amount of time as a challenge...
        //defined in GameWorld

        // Game Won Display...
        if (level.isGameWon()) {
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.GREEN);
            g.drawString("YOU WIN!", 250, 300);
        }

        // Game Lost Display...
        if (level.isGameOver() && !level.isGameWon()) { //
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 250, 300);
        }
    }
    }








