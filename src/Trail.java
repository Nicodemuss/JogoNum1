import java.awt.*;

public class Trail extends GameObject {

    private Handler handler;
    private int width,height;
    private float alpha = 1, life;
    private Color color;

    public Trail(int x, int y, Identity id, Color color, int width, int height, float life, Handler handler) {
        super(x, y, id);
        this.color = color;
        this.width = width;
        this.height = height;
        this.life = life;
        this.handler = handler;

    }

    @Override
    public void tick() {
        if(alpha>life){
            alpha -= (life -0.001f);
        }else handler.gameObjects.remove(this);
    }

    @Override
    public void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(makeTrasparent(alpha));

        g.setColor(color);
        g.fillRect(x,y,width,height);

        g2d.setComposite(makeTrasparent(1));
    }

    private AlphaComposite makeTrasparent(float alfa){
       int type = AlphaComposite.SRC_OVER;
       return AlphaComposite.getInstance(type,alfa);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }
}
