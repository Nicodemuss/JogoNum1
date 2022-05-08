import java.awt.*;

public class HUD {

    protected static float HEALTH = 150;
    private int green = 255;
    private  int score = 0;
    private int level = 1;



    public void tick(){
        HEALTH = Game.clamp(HEALTH, 0, 100);
        green = (int)HEALTH*2;

    }
    public void render(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(15,15,200,20);
        g.setColor(new Color(75, green, 0));
        g.fillRect(15,15,(int)HEALTH * 2,20);
        g.setColor(Color.white);
        g.drawString("Score"+score,15,50);
        g.drawString("Level"+level,15,70);

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
