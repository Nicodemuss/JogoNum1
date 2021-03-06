import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 1240, HEIGHT = WIDTH/12*9;

    private Thread thread;
    private boolean isRunning = false;
    private Handler handler;
    private Random r;
    private HUD hud;
    private Spawn spawn;

    private Game(){

        handler = new Handler();
        hud = new HUD();
        spawn = new Spawn(handler, hud);


        new Window(WIDTH,HEIGHT,"FUNFO",this);
        this.addKeyListener(new KeyInput(handler));
            r = new Random();
            handler.addObject(new Player(r.nextInt(WIDTH - 50),r.nextInt(HEIGHT-50),Identity.player, handler));
            //handler.addObject(new Player(r.nextInt(WIDTH - 50),r.nextInt(HEIGHT-50),Identity.player2,handler));
         //   handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50),r.nextInt(HEIGHT-50),Identity.fastEnemy, handler));
        //handler.addObject(new SlowEnemy(r.nextInt(WIDTH - 50),r.nextInt(HEIGHT-50),Identity.slowEnemy, handler));

//        for(int i = 0; i<100;i++){
//            handler.addObject(new FastEnemy(r.nextInt(WIDTH - 50),r.nextInt(HEIGHT-50),Identity.enemy, handler));
//
//        }

    }

    public synchronized void start(){
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }
    public synchronized  void stop(){
        try{
            thread.join();
            isRunning = false;
        }catch (Exception e){
            e.getMessage();
        }
    }

    @Override
    public void run() {
        this.requestFocus();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                tick();
                delta--;
            }
            if(isRunning)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }
    private void tick(){
        handler.tick();
        hud.tick();
        spawn.tick();
    }
    public void render(){
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if(bufferStrategy == null){
            this.createBufferStrategy(3);
         return;
        }
        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.setColor(Color.black);
        graphics.fillRect(0,0,WIDTH, HEIGHT);

        handler.render(graphics);
        hud.render(graphics);


        graphics.dispose();
        bufferStrategy.show();
    }
    public static float clamp(float var, float min, float max){
        if (var >= max){
            return var = max;
        }else if(var<=min){
            return var = min;
        }
        return var;
    }

    public static void main(String args[]){
        new Game();
    }
}
