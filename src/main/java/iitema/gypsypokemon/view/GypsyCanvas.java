package iitema.gypsypokemon.view;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.model.Direction;
import iitema.gypsypokemon.model.FieldInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class GypsyCanvas extends JPanel
{
    Game game;
    Map<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();

    public GypsyCanvas(Game g)
    {
        super();

        game = g;

        try {
            sprites.put("wall", ImageIO.read(new File("assets\\wall.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Dimension getMinimumSize() {
        return new Dimension(640, 640);
    }

    public Dimension getMaximumSize() {
        return new Dimension(640, 640);
    }

    public Dimension getPreferredSize() {
        return new Dimension(640, 640);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        int x = 0;
        int y = 0;
        for (FieldInterface row = game.getFields(); row != null; row = row.getNeighbor(Direction.DOWN)) {
            for (FieldInterface field = row; field != null; field = field.getNeighbor(Direction.RIGHT)) {
                g.drawImage(sprites.get(field.sprite()), x * 32, y * 32, null);
                y++;
            }
            x++;
        }
    }
}
