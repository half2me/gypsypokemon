package iitema.gypsypokemon.model;

/**
 * A field that can hold items or the player itself.
 */
public interface ContainerFieldInterface extends FieldInterface {

    /**
     * Deletes reference to contained entity.
     */
    void removeContent();
}
