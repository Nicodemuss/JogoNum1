
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

    private final Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    //it has to be called keyPressed, or else, it won't work
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        for( GameObject object : this.handler.gameObjects){
                //GameObject object = handler.gameObjects.get(i);

            if (object.getId() == Identity.player){
                //key events for player1

                if(key == KeyEvent.VK_W){
                    object.setVelY(-1);
                }
                if(key == KeyEvent.VK_S){
                    object.setVelY(1);
                }
                if(key == KeyEvent.VK_D){
                    object.setVelX(1);
                }
                if(key == KeyEvent.VK_A){
                    object.setVelX(-1);
                }

            }

            if (object.getId() == Identity.player2){
                //key events for player2

                if(key == KeyEvent.VK_UP){
                    object.setVelY(-1);
                }
                if(key == KeyEvent.VK_DOWN){
                    object.setVelY(1);
                }
                if(key == KeyEvent.VK_RIGHT){
                    object.setVelX(1);
                }
                if(key == KeyEvent.VK_LEFT){
                    object.setVelX(-1);
                }

            }
        }


        System.out.println(key);

    }
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        for( GameObject object : this.handler.gameObjects){
            //GameObject object = handler.gameObjects.get(i);

            if (object.getId() == Identity.player){
                //key events for player1

                if(key == KeyEvent.VK_W){
                    object.setVelY(0);
                }
                if(key == KeyEvent.VK_S){
                    object.setVelY(0);
                }
                if(key == KeyEvent.VK_D){
                    object.setVelX(0);
                }
                if(key == KeyEvent.VK_A){
                    object.setVelX(0);
                }

            }

            if (object.getId() == Identity.player2){
                //key events for player2

                if(key == KeyEvent.VK_UP){
                    object.setVelY(0);
                }
                if(key == KeyEvent.VK_DOWN){
                    object.setVelY(0);
                }
                if(key == KeyEvent.VK_RIGHT){
                    object.setVelX(0);
                }
                if(key == KeyEvent.VK_LEFT){
                    object.setVelX(0);
                }

            }
        }
    }
}
