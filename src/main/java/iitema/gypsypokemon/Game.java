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

        while(true){
            Reflector.out("Válassz a teszt esetek közül:\n" +
                    "1: két lépés felfelé\n" +
                    "2: falra lövés\n" +
                    "3: szakadékba lépés\n" +
                    "4: doboz lerakás/felvétel\n" +
                    "5: ajtó kinyitása mérlegre lépéssel\n" +
                    "6: speciális falra lövés talajon, szakadékon keresztül \n" +
                    "7: Zpm felvétele és győzelem\n" +
                    "0: kilépés\n");

            Scanner reader = new Scanner(System.in);
            String answer = reader.nextLine();
            try{
                // String-et nem fogad el a switch
                int choice = Integer.parseInt(answer);
                FieldInterface a55 = new Ground();
                player = new Player(this, a55);
                switch(choice) {
                    case 1: {
                       /*
                       a55-ről indulunk mindig, ahol [5-sor,5-oszlop] a koordináta
                       így néz ki:
                           a35
                           a45
                       a54 a55 a56
                           a65
                       */

                        FieldInterface a45 = new Ground();
                        FieldInterface a35 = new Ground();
                        a55.setNeighbor(Direction.UP, a45);
                        a45.setNeighbor(Direction.UP, a35);

                        Reflector.on();
                        player.step(Direction.UP);
                        player.step(Direction.UP);
                        Reflector.off();
                    } continue;

                    //sima falra lövés
                    case 2: {
                        FieldInterface a56 = new Wall();
                        a55.setNeighbor(Direction.RIGHT, a56);
                        Reflector.on();
                        player.shoot(Color.BLUE);
                        Reflector.off();
                    } continue;

                    //szakadékba lépés
                    case 3: {
                        FieldInterface a56 = new Abyss();
                        a55.setNeighbor(Direction.RIGHT, a56);
                        Reflector.on();
                        player.step(Direction.RIGHT);
                        Reflector.off();
                    } continue;

                    //doboz le/fel
                    case 4: {
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

                    //mérlegre lépés, majd mérlegről ellépés
                    case 5: {
                        Door d1 = new Door(Direction.RIGHT);
                        FieldInterface a56 = new Scale(d1);
                        FieldInterface a57 = new Ground();
                        a55.setNeighbor(Direction.RIGHT, a56);
                        a56.setNeighbor(Direction.RIGHT, a57);
                        Reflector.on();
                        a56.stepOn(Direction.RIGHT, player);
                        a57.stepOn(Direction.RIGHT, player);
                        Reflector.off();
                    } continue;

                    //Lövés talajon, szakadékon keresztül speciális falra
                    case 6: {
                        FieldInterface a56 = new Ground();
                        FieldInterface a57 = new Abyss();
                        FieldInterface a58 = new SpecialWall();
                        a55.setNeighbor(Direction.RIGHT, a56);
                        a56.setNeighbor(Direction.RIGHT, a57);
                        a57.setNeighbor(Direction.RIGHT, a58);
                        Reflector.on();
                        player.shoot(Color.BLUE);
                        Reflector.off();
                    }
                    continue;

                    //zpm felvétele
                    case 7: {
                        FieldInterface a56 = new Ground();
                        a55.setNeighbor(Direction.RIGHT, a56);
                        a56.placeOn(Direction.RIGHT, new Zpm(a56, this));

                        Reflector.on();
                        player.action();
                        Reflector.off();
                    } continue;

                    // Kilépés
                    case 0: break;
                }
            } catch(Exception e) {
                Reflector.out("Rossz bemenet");
                continue;
            }
            break;
        }
    }




    public void endGame() {
        Reflector.start();
        Reflector.out("A játéknak vége!");
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
