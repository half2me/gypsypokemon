package iitema.gypsypokemon.controller;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.model.Color;
import iitema.gypsypokemon.model.Direction;
import iitema.gypsypokemon.model.PlayerInterface;

import javax.swing.*;
import java.awt.event.ActionEvent;

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
        InputMap inputMap =  c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = c.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke('w'), "w");
        actionMap.put("w", this);
        inputMap.put(KeyStroke.getKeyStroke('a'), "a");
        actionMap.put("a", this);
        inputMap.put(KeyStroke.getKeyStroke('s'), "s");
        actionMap.put("s", this);
        inputMap.put(KeyStroke.getKeyStroke('d'), "d");
        actionMap.put("d", this);
        inputMap.put(KeyStroke.getKeyStroke('q'), "q");
        actionMap.put("q", this);
        inputMap.put(KeyStroke.getKeyStroke('e'), "e");
        actionMap.put("e", this);
        inputMap.put(KeyStroke.getKeyStroke('f'), "f");
        actionMap.put("f", this);
    }

    void enable() {
        enabled = true;
    }

    void disable() {
        enabled = false;
    }
}
