package iitema.gypsypokemon.controller;

import iitema.gypsypokemon.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseListener implements ActionListener {
    private Game game;
    private GypsyListener gl;
    private JButton btPause;
    private boolean paused = false;

    public PauseListener(Game g, GypsyListener l, JButton b) {
        game = g;
        gl = l;
        btPause = b;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        game.pauseGame();
        toggleUI();
    }

    void reset() {
        if (paused) {
            toggleUI();
        }
    }

    private void toggleUI() {
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
