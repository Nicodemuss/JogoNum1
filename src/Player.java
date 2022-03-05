import java.awt.*;
import java.util.Random;


public class Player extends GameObject {

    private Random r;
    private Handler handler;

    public Player(int x, int y, Identity id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
//        r = new Random();
//        velX = r.nextInt(3);
//        velY = r.nextInt(3);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(x,y,32,32);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - 32);
        y = Game.clamp(y, 0, Game.HEIGHT- 32);
       // colission();
    }
//    private void colission(){
//         for(GameObject object: handler.gameObjects){
//             if(object.getId() == Identity.enemy){
//                 if(getBounds().intersects(object.getBounds())){
//                     HUD.HEALTH -= 10;
//                 }
//             }
//         }
//    }

    @Override
    public void render(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;

        if(id == Identity.player ){
            g2d.setColor(Color.MAGENTA);
            g.setColor(Color.green);
        }else if(id == Identity.player2){
            g2d.setColor(Color.green);
            g.setColor(Color.CYAN);
        }
        g2d.draw(getBounds());
        g.fillRect(x,y,32,32);
    }


}
