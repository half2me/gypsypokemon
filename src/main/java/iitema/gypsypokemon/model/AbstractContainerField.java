package iitema.gypsypokemon.model;


public abstract class AbstractContainerField implements ContainerFieldInterface {
    private FieldInterface neighborLeft = null;
    private FieldInterface neighborUp = null;
    private FieldInterface neighborRigth = null;
    private FieldInterface neighborDown = null;
    private ObstacleInterface content = null;

    @Override
    public FieldInterface getNeighbor(Direction direction) {
        return null;
    }

    @Override
    public void removeContent() {

    }

    @Override
    public void shootAt(Projectile projectile) {

    }
}
