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
        /* controls
                  p1  p2
        up        w   u
        left      a   h
        down      s   j
        right     d   k
        shoot c1  q   z
        shoot c2  e   i
         */
        if (enabled) {
            PlayerInterface players[] = game.getPlayers();
            Object command = e.getActionCommand();
            if (players[0] != null) {
                if (command.equals("w")) {
                    players[0].step(Direction.UP);
                } else if (command.equals("a")) {
                    players[0].step(Direction.LEFT);
                } else if (command.equals("s")) {
                    players[0].step(Direction.DOWN);
                } else if (command.equals("d")) {
                    players[0].step(Direction.RIGHT);
                } else if (command.equals("q")) {
                    players[0].shoot(Color.BLUE);
                } else if (command.equals("e")) {
                    players[0].shoot(Color.YELLOW);
                } else if (command.equals("f")) {
                    players[0].action();
                } else if (players[1] != null ) {
                    if (command.equals("u")) {
                        players[1].step(Direction.UP);
                    } else if (command.equals("h")) {
                        players[1].step(Direction.LEFT);
                    } else if (command.equals("j")) {
                        players[1].step(Direction.DOWN);
                    } else if (command.equals("k")) {
                        players[1].step(Direction.RIGHT);
                    } else if (command.equals("z")) {
                        players[1].shoot(Color.RED);
                    } else if (command.equals("i")) {
                        players[1].shoot(Color.GREEN);
                    } else if (command.equals("l")) {
                        players[1].action();
                    }
                }
            }
        }
    }

    public void addBindings(JPanel c) {
        InputMap inputMap =  c.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = c.getActionMap();
        inputMap.put(KeyStroke.getKeyStroke('w'), "step1up");
        actionMap.put("step1up", this);
        inputMap.put(KeyStroke.getKeyStroke('a'), "step1left");
        actionMap.put("step1left", this);
        inputMap.put(KeyStroke.getKeyStroke('s'), "step1down");
        actionMap.put("step1down", this);
        inputMap.put(KeyStroke.getKeyStroke('d'), "step1right");
        actionMap.put("step1right", this);
        inputMap.put(KeyStroke.getKeyStroke('q'), "shoot1blue");
        actionMap.put("shoot1blue", this);
        inputMap.put(KeyStroke.getKeyStroke('e'), "shoot1yellow");
        actionMap.put("shoot1yellow", this);
        inputMap.put(KeyStroke.getKeyStroke('f'), "action1");
        actionMap.put("action1", this);
        inputMap.put(KeyStroke.getKeyStroke('u'), "step2up");
        actionMap.put("step2up", this);
        inputMap.put(KeyStroke.getKeyStroke('h'), "step2left");
        actionMap.put("step2left", this);
        inputMap.put(KeyStroke.getKeyStroke('j'), "step2down");
        actionMap.put("step2down", this);
        inputMap.put(KeyStroke.getKeyStroke('k'), "step2right");
        actionMap.put("step2right", this);
        inputMap.put(KeyStroke.getKeyStroke('z'), "shoot2red");
        actionMap.put("shoot2red", this);
        inputMap.put(KeyStroke.getKeyStroke('i'), "shoot2green");
        actionMap.put("shoot2green", this);
        inputMap.put(KeyStroke.getKeyStroke('l'), "action2");
        actionMap.put("action2", this);
    }

    void enable() {
        enabled = true;
    }

    void disable() {
        enabled = false;
    }
}
