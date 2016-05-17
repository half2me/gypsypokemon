package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Log;

public class SpecialWall extends Wall {
    /**
     * Shoot at the wall, creates a portal on the side
     *
     * @param color color of projectile
     * @param dir   direction projectile is travelling
     * @return true on shot absorbed, false on shot through
     */
    @Override
    synchronized public boolean shootAt(Color color, Direction dir) {
        Portal.set(color, this, dir.getOpposite());
        Log.println(color.toString() + " Portal created on Special Wall's " + dir.getOpposite() + " side");
        return true;
    }

    /**
     * Reroutes placed item if wormhole is present, otherwise item cannot be placed
     *
     * @param dir Direction from the placer's view
     * @param item item
     * @return True if the item could be placed
     */
    @Override
    synchronized public boolean placeOn(Direction dir, ItemInterface item) {
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

    /**
     *
     * @return sprite name when there are no portals on the wall
     */
    @Override
    protected String defaultSprite() {
        return "special-wall";
    }

    /**
     * Return the name of the sprite
     *
     * @return name of the sprite
     */
    @Override
    public String sprite() {
        String sprite = this.defaultSprite();
        for (Direction dir : Direction.all()) {
            Portal portal = Portal.get(this, dir);
            if (portal != null) {
                sprite += ":" + portal.color.toString().toLowerCase() + "-" + portal.side.toString().toLowerCase();
            }
        }
        return sprite;
    }

    /**
     * Returns the topmost item from the field on the other side of the portal
     * @param dir
     * @return item
     */
    @Override
    synchronized public ItemInterface getItem(Direction dir){
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
     * Removes the item from the field on the other side of the portal
     *
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    synchronized public boolean removeItem(Direction dir) {
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
     * Try to step in the portal, teleports player to the other side if portal of opposing color is present
     *
     * @param dir    direction the player is facing
     * @param player the player that is stepping on the field
     */
    @Override
    synchronized public boolean stepOn(Direction dir, PlayerInterface player) {
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
