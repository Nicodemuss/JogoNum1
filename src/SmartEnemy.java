import java.awt.*;

public class SmartEnemy extends GameObject {
    private Handler handler;
    private Player player;
    private float width = 20;
    private float height = 20;
    private static int DAMAGE = 1;

    public SmartEnemy(int x, int y, Identity id,  Handler handler) {
        super(x, y, id);
        this.handler = handler;

        for( GameObject object : this.handler.gameObjects){
            if(object.getId() == Identity.player) player = (Player) object;
        }
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

        float diffX = player.getX() - x;
        float diffY = player.getY() - y;
        float distance = (float)(Math.sqrt((x - player.getX())*(x - player.getX()) + (y - player.getY())*(y - player.getY())));

        velY = (2/distance)*diffY;
        velX = (2/distance)*diffX;

        //the smaller the "life", the longer the trail
        Trail trail = new Trail(x,y,Identity.trail, Color.yellow,width,height,0.10f,handler);
        //handler.addObject(trail);

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
        g.setColor(Color.MAGENTA);
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


