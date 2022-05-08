import java.awt.*;
import java.util.Random;

public class PlayerProjectile extends GameObject {
    private Handler handler;
    private float width;
    private float height;
    private static int DAMAGE = 1;
    private Random r;
    private int velX;
    private int velY;



    public PlayerProjectile(float x, float y, Identity id, float width, float height, Handler handler, int velX, int velY) {
        super(x, y, id);
        this.width = width;
        this.height = height;
        this.handler = handler;

        this.velX = velX;
        this.velY = velY;
    }


    public void tick() {
        x += velX;
        y += velY;
        if(x >= Game.WIDTH - 32 || x<=0){
            handler.removeObject(this);
        }
        if(y >= Game.HEIGHT - 64 || y<=0){
            handler.removeObject(this);
        }
        colission();

        //the smaller the "life", the longer the trail
        //Trail trail = new Trail(x,y,Identity.trail, (new Color(222,255,150)),width,height,0.10f,handler);
       // handler.addObject(trail);

    }
    private void colission(){
        for(int i =0 ;i< handler.gameObjects.size(); i++){
            GameObject object = handler.gameObjects.get(i);
            if(object.getId() == Identity.eaterAsal){
                if(getBounds().intersects(object.getBounds())){
                    EaterAsal.Boss1Health -= DAMAGE;
                    System.out.println("certo");
                }
            }
        }

    }


    public void render( Graphics g) {
        g.setColor(new Color(222,255,150));
        g.fillRect((int) x, (int) y, (int) width,(int) height);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width,(int) height);
    }

    @Override
    public void shoot() {

    }
}

