package iitema.gypsypokemon.controller;

import iitema.gypsypokemon.Game;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

/**
 * Load map button click handler
 */
public class LoadMapListener implements ActionListener {
    private Game game;
    private JFrame parent;
    private PauseListener lPause;

    /**
     *
     * @param g game
     * @param p parent window
     * @param l pause button click handler
     */
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
