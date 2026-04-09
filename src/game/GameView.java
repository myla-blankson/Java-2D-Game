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
    private final Image heartImage = new ImageIcon("data/heart.png").getImage();
    public GameView(GameLevel level, int width, int height) {
        super(level, width, height);
        this.level = level;

        background = new ImageIcon("data/forest.png").getImage();

    }
    public void setLevel(GameLevel level) { // updates level field
        this.level = level;
    }




    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0,0, getWidth(), getHeight(), this);
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        super.paintForeground(g);


        // font and colour
        g.setColor(Color.RED);
        g.setFont(new Font("Arial", Font.BOLD, 15));

        // Draw score
        g.drawString("Score: " + level.getPlayer().getScore(), 20, 30);
        //to access the player, I must access it where it was defined in GameLevel (using the variable i stored my GameLevel in)...
        // add timer
        g.drawString("Time: " + level.getTimeRemaining(), 20, 60);
        //this getTimeRemaining method will give the player a certain amount of time as a challenge...
        //defined in GameLevel

        for (int x = 0; x <level.getLives(); x++) {
            g.drawString("Lives: " , 450, 55);
            g.drawImage(heartImage, 500 +(x*30), 30,35,40, this);//space of 30 pixels
        }

        if (!level.getGame().isGameStarted()) { // whilst the game hasn't started, return this screen:
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.setColor(Color.YELLOW);
            g.drawString("COIN SNATCHER", 100, 300);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.GREEN);
            g.drawString("CLICK TO START", 170, 400);
            return;
        }

        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.setColor(Color.YELLOW);
        g.drawString("COIN SNATCHER", getWidth() / 2 - 100, 30);

        g.drawString(level.getLevelName(), getWidth() / 2 - 50, 55);


        // Game Won Display...
        if (level.isGameWon()) {
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.GREEN);
            g.drawString("YOU WON!", 250, 300);

        }

        // Game Lost Display...
        if (level.isGameOver() && !level.isGameWon()) { //
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.setColor(Color.RED);
            g.drawString("GAME OVER", 250, 300);
        }
    }
    }








