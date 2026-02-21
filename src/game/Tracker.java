package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.geom.Point2D;

public class Tracker implements StepListener {
    private GameView view;
    private Player player;
    public Tracker(GameView view,  Player player) {
        this.player = player;
        this.view = view;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(player.getPosition());
    }
}