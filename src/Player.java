import java.awt.*;
import java.util.Random;


public class Player extends GameObject {

    private Random r;

    public Player(int x, int y, Identity id) {
        super(x, y, id);
//        r = new Random();
//        velX = r.nextInt(3);
//        velY = r.nextInt(3);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 32);
        y = Game.clamp(y, 0, Game.HEIGHT- 32);
    }

    @Override
    public void render(Graphics g) {
        if(id == Identity.player ){
            g.setColor(Color.green);
        }else if(id == Identity.player2){
            g.setColor(Color.CYAN);
        }
        g.fillRect(x,y,32,32);
    }
}
