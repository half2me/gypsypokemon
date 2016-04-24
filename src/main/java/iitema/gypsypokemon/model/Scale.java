package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Log;

public class Scale extends SimpleField{
    private static float THRESHOLD = 1.9f;

    private Door door;
    private float weight;

    public Scale(Door door){
        this.door = door;
    }

    /**
     * Try to step on a field

     * @param dir direction the player is facing
     * @param player the player that is stepping on the field
     * @return if player moved to the field or not
     */
    @Override
    public boolean stepOn(Direction dir, PlayerInterface player) {
        if (super.stepOn(dir, player)) {
            Log.println("Player" + player.getId() + " moved " + dir.toString() + " to Scale");
            weight += player.getWeight();
            if (weight > THRESHOLD) {
                this.door.open();
            }
            return true;
        } else Log.println("Player" + player.getId() + " couldn't move " + dir.toString() + " to Scale");
        return false;
    }

    /**
     * Leave a field
     */
    @Override
    public void stepOff(PlayerInterface player) {
        weight -= player.getWeight();
        if (weight < THRESHOLD) {
            this.door.close();
        }
    }

    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        if (super.placeOn(dir, item)) {
            Log.println(" placed Box on Scale");
            weight += item.getWeight();
            if (weight > THRESHOLD) {
                this.door.open();
            }
            return true;
        }
        return false;
    }

    /**
     * Remove the item on the field (if any)
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    public boolean removeItem(Direction dir) {
        ItemInterface item = super.getItem(dir);
        if (item != null) {
            Log.println(" from Scale");
            weight -= items.peek().getWeight();
            super.removeItem(dir);
            if (weight < THRESHOLD) {
                this.door.close();
            }
            return true;
        }
        return false;
    }
}
