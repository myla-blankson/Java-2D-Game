package game;

import city.cs.engine.*;

public class Coin extends StaticBody {
    private boolean collected=false;
    private static final Shape coinShape = new CircleShape(0.5f);
    private static final BodyImage coinImage = new BodyImage("data/coin.png", 1f);

    public Coin(World world) {
        super(world, coinShape);
        addImage(coinImage);



    }
    public void collected(){
        this.collected=true;


    }

}
