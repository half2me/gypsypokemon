package iitema.gypsypokemon.elements.blocks;

public interface FieldInterface extends BlockInterface{
    public void placeOn(MovableInterface movable);
    public FieldInterface getNeighbor(int direction);
}
