import java.awt.*;
import java.util.Random;


public class Player extends GameObject {

    private Random r;
    private Handler handler;
    private float width = 32;
    private float height = 32;

    public Player(float x, float y, Identity id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
//        r = new Random();
//        velX = r.nextInt(3);
//        velY = r.nextInt(3);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width,(int) height);
    }

    @Override
    public void tick() {

        x += velX;
        y += velY;

        x = Game.clamp(x, 0, Game.WIDTH - width);
        y = Game.clamp(y, 0, Game.HEIGHT- height);
       // colission();
        Trail trail = new Trail(x,y,Identity.trail, Color.green,width,height,0.10f,handler);
        handler.addObject(trail);
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
        g.fillRect((int) x, (int) y, (int) width,(int) height);
    }


}
