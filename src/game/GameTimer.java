package game;

import org.jbox2d.common.Timer;

public class GameTimer extends Timer {
    private GameLevel level;


    public GameTimer(GameLevel level) {
        this.level = level;

    }//GameWorld --gameWorld deleted as we've replaced with abstract class 'GameLevel' for level implementation




}
