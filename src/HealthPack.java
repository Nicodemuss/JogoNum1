import java.awt.*;

public class HealthPack extends GameObject{

    private Handler handler;
    private float width = 30;
    private float height = 30;

    public HealthPack(float x, float y, Identity id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        colission();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect((int) x, (int) y, (int) width,(int) height);
        g.setColor(Color.red);
        g.fillRect((int) x+3, (int) y+10, (int) width-6,(int) height-20);
        g.setColor(Color.red);
        g.fillRect((int) x+10, (int) y+3, (int) width-20,(int) height-6);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, (int) width,(int) height);
    }

    private void colission(){
        //for(GameObject object: handler.gameObjects){

        for(int i = 0; i < handler.gameObjects.size();i++){
            GameObject object = handler.gameObjects.get(i);
            if(object.getId() == Identity.player){
                if(getBounds().intersects(object.getBounds())){
                    HUD.HEALTH += 30;
                    handler.removeObject(this);
                }
            }
        }
    }
}
