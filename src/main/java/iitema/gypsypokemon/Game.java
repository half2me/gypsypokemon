package iitema.gypsypokemon;

import iitema.gypsypokemon.model.*;

public class Game {

    private FieldInterface field = new Ground();
    private Player player = new Player(this, field);

    public Game() {
        FieldInterface f = this.field;
        for (int i = 0; i < 10; i++) {
            f.setNeighbor(Direction.RIGHT, new Abyss());
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
        Reflector.start();
        Reflector.out("Meghaltál!");
        Reflector.end();
    }

    public void pauseGame() {

    }

    public static void main(String[] args) {
        Reflector.on();

        Game game = new Game();

        game.startGame();
    }
}
