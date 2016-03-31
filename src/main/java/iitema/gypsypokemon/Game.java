package iitema.gypsypokemon;

import iitema.gypsypokemon.model.Direction;
import iitema.gypsypokemon.model.FieldInterface;
import iitema.gypsypokemon.model.Ground;
import iitema.gypsypokemon.model.Player;

public class Game {

    private FieldInterface field = new Ground();
    private Player player = new Player(this, field);

    public Game() {
        FieldInterface f = this.field;
        for (int i = 0; i < 10; i++) {
            f.setNeighbor(Direction.RIGHT, new Ground());
            f = f.getNeighbor(Direction.RIGHT);
        }
    }

    public void startGame() {
        this.player.step(Direction.RIGHT);
        this.player.step(Direction.RIGHT);
        this.player.step(Direction.RIGHT);
        this.player.step(Direction.RIGHT);
        this.player.step(Direction.RIGHT);
        this.player.step(Direction.RIGHT);
        this.player.step(Direction.RIGHT);
        this.player.step(Direction.RIGHT);
    }

    public void endGame() {

    }

    public void pauseGame() {

    }

    public static void main(String[] args) {
        System.out.println("Gypsy Pokemon!");

        Game game = new Game();

        game.startGame();
    }
}
