package iitema.gypsypokemon.view;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.controller.GypsyListener;
import iitema.gypsypokemon.controller.LoadMapListener;
import iitema.gypsypokemon.controller.PauseListener;
import iitema.gypsypokemon.controller.RestartListener;

import javax.swing.*;
import java.awt.*;

public class GypsyWindow extends JFrame {
    private GypsyCanvas canvas;

    public GypsyWindow(Game game) {
        super("gypsypokemon");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        this.setLayout(new BorderLayout());
        canvas = new GypsyCanvas(game);
        this.add(canvas, BorderLayout.CENTER);
        GypsyListener gl = new GypsyListener(game);
        gl.addBindings(canvas);

        JPanel panel = new JPanel(new FlowLayout());
        JButton btRestart = new JButton("Restart");
        JButton btPause = new JButton("Pause");
        JButton btLoadMap = new JButton("Load another map");
        btRestart.addActionListener(new RestartListener(game));
        PauseListener pl = new PauseListener(game, gl, btPause);
        btPause.addActionListener(pl);
        btLoadMap.addActionListener(new LoadMapListener(game, this, pl));
        panel.add(btRestart);
        panel.add(btPause);
        panel.add(btLoadMap);
        this.add(panel, BorderLayout.NORTH);

        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);

        this.setVisible(true);
    }

    public GypsyCanvas getCanvas() {
        return canvas;
    }
}
