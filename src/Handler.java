import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList <GameObject> gameObjects = new LinkedList<>();

    public void tick(){
        for(GameObject gTick: gameObjects){
            GameObject tempObject = gTick;
            tempObject.tick();
        }
    }
    public void render(Graphics g){
        for(GameObject gGraph: gameObjects){
           GameObject tempObject = gGraph;
           tempObject.render(g);
        }
    }
    public void addObject(GameObject obj){
        this.gameObjects.add(obj);
    }
    public void removeObject(GameObject obj){
        this.gameObjects.remove(obj);
    }
}
