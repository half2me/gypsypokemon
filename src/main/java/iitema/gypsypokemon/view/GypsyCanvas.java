package iitema.gypsypokemon.view;

import iitema.gypsypokemon.Game;
import iitema.gypsypokemon.model.Direction;
import iitema.gypsypokemon.model.FieldInterface;
import iitema.gypsypokemon.model.PlayerInterface;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GypsyCanvas extends JPanel
{
    private Game game;
    private Map<String, BufferedImage> sprites = new HashMap<String, BufferedImage>();

    GypsyCanvas(Game g)
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
            sprites.put("player-full", ImageIO.read(new File("assets\\player-full.png")));
            sprites.put("player-empty", ImageIO.read(new File("assets\\player-empty.png")));
            sprites.put("zpm", ImageIO.read(new File("assets\\zpm.png")));
            sprites.put("box", ImageIO.read(new File("assets\\box.png")));
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
                drawSprite(g, field.sprite(), x, y);
                for (PlayerInterface player : game.getPlayers()) {
                    if (player != null && player.getField() == field) {
                        drawSprite(g, player.sprite(), x, y);
                    }
                }
                x++;
            }
            y++;
            x = 0;
        }
    }

    private void drawSprite(Graphics g, String spriteName, int x, int y) {
        String itemSpriteName = null;
        if (spriteName.contains(":")) {
            int i = spriteName.indexOf(':');
            itemSpriteName = spriteName.substring(i + 1);
            spriteName = spriteName.substring(0, i);
        }
        if (spriteName.startsWith("door") || spriteName.startsWith("player")) {
            int oIndex = spriteName.lastIndexOf("-");
            String orientation = spriteName.substring(oIndex + 1);
            AffineTransform at = new AffineTransform();
            at.translate(x * 32, y * 32);
            at.translate(16, 16);
            if (orientation.equals("left")) {
                at.rotate(Math.PI / 2);
            } else if (orientation.equals("right")) {
                at.rotate(0.5 * Math.PI);
            } else if (orientation.equals("down")) {
                at.rotate(Math.PI);
            }
            at.translate(-16, -16);
            spriteName = spriteName.substring(0, oIndex);
            ((Graphics2D) g).drawImage(sprites.get(spriteName), at, null);
        } else {
            g.drawImage(sprites.get(spriteName), x * 32, y * 32, null);
        }
        if (itemSpriteName != null) {
            g.drawImage(sprites.get(itemSpriteName), x * 32, y * 32, null);
        }
    }
}
