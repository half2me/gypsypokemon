package iitema.gypsypokemon.view;

import iitema.gypsypokemon.Game;

import javax.swing.*;
import java.awt.*;

public class GypsyWindow extends JFrame {
    Game game;
    GypsyCanvas canvas;
    JPanel panel = new JPanel(new BorderLayout());

    public GypsyWindow(Game g) {
        super();
        this.game = g;

        this.setTitle("gypsypokemon");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(panel);

        canvas = new GypsyCanvas(game);
        panel.add(canvas, BorderLayout.NORTH);

        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.setVisible(true);
    }
}
