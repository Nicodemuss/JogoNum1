import java.util.Random;

//also the game script
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
        if(scoreCount >= 100 & hud.getLevel()<5){
            scoreCount = 0;
            hud.setLevel(hud.getLevel()+1);

            //handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.fastEnemy, handler));
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.enemy,16,16, handler));

        }
        else if(scoreCount >= 100 & hud.getLevel()>=5 & hud.getLevel()<10){
            scoreCount = 0;
            hud.setLevel(hud.getLevel()+1);
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.enemy,16,16, handler));
            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.fastEnemy, handler));
            handler.addObject(new SlowEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.slowEnemy, handler));
            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.fastEnemy, handler));
        }
        else if(scoreCount >= 100 & hud.getLevel()>=12){
            scoreCount = 0;
            hud.setLevel(hud.getLevel()+1);
            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.enemy,16,16, handler));
            handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.fastEnemy, handler));
            handler.addObject(new SlowEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.slowEnemy, handler));
            handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.fastEnemy, handler));
        }

        if(hud.getLevel() == 10 & scoreCount >=100){
            scoreCount = 0;
            handler.removeEnemies();
            handler.removeEnemies();
            handler.removeEnemies();
            handler.removeEnemies();
            handler.removeEnemies();
            handler.addObject(new EaterAsal(Game.WIDTH/2,0,Identity.eaterAsal,96,96, handler));
            hud.setLevel(11);
        }

        if(EaterAsal.Boss1Health <=0 && hud.getLevel() == 11){
            scoreKeep = 100;
            scoreCount = 0;
            hud.setLevel(12);
        }

        if(hud.getLevel()%5==0 & scoreCount == 0){

            handler.addObject(new HealthPack(r.nextInt(Game.WIDTH - 50),r.nextInt(Game.HEIGHT-50),Identity.healthPack, handler));

        }
    }
}
