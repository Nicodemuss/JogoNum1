import javax.swing.*;
import java.awt.*;

//essa classe basicamente faz com que o jogo tenha uma janela
public class Window extends Canvas {

    private static final Long SerialID = -21545411335L;

    public Window(int width, int height, String title, Game game){
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        //faz o "X" de fechar funcionar
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //aparentemente redimensionar a tela é dificil, bota falso
        frame.setResizable(false);
        //desnecessario, mas isso faz começar no meio da tela, caso contrario, iria começar no canto esquerdo superior
        frame.setLocationRelativeTo(null);

        frame.add(game);
        frame.setVisible(true);
        game.start();
    }

}
