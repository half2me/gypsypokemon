package iitema.gypsypokemon.elements.blocks;

public interface PlayerInterface extends BlockInterface{
    public void move(int direction);
    public void changePostition(FieldInterface field);
}
