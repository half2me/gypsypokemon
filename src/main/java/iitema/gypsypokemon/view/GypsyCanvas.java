package iitema.gypsypokemon.view;

import iitema.gypsypokemon.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class GypsyCanvas extends JPanel
{
    Game game;
    BufferedImage wall;

    public GypsyCanvas(Game g)
    {
        super();

        game = g;

        try {
            wall = ImageIO.read(new File("assets\\wall.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setSize(new Dimension(100, 100));
    }

    public Dimension getMinimumSize() {
        return new Dimension(100, 100);
    }

    public Dimension getMaximumSize() {
        return new Dimension(100, 100);
    }

    public Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(wall, 0, 0, null);

    }
}
