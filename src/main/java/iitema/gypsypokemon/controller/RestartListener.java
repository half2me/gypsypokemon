package iitema.gypsypokemon.controller;

import iitema.gypsypokemon.Game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartListener implements ActionListener {
    private Game game;
    private PauseListener pl;

    public RestartListener(Game g, PauseListener pl) {
        game = g;
        this.pl = pl;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        pl.reset();
        game.restart();
    }
}
