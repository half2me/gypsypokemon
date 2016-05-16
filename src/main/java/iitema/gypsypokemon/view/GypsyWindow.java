package iitema.gypsypokemon.view;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.controller.GypsyListener;
import iitema.gypsypokemon.controller.LoadMapListener;
import iitema.gypsypokemon.controller.PauseListener;
import iitema.gypsypokemon.controller.RestartListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GypsyWindow extends JFrame {
    private GypsyCanvas canvas;
    private JDialog help;

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
        PauseListener pl = new PauseListener(game, gl, btPause);
        btRestart.addActionListener(new RestartListener(game, pl));
        btPause.addActionListener(pl);
        btLoadMap.addActionListener(new LoadMapListener(game, this, pl));

        help = new JDialog(this, "Help", true);

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try {
            br = new BufferedReader(new FileReader("assets\\help.html"));

            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {}
        }
        JLabel helpLabel = new JLabel(sb.toString());
        helpLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        help.add(helpLabel);
        help.pack();

        JButton btHelp = new JButton("Help");
        btHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                help.setVisible(true);
            }
        });

        panel.add(btRestart);
        panel.add(btPause);
        panel.add(btLoadMap);
        panel.add(btHelp);
        this.add(panel, BorderLayout.NORTH);

        this.pack();

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        help.setLocation(dim.width/2-help.getSize().width/2, dim.height/2-help.getSize().height/2);

        this.setVisible(true);
    }

    public GypsyCanvas getCanvas() {
        return canvas;
    }
}
