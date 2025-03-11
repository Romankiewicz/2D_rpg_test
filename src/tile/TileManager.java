package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.util.Objects;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tiles;

    public TileManager(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
        tiles = new Tile[10];

        getTileImage();
    }

    public void getTileImage() {

        try {

            tiles[0] = new Tile();
            tiles[0].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Test_Gras_Tile.png")));

            tiles[1] = new Tile();
            tiles[1].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Test_Sand_Tile.png")));

            tiles[2] = new Tile();
            tiles[2].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Test_Wall_Tile.png")));

            tiles[3] = new Tile();
            tiles[3].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Test_Water_Tile.png")));

            tiles[4] = new Tile();
            tiles[4].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/Test_Black_Tile.png")));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        g2.drawImage(tiles[0].image, 0, 0, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
