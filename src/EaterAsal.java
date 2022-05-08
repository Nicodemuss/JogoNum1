import java.awt.*;
import java.util.Random;

public class EaterAsal extends GameObject {
    private Handler handler;

    private float width;
    private float height;
    private static int DAMAGE = 100;
    private int timer;
    private Random r;
    protected static float Boss1Health;
    private int fase = 1;

    public EaterAsal(float x, float y, Identity id, float width, float height, Handler handler) {
        super(x, y, id);
        this.width = width;
        this.height = height;
        this.handler = handler;

        velX = 6;
        velY = 0;
        Boss1Health = 200;
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
        shoot();

        Boss1Health = Game.clamp(Boss1Health, 0, 100);
        if (Boss1Health <10 && fase <2){
            Boss1Health = 200;
            fase = 2;
            velX = 10;
        }else if(Boss1Health<=0){
            handler.removeObject(this);
        }

        //the smaller the "life", the longer the trail
        Trail trail = new Trail(x,y,Identity.trail, Color.red,width,height,0.10f,handler);
        handler.addObject(trail);

    }
    private void colission(){
        for(int i =0 ;i< handler.gameObjects.size(); i++){
            GameObject object = handler.gameObjects.get(i);
            if(object.getId() == Identity.player){
                if(getBounds().intersects(object.getBounds())){
                    HUD.HEALTH -= DAMAGE;
                }
            }
        }
    }


    public void render( Graphics g) {


        g.setColor(Color.darkGray);
        g.fillRect(Game.WIDTH-255,15,200,20);
        g.setColor(new Color(75, 0, 0));
        g.fillRect(Game.WIDTH-255,15,(int)Boss1Health * 2,20);

        g.setColor(Color.red);
        g.fillRect((int) x, (int) y, (int) width,(int) height);

    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width,(int) height);
    }

    public void shoot(){
        timer++;
        r = new Random();
        r.ints(-3,3);
        if (timer == 25 && fase <2){
            timer=0;
            handler.addObject(new EaterAsalProjectile(x,y,Identity.enemyProjectile,16,16, handler,r.nextInt(5), 5));
            handler.addObject(new EaterAsalProjectile(x,y,Identity.enemyProjectile,16,16, handler,-1* r.nextInt(5), 5));
        }else if(timer >= 10 && fase >=2){
            timer = 0;
            handler.addObject(new EaterAsalProjectile(x,y,Identity.enemyProjectile,16,16, handler,r.nextInt(5), 5));
            handler.addObject(new EaterAsalProjectile(x,y,Identity.enemyProjectile,16,16, handler,-1* r.nextInt(5), 5));
            handler.addObject(new EaterAsalProjectile(x,y,Identity.enemyProjectile,16,16, handler,r.nextInt(5), 5));
            handler.addObject(new EaterAsalProjectile(x,y,Identity.enemyProjectile,16,16, handler,-1* r.nextInt(5), 5));
        }

    }
}


