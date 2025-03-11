package tile;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gamePanel;
    Tile[] tile;

    int[][] mapTileNum;

    public TileManager(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
        tile = new Tile[99];
        mapTileNum = new int[gamePanel.maxScreenCol][gamePanel.maxScreenRow];

        getTileImage();
        loadMap();
    }

    public void getTileImage() {

        try {

            tile[10] = new Tile();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/Test_Gras_Tile.png")));

            tile[11] = new Tile();
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/Test_Sand_Tile.png")));

            tile[12] = new Tile();
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/Test_Wall_Tile.png")));

            tile[13] = new Tile();
            tile[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/Test_Water_Tile.png")));

            tile[14] = new Tile();
            tile[14].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/Test_Black_Tile.png")));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap() {

        try {

            InputStream inputStream = getClass().getResourceAsStream("/maps/Map_V1.txt");
            assert inputStream != null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int col = 0;
            int row = 0;

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] numbers = line.split(" ");

                for (col = 0; col < gamePanel.maxScreenCol; col++) {
                    int number = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = number;
                }
                row++;
            }

//            while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {
//
//                String line = bufferedReader.readLine();
//
//                while (col < gamePanel.maxScreenCol) {
//
//                    String[] numbers = line.split("-");
//
//                    int number = Integer.parseInt(numbers[col]);
//
//                    mapTileNum[col][row] = number;
//                    col++;
//
//                    if (col == gamePanel.maxScreenCol) {
//                        col = 0;
//                        row++;
//                    }
//                }
//            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;

        while (col < gamePanel.maxScreenCol && row < gamePanel.maxScreenRow) {

            int tileNum = mapTileNum[col][row];

            if (tileNum >= 0 && tileNum < tile.length) {
                g2.drawImage(tile[tileNum].image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);


            } else {
                System.out.println("Invalid Tile-Index: " + tileNum);
            }
            col++;
            x += gamePanel.tileSize;
            if (col == gamePanel.maxScreenCol) {
                col = 0;
                x = 0;
                row++;
                y += gamePanel.tileSize;
            }
        }
    }
}
