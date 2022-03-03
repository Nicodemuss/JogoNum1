import java.awt.*;

public class BasicEnemy extends GameObject{

    public BasicEnemy(int x, int y, Identity id) {
        super(x, y, id);

        velX = 5;
        velY = 5;
    }


    public void tick() {
        x += velX;
        y += velY;
        if(x >= Game.WIDTH - 32 || x<=0){
            velX = velX*-1;
        }
        if(y >= Game.HEIGHT - 64 || y<=0){
            velY = velY*-1;
        }
    }


    public void render( Graphics g) {
        g.setColor(Color.red);
        g.fillRect(x,y,32,32);
    }
}
