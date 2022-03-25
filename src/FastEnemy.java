import java.awt.*;

public class FastEnemy extends GameObject{

    private Handler handler;
    private float width = 10;
    private float height = 10;
    private static int DAMAGE = 1;

    public FastEnemy(int x, int y, Identity id,  Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 10;
        velY = 8;
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
        colission();

        //the smaller the "life", the longer the trail
        Trail trail = new Trail(x,y,Identity.trail, Color.yellow,width,height,0.10f,handler);
        handler.addObject(trail);

    }
    private void colission(){
        for(GameObject object: handler.gameObjects){
            if(object.getId() == Identity.player){
                if(getBounds().intersects(object.getBounds())){
                    HUD.HEALTH -= DAMAGE;
                }
            }
        }
    }


    public void render( Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) x, (int) y, (int) width,(int) height);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width,(int) height);
    }
}
