package iitema.gypsypokemon.view;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.model.Direction;
import iitema.gypsypokemon.model.FieldInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
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
            sprites.put("ground", ImageIO.read(new File("assets\\ground.png")));
            sprites.put("special-wall", ImageIO.read(new File("assets\\special-wall.png")));
            sprites.put("abyss", ImageIO.read(new File("assets\\abyss.png")));
            sprites.put("door-open", ImageIO.read(new File("assets\\door-open.png")));
            sprites.put("door-closed", ImageIO.read(new File("assets\\door-closed.png")));
            sprites.put("scale", ImageIO.read(new File("assets\\scale.png")));
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
                String spriteName = field.sprite();
                if (spriteName.startsWith("door")) {
                    int oIndex = spriteName.lastIndexOf("-");
                    String orientation = spriteName.substring(oIndex + 1);
                    if (orientation.equals("left") || orientation.equals("right")) {
                        AffineTransform at = new AffineTransform();
                        at.translate(16, 16);
                        at.rotate(Math.PI/2);
                        at.translate(-16, -16);
                        at.translate(y * 32, -x * 32);
                        spriteName = spriteName.substring(0, oIndex);
                        ((Graphics2D) g).drawImage(sprites.get(spriteName), at, null);
                    }
                } else {
                    g.drawImage(sprites.get(spriteName), x * 32, y * 32, null);
                }
                x++;
            }
            y++;
            x = 0;
        }
    }
}
