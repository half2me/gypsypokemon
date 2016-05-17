package iitema.gypsypokemon.controller;

import iitema.gypsypokemon.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Pause button click handler
 */
public class PauseListener implements ActionListener {
    private Game game;
    private KeyboardListener gl;
    private JButton btPause;
    private boolean paused = false;

    /**
     *
     * @param g game
     * @param l keyboard listener
     * @param b pause button
     */
    public PauseListener(Game g, KeyboardListener l, JButton b) {
        game = g;
        gl = l;
        btPause = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.pauseGame();
        toggleUI();
    }

    /**
     * Resets button text to default value
     */
    void reset() {
        if (paused) {
            toggleUI();
        }
    }

    /**
     * Switches button text between "Pause" and "Continue"
     */
    private void toggleUI() {
        if (!game.ended) {
            if (paused) {
                btPause.setText("Pause");
                gl.enable();
            } else {
                btPause.setText("Continue");
                gl.disable();
            }
            paused = !paused;
        }
    }
}
