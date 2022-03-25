
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyInput extends KeyAdapter {

    private final Handler handler;
    private static float  VELOCIDADE = 3;

    // if more commands or a second player are to be added, this array should be increased, or a separate array should be created for player two
    private boolean[] keyDown = new boolean[4];

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
                    object.setVelY(-VELOCIDADE);
                    keyDown[0] = true;
                }
                if(key == KeyEvent.VK_S){
                    object.setVelY(VELOCIDADE);
                    keyDown[1] = true;

                }
                if(key == KeyEvent.VK_D){
                    object.setVelX(VELOCIDADE);
                    keyDown[2] = true;

                }
                if(key == KeyEvent.VK_A){
                    object.setVelX(-VELOCIDADE);
                    keyDown[3] = true;

                }

            }

            //key events for player 2
//            if (object.getId() == Identity.player2){
//                //key events for player2
//
//                if(key == KeyEvent.VK_UP){
//                    object.setVelY(-1);
//                }
//                if(key == KeyEvent.VK_DOWN){
//                    object.setVelY(1);
//                }
//                if(key == KeyEvent.VK_RIGHT){
//                    object.setVelX(1);
//                }
//                if(key == KeyEvent.VK_LEFT){
//                    object.setVelX(-1);
//                }
//
//            }
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
                    keyDown[0] = false;

                }
                if(key == KeyEvent.VK_S){
                    keyDown[1] = false;

                }
                if(key == KeyEvent.VK_D){
                    keyDown[2] = false;

                }
                if(key == KeyEvent.VK_A){
                    keyDown[3] = false;

                }

                if(!keyDown[0] && !keyDown[1]){
                    object.setVelY(0);
                }
                if(!keyDown[2]  && !keyDown[3]){
                    object.setVelX(0);
                }

            }
            //key events for player 2
//            if (object.getId() == Identity.player2){
//                //key events for player2
//
//                if(key == KeyEvent.VK_UP){
//                    object.setVelY(0);
//                }
//                if(key == KeyEvent.VK_DOWN){
//                    object.setVelY(0);
//                }
//                if(key == KeyEvent.VK_RIGHT){
//                    object.setVelX(0);
//                }
//                if(key == KeyEvent.VK_LEFT){
//                    object.setVelX(0);
//                }
//
//            }


        }
    }
}
