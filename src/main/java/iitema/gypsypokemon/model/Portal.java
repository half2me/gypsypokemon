package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Reflector;

import java.sql.Ref;
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
        Reflector.start();

        Portal.portals.put(color, new Portal(field, side, color));

        Reflector.end();
    }

    /**
     * Get a portal by its color
     *
     * @param color color of the portal
     * @return portal
     */
    public static Portal get(Color color) {
        Reflector.start();
        Reflector.end();
        return Portal.portals.get(color);
    }

    /**
     * Get a portal by the field it is on
     *
     * @param field field
     * @return portal
     */
    public static Portal get(FieldInterface field) {
        Reflector.start();

        Portal p = null;
        for (Map.Entry<Color, Portal> e : Portal.portals.entrySet()) {
            if (e.getValue().field == field) {
                p = e.getValue();
            }
        }

        Reflector.end();
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
        Reflector.start();

        Portal p = null;
        for (Map.Entry<Color, Portal> e : Portal.portals.entrySet()) {
            if (e.getValue().field == field && e.getValue().side == side) {
                p = e.getValue();
            }
        }

        Reflector.end();
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
        Reflector.start();

        this.field = field;
        this.side = side;
        this.color = color;

        Reflector.end();
    }

    /**
     * Field that the a portal links to
     *
     * This is the field that is pointed to by the opposite portal on the side it is on
     * @return field
     */
    public FieldInterface link() {
        Reflector.start();

        Portal otherPortal = Portal.portals.get(this.color.getOpposite());
        FieldInterface ret = otherPortal.field.getNeighbor(otherPortal.side);

        Reflector.end();
        return ret;
    }

    /**
     * Get the opposite portal
     *
     * @return opposite portal
     */
    public Portal opposite() {
        Reflector.start();

        Portal ret = Portal.portals.get(this.color.getOpposite());

        Reflector.end();
        return ret;0
    }
}