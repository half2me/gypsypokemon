package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.Reflector;
import iitema.gypsypokemon.elements.Direction;

public class Zpm implements ItemInterface{

    public static int total = 30;
    public static int collected = 0;
    private FieldInterface field;
    private Game game;

    public Zpm(FieldInterface field, Game game){
        this.field = field;
        this.game = game;
    }

    /**
     * Returns solidity for item
     * If an item is solid, projectiles and players cannot walk over or step on.
     * If an item is not solid, projectiles can be shot through and players can walk over or step on.
     *
     * @param side side of the item to check
     * @return solidity
     */
    @java.lang.Override
    public boolean solid(Direction side) {
        Reflector.start();
        Reflector.end();
        return false;
    }

    /**
     * Executes operation when the Item is picked up
     *
     * @return if the Item can be picked up
     */
    @Override
    public boolean pickUp() {
        Reflector.start();

        Zpm.collected++;
        this.field.removeItem(Direction.DOWN); // in case ZPM is in the door
        this.field.removeItem(Direction.LEFT); // in case ZPM is in the door
        if(Reflector.ask("Összegyűjöttük az összes Zpm-et?")) {
            game.endGame();
        }

        Reflector.end();
        return false; // ZPM should no be picked up
    }
}
