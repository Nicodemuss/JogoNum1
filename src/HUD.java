import java.awt.*;

public class HUD {

    protected static int HEALTH = 100;


    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 1000);
    }
    public void render(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(15,15,200,20);
        g.setColor(Color.green);
        g.fillRect(15,15,HEALTH * 2,20);
    }


}
