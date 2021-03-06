package iitema.gypsypokemon;

import iitema.gypsypokemon.model.*;
import iitema.gypsypokemon.model.Box;
import iitema.gypsypokemon.model.Color;
import iitema.gypsypokemon.view.GameCanvas;
import iitema.gypsypokemon.view.GameWindow;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;
import java.util.List;

public class Game {

    private FieldInterface field;
    private PlayerInterface[] players = new PlayerInterface[3];
    private Replicator replicator = null;
    private boolean paused = false;
    private GameCanvas canvas;
    private String map;

    public boolean ended = false;

    private Game() { }

    /**
     * Removes the player from the game (if killed)
     *
     * @param dead player
     */
    public void deletePlayer(PlayerInterface dead) {
        for (int i = 0; i < 3; ++i) {
            if (players[i] == dead) {
                players[i] = null;
                if (players[0] == null || players[1] == null) {
                    endGame();
                }
                return;
            }
        }
    }

    /**
     * Loads a map
     *
     * @param name Name of the map
     * @throws IOException
     */
    public void loadMap(String name) throws IOException {
        this.map = name;

        Map<Integer, Door> doors = new HashMap<Integer, Door>();
        List<int[][]> map = new ArrayList<int[][]>();

        // clear map
        this.field = null;
        for (int i = 0; i < 3; ++i) {
            players[i] = null;
        }
        replicator = null;
        Zpm.total = 0;
        Zpm.collected = 0;
        ended = false;
        Portal.clear();
        this.paused = false;

        // parse input into the 'map' variable and load doors
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(name));
            int nColumns = -1;

            String rowStr;
            while ((rowStr = br.readLine()) != null) {
                String[] cells = rowStr.split(";");
                if (nColumns != -1 && nColumns != cells.length) {
                    throw new IOException("Invalid map");
                } else {
                    nColumns = cells.length;
                }

                int[][] row = new int[nColumns][];
                for (int i = 0; i < nColumns; ++i) {
                    String[] ids = cells[i].split("\\.");
                    int[] cell = new int[ids.length];
                    for (int j = 0; j < ids.length; ++j) {
                        cell[j] = Integer.parseInt(ids[j]);
                    }
                    row[i] = cell;

                    if (cell[0] == 5) {
                        doors.put(cell[2], new Door(cell[1] == 0 ? Direction.UP : Direction.RIGHT));
                    }
                }
                map.add(row);
            }
        } catch (IndexOutOfBoundsException e) {
            throw new IOException("Invalid map");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {}
            }
        }

        // create the map
        FieldInterface rowPrev = null;
        for (int[][] row : map) {
            FieldInterface fRow = null;
            FieldInterface fPrev = null;
            for (int [] cell : row) {
                FieldInterface f;
                switch (cell[0]) {
                    case 0:
                        f = new Ground();
                        break;
                    case 1:
                        f = new Abyss();
                        break;
                    case 2:
                        f = new Wall();
                        break;
                    case 3:
                        f = new SpecialWall();
                        break;
                    case 4:
                        f = new Scale(doors.get(cell[1]));
                        break;
                    case 5:
                        f = doors.get(cell[2]);
                        break;
                    case 6:
                        f = new Ground();
                        f.placeOn(Direction.RIGHT, new Box());
                        break;
                    case 7:
                        f = new Ground();
                        f.placeOn(Direction.RIGHT, new Zpm(f, this));
                        Zpm.total++;
                        break;
                    case 8:
                        f = new Ground();
                        players[0] = new Player(this, f, 1);
                        break;
                    case 9:
                        f = new Ground();
                        players[1] = new Player(this, f, 2);
                        break;
                    case 10:
                        f = new Ground();
                        players[2] = replicator = new Replicator(this, f, 3);
                        break;
                    default:
                        throw new IOException("Invalid field identifier");
                }

                // set neighbors
                if (fRow == null) {
                    fRow = f;
                } else {
                    fPrev.setNeighbor(Direction.RIGHT, f);
                    f.setNeighbor(Direction.LEFT, fPrev);
                }
                if (rowPrev != null) {
                    rowPrev.setNeighbor(Direction.DOWN, f);
                    f.setNeighbor(Direction.UP, rowPrev);
                    rowPrev = rowPrev.getNeighbor(Direction.RIGHT);
                }
                fPrev = f;
            }
            if (this.field == null) {
                this.field = fRow;
            }
            rowPrev = fRow;
        }
        if (replicator != null) {
            replicator.start();
        }
        invalidate();
    }

    /**
     * Processes input commands
     */
    private void startGame() {
        class InvalidPlayerException extends Exception {}

        Scanner reader = new Scanner(System.in);
        while (reader.hasNextLine()) {
            try {
                String[] cmd = reader.nextLine().split(" ");
                if (cmd[0].toUpperCase().equals("STEP")) {
                    int index = Integer.parseInt(cmd[1]) - 1;
                    if (index < 0 || index > 2 || players[index] == null) {
                        throw new InvalidPlayerException();
                    }
                    players[index].step(Direction.parse(cmd[2]));
                } else if (cmd[0].toUpperCase().equals("SHOOT")) {
                    int index = Integer.parseInt(cmd[1]) - 1;
                    if (index < 0 || index > 2 || players[index] == null) {
                        throw new InvalidPlayerException();
                    }
                    players[index].shoot(Color.parse(cmd[2]));
                } else if (cmd[0].toUpperCase().equals("ACTION")) {
                    int index = Integer.parseInt(cmd[1]) - 1;
                    if (index < 0 || index > 2 || players[index] == null) {
                        throw new InvalidPlayerException();
                    }
                    players[index].action();
                } else if (cmd[0].toUpperCase().equals("NEW")) {
                    restart();
                } else if (cmd[0].toUpperCase().equals("LOAD")) {
                    Log.disable();
                    loadMap("assets\\" + cmd[1] + ".csv");
                    Log.enable();
                    Log.println("Map loaded");
                } else if (cmd[0].toUpperCase().equals("EXIT")) {
                    return;
                } else {
                    throw new ParseException("Invalid command", 0);
                }
            } catch (ParseException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Not enough paramaters");
            } catch (InvalidPlayerException e) {
                System.out.println("Invalid palyer");
            } catch (IOException e) {
                System.out.println("Error while loading map: " + e.getMessage());
            }
        }
    }

    /**
     * Reloads the last map
     */
    public void restart() {
        try {
            loadMap(map);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * End of the game
     */
    public void endGame() {
        if (replicator != null) {
            replicator.stop();
        }
        ended = true;
    }

    /**
     * Pauses the game
     */
    public void pauseGame() {
        if (!ended) {
        if (replicator != null) {
            if (paused) {
                replicator.start();
            } else {
                replicator.stop();
            }
        }
        paused = !paused;
        }
    }

    /**
     * The game state has changed, needs to be redrawn
     */
    public void invalidate() {
        if (SwingUtilities.isEventDispatchThread()) {
            canvas.repaint();
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    canvas.repaint();
                }
            });
        }
    }

    /**
     *
     * @param c canvas the game is drawn on
     */
    private void setCanvas(GameCanvas c) {
        canvas = c;
    }

    /**
     *
     * @return the top-left field of the map
     */
    public FieldInterface getFields() {
        return field;
    }

    /**
     *
     * @return size 3 array of players
     */
    public PlayerInterface[] getPlayers() {
        return players;
    }

    public static void main(String[] args) {
        Log.disable();
        Game game = new Game();

        GameWindow w = new GameWindow(game);
        game.setCanvas(w.getCanvas());
        try {
            game.loadMap("assets\\map2.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
