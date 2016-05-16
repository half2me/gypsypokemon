package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Game;

import java.util.Random;

public class Zpm implements ItemInterface{

    public static int total = 0;
    public static int collected = 0;
    private FieldInterface field;
    private Game game;
    private Random rand = new Random();

    /**
     * Creates a Zpm.
     *
     * @param field Field the Zpm is on
     * @param game Game object that creates this Zpm
     */
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
        return false;
    }

    /**
     * Executes operation when the Item is picked up
     *
     * @return if the Item can be picked up
     */
    @Override
    public boolean pickUp() {
        Zpm.collected++;
        this.field.removeItem(Direction.DOWN); // in case ZPM is in the door
        this.field.removeItem(Direction.LEFT); // in case ZPM is in the door
        if (Zpm.collected % 2 == 0) {
            boolean placed = false;
            while(!placed) {
                FieldInterface f = game.getFields();
                int x = rand.nextInt(20);
                int y = rand.nextInt(20);
                for (int i = 0; i < x; ++i) {
                    f = f.getNeighbor(Direction.RIGHT);
                }
                for (int i = 0; i < y; ++i) {
                    f = f.getNeighbor(Direction.DOWN);
                }
                placed = f.placeOn(Direction.DOWN, new Zpm(f, game));
            }
            Zpm.total++;
        } else if(Zpm.collected == Zpm.total) {
            game.endGame();
        }
        return false; // ZPM should no be picked up
    }

    /**
     * @return Weight of the item
     */
    public float getWeight() {
        return 0.0f;
    }

    /**
     * Return the name of the sprite
     *
     * @return name of the sprite
     */
    @Override
    public String sprite() {
        return "zpm";
    }
}
