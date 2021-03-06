import java.awt.*;

public class SlowEnemy extends GameObject{

    private Handler handler;
    private float width = 50;
    private float height = 50;
    private static int DAMAGE = 5;

    public SlowEnemy(float x, float y, Identity id,  Handler handler) {
        super(x, y, id);
        this.handler = handler;
        velX = 1;
        velY = 1;
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
        Trail trail = new Trail(x,y,Identity.trail, new Color(150,100,255),width,height,0.05f,handler);
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
        g.setColor(new Color(55,0,255));
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
