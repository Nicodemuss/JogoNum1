import java.util.Random;

public class Spawn {

    private Handler handler;
    private HUD hud;
    private Random r;
    private int scoreCount;
    private int scoreKeep;

    public Spawn(Handler handler, HUD hud) {
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep++;
        scoreCount++;
        hud.setScore(scoreKeep);
        r =new Random();
        if(scoreCount >= 10 & hud.getLevel()<10){
            scoreCount = 0;
            hud.setLevel(hud.getLevel()+1);
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.enemy,16,16, handler));

        }else if(scoreCount >= 10 ){
            scoreCount = 0;
            hud.setLevel(hud.getLevel()+1);
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.enemy,16,16, handler));
            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.fastEnemy, handler));
            handler.addObject(new SlowEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.slowEnemy, handler));

        }
    }
}
