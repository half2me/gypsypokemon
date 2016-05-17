package iitema.gypsypokemon.model;

import java.util.HashMap;
import java.util.Map;

public class Portal {
    private static HashMap<Color, Portal> portals = new HashMap<Color, Portal>();

    public FieldInterface field;
    public Direction side;
    public Color color;

    /**
     * Set one of the portals
     *
     * @param color color of the portal
     * @param field field the portal is on
     * @param side side it is valid on
     */
    public static void set(Color color, FieldInterface field, Direction side) {
        Portal old = get(field, side);
        if (old != null) {
            portals.remove(old.color);
        }
        Portal.portals.put(color, new Portal(field, side, color));
    }

    /**
     * Get a portal by its color
     *
     * @param color color of the portal
     * @return portal
     */
    public static Portal get(Color color) {
        return Portal.portals.get(color);
    }

    /**
     * Get a portal by the field it is on
     *
     * @param field field
     * @return portal
     */
    public static Portal get(FieldInterface field) {
        Portal p = null;
        for (Map.Entry<Color, Portal> e : Portal.portals.entrySet()) {
            if (e.getValue().field == field) {
                p = e.getValue();
            }
        }
        return p;
    }

    /**
     * Get a portal by the field and side of the field it is on
     *
     * @param field field the portal is one
     * @param side side of the field the portal is on
     * @return portal
     */
    public static Portal get(FieldInterface field, Direction side) {
        Portal p = null;
        for (Map.Entry<Color, Portal> e : Portal.portals.entrySet()) {
            if (e.getValue().field == field && e.getValue().side == side) {
                p = e.getValue();
            }
        }
        return p;
    }

    /**
     * Portal constructor
     *
     * @param field field
     * @param side side
     * @param color color of the portal
     */
    private Portal(FieldInterface field, Direction side, Color color) {
        this.field = field;
        this.side = side;
        this.color = color;
    }

    /**
     * Field that the a portal links to
     *
     * This is the field that is pointed to by the opposite portal on the side it is on
     * @return field
     */
    public FieldInterface link() {
        Portal otherPortal = Portal.portals.get(this.color.getOpposite());
        return otherPortal != null ? otherPortal.field.getNeighbor(otherPortal.side) : null;
    }

    /**
     * Get the opposite portal
     *
     * @return opposite portal
     */
    public Portal opposite() {
        return Portal.portals.get(this.color.getOpposite());
    }

    /**
     * Removes all portals
     */
    public static void clear() {
        portals.clear();
    }
}
