package iitema.gypsypokemon;

import iitema.gypsypokemon.model.*;

import java.lang.reflect.Field;
import java.sql.Ref;
import java.util.Scanner;

public class Game {

    private FieldInterface field = new Ground();
    private Player player = new Player(this, field);

    public Game() {
        FieldInterface f = this.field;
        for (int i = 0; i < 10; i++) {
            f.setNeighbor(Direction.RIGHT, new Abyss());
            f = f.getNeighbor(Direction.RIGHT);
        }
    }

    public void startGame() {
        // inicializálások ide kellenek

        Reflector.out("Üdv a teszt programban!");
        while(true){
            Reflector.out(
                    "\nVálassz a teszt esetek közül:\n" +
                    "1: két lépés felfelé\n" +
                    "0: kilépés \n");

            Scanner reader = new Scanner(System.in);
            String answer = reader.nextLine();
            try{
                // String-et nem fogad el a switch
                int choice = Integer.parseInt(answer);
                switch(choice) {
                    case 1: {
                        /*
                        Két lépés felfelé

                        a55-ről indulunk mindig, ahol [5,5] a koordináta
                        így néz ki:
                                a53
                                a54
                            a45 a55 a65
                                a56
                         */
                        FieldInterface a55 = new Ground();
                        FieldInterface a54 = new Ground();
                        FieldInterface a53 = new Ground();
                        a55.setNeighbor(Direction.UP, a54);
                        a54.setNeighbor(Direction.UP, a53);
                        player = new Player(this, a55);

                        Reflector.on();
                        player.step(Direction.UP);
                        player.step(Direction.UP);
                        Reflector.off();
                    } continue;

                    case 2: {

                    } continue;

                    case 10: {
                        // Put down/pickup box from ground

                        FieldInterface g1 = new Ground();
                        FieldInterface g2 = new Ground();
                        g1.setNeighbor(Direction.RIGHT, g2);
                        PlayerInterface player = new Player(this, g1);
                        g2.placeOn(Direction.UP, new Box());

                        Reflector.on();

                        player.action();

                        Reflector.off();

                    } continue;

                    // Kilépés
                    case 0:
                        break;
                }
            } catch(Exception e) {
                Reflector.out("Rossz bemenet");
                continue;
            }
            break;
        }
        Reflector.off();

    }

    public void endGame() {
        Reflector.start();
        Reflector.out("Meghaltál!");
        Reflector.end();
    }

    public void pauseGame() {

    }

    public static void main(String[] args) {
        Game game = new Game();

        // ebben van a loop a teszt esetekkel
        game.startGame();

    }
}
