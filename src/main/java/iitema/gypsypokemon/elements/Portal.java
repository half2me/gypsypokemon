package iitema.gypsypokemon.elements;

import iitema.gypsypokemon.elements.blocks.FieldInterface;

import java.util.HashMap;
import java.util.Map;

public class Portal {
    private static HashMap<Color, Portal> portals = new HashMap<Color, Portal>();

    public FieldInterface field;

    public Direction side;

    public Color color;

    public static void set(Color color, FieldInterface field, Direction side) {
        Portal.portals.put(color, new Portal(field, side, color));
    }

    public static Portal get(Color color) {
        return Portal.portals.get(color);
    }

    public static Portal get(FieldInterface field) {
        Portal p = null;
        for (Map.Entry<Color, Portal> e : Portal.portals.entrySet()) {
            if (e.getValue().field == field) {
                p = e.getValue();
            }
        }
        return p;
    }

    public static Portal get(FieldInterface field, Direction side) {
        Portal p = null;
        for (Map.Entry<Color, Portal> e : Portal.portals.entrySet()) {
            if (e.getValue().field == field && e.getValue().side == side) {
                p = e.getValue();
            }
        }
        return p;
    }

    public Portal(FieldInterface field, Direction side, Color color) {
        this.field = field;
        this.side = side;
        this.color = color;
    }

    public FieldInterface link() {
        Portal otherPortal = Portal.portals.get(this.color.getOpposite());
        return otherPortal.field.getNeighbor(otherPortal.side);
    }

    public Portal opposite() {
        return Portal.portals.get(this.color.getOpposite());
    }
}
