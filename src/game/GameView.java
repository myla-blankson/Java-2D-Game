package game;
import city.cs.engine.*;

import java.awt.*;
//DESCRIBES RENDERING...

public class GameView extends UserView{

    private Image background;

    public GameView(World w, int width, int height)
    {super(w, width, height);
//       background = new ImageIcon("data/ForestDay.png").getImage();
    }//constructor

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 130, this);
    }









}
