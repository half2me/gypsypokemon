package iitema.gypsypokemon.view;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.controller.GypsyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class GypsyWindow extends JFrame {
    Game game;
    GypsyCanvas canvas;
    JPanel panel = new JPanel(new BorderLayout());

    public GypsyWindow(Game g) {
        super("gypsypokemon");
        this.game = g;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(new BorderLayout());
        canvas = new GypsyCanvas(game);
        this.add(canvas, BorderLayout.NORTH);
        this.addKeyListener(new GypsyListener(game, canvas));

        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.setVisible(true);
    }
}
