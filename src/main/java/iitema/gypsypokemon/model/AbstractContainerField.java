package iitema.gypsypokemon.model;


public abstract class AbstractContainerField implements ContainerFieldInterface {
    @Override
    public FieldInterface getNeighbor(Direction direction) {
        return null;
    }

    @Override
    public void removeContent() {

    }

    @Override
    public void shootAt(ProjectileInterface projectile) {

    }
}
