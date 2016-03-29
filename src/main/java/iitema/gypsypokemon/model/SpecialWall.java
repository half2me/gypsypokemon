package iitema.gypsypokemon.model;

import iitema.gypsypokemon.Reflector;

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
        Reflector.start();

        Portal.set(color, this, dir.getOpposite());

        Reflector.end();
        return true;
    }

    @Override
    public boolean placeOn(Direction dir, ItemInterface item) {
        Reflector.start();

        Portal portal = Portal.get(this, dir.getOpposite());

        boolean ret;

        if (Reflector.ask("Van portál a falon?")) {
            // if (portal != null) {
            // Needs to re-route through portal
            FieldInterface linkedField = portal.link();
            if (Reflector.ask("Létezik másik portál?")) {
                //if (linkedField != null) {
                ret = linkedField.placeOn(portal.opposite().side, item);
                Reflector.end();
                return ret;
            }
        }
        // No portal, we can act as a normal wall
        ret = super.placeOn(dir, item);

        Reflector.end();
        return ret;
    }

    @Override
    public ItemInterface getItem(Direction dir){
        Reflector.start();

        Portal portal = Portal.get(this, dir.getOpposite());

        ItemInterface ret;

        if (Reflector.ask("Van portál a falon?")) {
        //if (portal != null) {
            // Needs to re-route through portal
            FieldInterface linkedField = portal.link();

            if (Reflector.ask("Létezik másik portál?")) {
            //if (linkedField != null) {
                ret =  linkedField.getItem(portal.opposite().side);
                Reflector.end();
                return ret;
            }
        }

        // No portal, we can act as a normal wall
        ret =  super.getItem(dir);

        Reflector.end();
        return ret;
    }


    /**
     * Remove the item on the field (if any)
     *
     * @return true on removed item, false if there is no item to remove
     */
    @Override
    public boolean removeItem(Direction dir) {
        Reflector.start();
        boolean ret;

        Portal portal = Portal.get(this, dir.getOpposite());

        if (Reflector.ask("Van portál a falon?")) {
        //if (portal != null) {
            // Needs to re-route through portal
            FieldInterface linkedField = portal.link();

            if (Reflector.ask("Létezik másik portál?")) {
            //if (linkedField != null) {
                ret =  linkedField.removeItem(portal.opposite().side);
                Reflector.end();
                return ret;
            }
        }
        // No portal, we can act as a normal wall
        ret =  super.removeItem(dir);

        Reflector.end();
        return ret;
    }

    /**
     * Try to step on a field
     *
     * @param dir    direction the player is facing
     * @param player the player that is stepping on the field
     */
    @Override
    public boolean stepOn(Direction dir, PlayerInterface player) {
        Reflector.start();

        boolean ret;

        Portal portal = Portal.get(this, dir.getOpposite());

        if (Reflector.ask("Van portál a falon?")) {
        //if (portal != null) {
            // Needs to re-route through portal
            FieldInterface linkedField = portal.link();

            if (Reflector.ask("Létezik másik portál?")) {
            //if (linkedField != null) {

                if(!Reflector.ask("Ugyanabba az irányba néz a játékos, mintha most jött volna ki a csillagkapuból?")) {
                // /if(dir != portal.opposite().side) {
                    player.step(portal.opposite().side);
                }

                ret =  linkedField.stepOn(portal.opposite().side, player);
                Reflector.end();
                return ret;
            }
        }
        // No portal, we can act as a normal wall
        ret =  super.stepOn(dir, player);

        Reflector.end();
        return ret;
    }
}