import java.awt.*;
import java.util.LinkedList;

public class Handler {

    LinkedList <GameObject> gameObjects = new LinkedList<>();

    public void tick(){
        // aqui é necessário um for desse jeito, um forEach da erro quando são inseridas as trails
        for(int i = 0; i < gameObjects.size();i++){
            GameObject tempObject = gameObjects.get(i);
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
