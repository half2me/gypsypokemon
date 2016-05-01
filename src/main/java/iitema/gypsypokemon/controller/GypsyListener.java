package iitema.gypsypokemon.controller;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.model.Color;
import iitema.gypsypokemon.model.Direction;
import iitema.gypsypokemon.model.PlayerInterface;
import iitema.gypsypokemon.view.GypsyCanvas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GypsyListener implements KeyListener {
    private Game game;
    private GypsyCanvas canvas;

    public GypsyListener(Game g, GypsyCanvas c) {
        game = g;
        canvas = c;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        PlayerInterface player = game.getPlayers()[0];
        switch (e.getKeyChar()) {
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
        canvas.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
