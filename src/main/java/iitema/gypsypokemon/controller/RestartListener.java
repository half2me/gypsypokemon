package iitema.gypsypokemon.controller;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.view.GypsyCanvas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartListener implements ActionListener {
    private Game game;

    public RestartListener(Game g) {
        game = g;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        game.restart();
    }
}
