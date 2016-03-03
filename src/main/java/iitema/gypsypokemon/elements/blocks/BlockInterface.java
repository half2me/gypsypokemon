package iitema.gypsypokemon.elements.blocks;

import iitema.gypsypokemon.elements.ProjectileInterface;

public interface BlockInterface {
    public void stepOn(PlayerInterface player);
    public void shootAt(ProjectileInterface payload);
}
