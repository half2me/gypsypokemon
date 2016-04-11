package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Log;

public class SpecialWall extends Wall {
    /**
     * Shoot at a field
     *
     * @param color color of projectile
     * @param dir   direction projectile is travelling
     * @return true on shot absorbed, false on shot through
     */
    @Override
    public boolean shootAt(Color color, Direction dir) {
        Portal.set(color, this, dir.getOpposite());
        Log.println(color.toString() + " Portal created on Special Wall's " + dir.getOpposite() + " side");
        return true;
    }

    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        Portal portal = Portal.get(this, dir.getOpposite());
        if (portal != null) {
            // Needs to re-route through portal
            FieldInterface linkedField = portal.link();
            if (linkedField != null) {
                Log.print(" through Portal");
                return linkedField.placeOn(portal.opposite().side, item);
            }
        }
        // No portal, we can act as a normal wall
        return super.placeOn(dir, item);
    }

    @Override
    public ItemInterface getItem(Direction dir){
        Portal portal = Portal.get(this, dir.getOpposite());
        if (portal != null) {
            // Needs to re-route through portal
            FieldInterface linkedField = portal.link();
            if (linkedField != null) {
                Log.print("Through Portal ");
                return linkedField.getItem(portal.opposite().side);
            }
        }
        // No portal, we can act as a normal wall
        return super.getItem(dir);
    }


    /**
     * Remove the item on the field (if any)
     *
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    public boolean removeItem(Direction dir) {
        Portal portal = Portal.get(this, dir.getOpposite());
        if (portal != null) {
            // Needs to re-route through portal
            FieldInterface linkedField = portal.link();
            if (linkedField != null) {
                return linkedField.removeItem(portal.opposite().side);
            }
        }
        // No portal, we can act as a normal wall
        return super.removeItem(dir);
    }

    /**
     * Try to step on a field
     *
     * @param dir    direction the player is facing
     * @param player the player that is stepping on the field
     */
    @Override
    public boolean stepOn(Direction dir, PlayerInterface player) {
        Portal portal = Portal.get(this, dir.getOpposite());
        if (portal != null) {
            // Needs to re-route through portal
            Log.println("Player" + player.getId() + " rerouted through portal");
            FieldInterface linkedField = portal.link();
            if (linkedField != null) {
                if(dir != portal.opposite().side) {
                    player.step(portal.opposite().side);
                }
                return linkedField.stepOn(portal.opposite().side, player);
            }
        } else Log.println("Player" + player.getId() + " couldn't move " + dir.toString() + " to SpecialWall");
        // No portal, we can act as a normal wall
        return super.stepOn(dir, player);
    }
}
