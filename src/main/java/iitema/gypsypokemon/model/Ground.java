package iitema.gypsypokemon.model;


import iitema.gypsypokemon.Log;

public class Ground extends SimpleField {
    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        boolean ret = super.placeOn(dir, item);
        if (ret) Log.println(" placed Box on Ground");
        return ret;
    }

    @Override
    public boolean removeItem(Direction dir) {
        Log.println(" from Ground");
        return super.removeItem(dir);
    }

    @Override
    public boolean stepOn(Direction dir, PlayerInterface player) {
        boolean ret = super.stepOn(dir, player);
        if (ret) Log.println("Player" + player.getId() + " moved " + dir.toString() + " to Ground");
        else Log.println("Player" + player.getId() + " couldn't move " + dir.toString() + " to Ground");
        return ret;
    }
}
