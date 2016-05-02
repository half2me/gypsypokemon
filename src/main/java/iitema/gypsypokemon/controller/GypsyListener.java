package iitema.gypsypokemon.controller;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.model.Color;
import iitema.gypsypokemon.model.Direction;
import iitema.gypsypokemon.model.PlayerInterface;
import iitema.gypsypokemon.view.GypsyCanvas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GypsyListener extends AbstractAction {
    private Game game;
    private boolean enabled = true;

    public GypsyListener(Game g) {
        game = g;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (enabled) {
            PlayerInterface player = game.getPlayers()[0];
            switch (e.getActionCommand().charAt(0)) {
                case 'w':
                    player.step(Direction.UP);
                    break;
                case 'a':
                    player.step(Direction.LEFT);
                    break;
                case 's':
                    player.step(Direction.DOWN);
                    break;
                case 'd':
                    player.step(Direction.RIGHT);
                    break;
                case 'f':
                    player.action();
                    break;
                case 'q':
                    player.shoot(Color.BLUE);
                    break;
                case 'e':
                    player.shoot(Color.YELLOW);
                    break;
                default:
                    break;
            }
        }
    }

    public void addBindings(JPanel c) {
        c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'), "w");
        c.getActionMap().put("w", this);
        c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('a'), "a");
        c.getActionMap().put("a", this);
        c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'), "s");
        c.getActionMap().put("s", this);
        c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('d'), "d");
        c.getActionMap().put("d", this);
        c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('q'), "q");
        c.getActionMap().put("q", this);
        c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('e'), "e");
        c.getActionMap().put("e", this);
        c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('f'), "f");
        c.getActionMap().put("f", this);
    }

    void enable() {
        enabled = true;
    }

    void disable() {
        enabled = false;
    }
}
