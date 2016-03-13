package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.Color;
import iitema.gypsypokemon.elements.Direction;

import java.util.HashMap;
import java.util.Map;

public class SpecialWall extends Wall {

    private static HashMap<Color, FieldInterface> portalsField = new HashMap<Color, FieldInterface>();
    private static HashMap<Color, Direction> portalsSide = new HashMap<Color, Direction>();

    /**
     * Shoot at a field
     *
     * @param color color of projectile
     * @param dir   direction projectile is travelling
     */
    @Override
    public boolean shootAt(Color color, Direction dir) {
        SpecialWall.portalsField.put(color, this);
        SpecialWall.portalsSide.put(color, dir.getOpposite());
        return true;
    }

    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        if (this.checkPortal(dir.getOpposite())) {
            // Needs to re-route through portal
            Color c = null;
            for (Map.Entry<Color, FieldInterface> e : SpecialWall.portalsField.entrySet()) {
                if (e.getValue() == this) {
                    c = e.getKey();
                }
            }
            return SpecialWall.portalsField.get(c.getOpposite()).placeOn(SpecialWall.portalsSide.get(c), item);
        }
        // No portal, we can act as a normal wall
        return super.placeOn(dir, item);
    }

    /**
     * Remove the item on the field (if any)
     *
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    public boolean removeItem(Direction dir) {
        if (this.checkPortal(dir.getOpposite())) {
            // Needs to re-route through portal
            Color c = null;
            for (Map.Entry<Color, FieldInterface> e : SpecialWall.portalsField.entrySet()) {
                if (e.getValue() == this) {
                    c = e.getKey();
                }
            }
            return SpecialWall.portalsField.get(c.getOpposite()).removeItem(SpecialWall.portalsSide.get(c));
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
        if (this.checkPortal(dir.getOpposite())) {
            // Needs to re-route through portal
            Color c = null;
            for (Map.Entry<Color, FieldInterface> e : SpecialWall.portalsField.entrySet()) {
                if (e.getValue() == this) {
                    c = e.getKey();
                }
            }
            return SpecialWall.portalsField.get(c.getOpposite()).stepOn(SpecialWall.portalsSide.get(c), player);
        }
        // No portal, we can act as a normal wall
        return super.stepOn(dir, player);
    }

    /**
     * Check if there is an active portal on a side of the wall
     *
     * @param side side
     * @return if there is an active portal or not
     */
    private boolean checkPortal(Direction side) {
        if (SpecialWall.portalsField.containsValue(this)) {
            if (SpecialWall.portalsSide.containsValue(side)) {
                return true;
            }
        }
        return false;
    }
}
