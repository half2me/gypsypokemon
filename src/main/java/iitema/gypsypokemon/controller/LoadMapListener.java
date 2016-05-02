package iitema.gypsypokemon.controller;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.view.GypsyCanvas;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class LoadMapListener implements ActionListener {
    private Game game;
    private JFrame parent;
    private PauseListener lPause;
    private GypsyCanvas canvas;

    public LoadMapListener(Game g, JFrame p, PauseListener l) {
        game = g;
        parent = p;
        lPause = l;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("CSV File", "csv"));
        fc.setCurrentDirectory(new File("assets"));
        int returnVal = fc.showOpenDialog(parent);
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                game.loadMap(fc.getSelectedFile().getAbsolutePath());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            lPause.reset();
        }
    }
}
