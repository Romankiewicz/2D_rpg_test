package tile;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Objects;

public class TileManager {

    GamePanel gamePanel;

    public Tile[] tile;

    public int[][] mapTileNum;

    public TileManager(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
        tile = new Tile[99];
        mapTileNum = new int[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        getTileImage();
        loadMap("/maps/World_Map_V1");
    }

    public void getTileImage() {

            //GRASS
            setup(10, "grass/Grass_0", false);
            setup(11, "grass/Grass_1", false);
            setup(12, "grass/Grass_2", false);
            setup(13, "grass/Grass_3", false);

            //ROADS
            setup(20, "road/Road_Horizontal", false);
            setup(21, "road/Road_Vertical", false);
            setup(22, "road/T-Cross_Up", false);
            setup(23, "road/T-Cross_Down", false);
            setup(24, "road/T-Cross_Left", false);
            setup(25, "road/T-Cross_Right", false);

            //WALLS
            setup(30, "wall/Wall_Horizontal", true);

            //WATER
            setup(40, "water/Water_Center_1", true);
            setup(41, "water/Water_Center_2", true);
            setup(42, "water/Water_Top", true);
            setup(43, "water/Water_left", true);
            setup(44, "water/Water_Bottom", true);
            setup(45, "water/Water_right", true);
            setup(46, "water/Water_Top_Left", true);
            setup(47, "water/Water_Top_Right", true);
            setup(48, "water/Water_Bottom_left", true);
            setup(49, "water/Water_Bottom_Right", true);
            setup(50, "water/Water_Top_Left_1", true);
            setup(51, "water/Water_Top_Right_1", true);
            setup(52, "water/Water_Bottom_Left_1", true);
            setup(53, "water/Water_Bottom_Right_1", true);

            //TREES
            setup(60, "tree/Tree_1", true);
            setup(61, "tree/Stump", true);
            setup(62, "tree/Bush_1", true);
    }

    public void setup(int index, String imagePath, boolean collision) {

        UtilityTool utilityTool = new UtilityTool();

        try {

            tile[index] = new Tile();
            tile[index].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/" + imagePath + ".png")));
            tile[index].image = utilityTool.scaledImage(tile[index].image, gamePanel.tileSize, gamePanel.tileSize);
            tile[index].collision = collision;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadMap(String filePath) {

        try {

            InputStream inputStream = getClass().getResourceAsStream(filePath + ".txt");
            assert inputStream != null;
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            int row = 0;

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String[] numbers = line.split(" ");

                for (int col = 0; col < gamePanel.maxWorldCol; col++) {
                    int number = Integer.parseInt(numbers[col]);
                    mapTileNum[col][row] = number;
                }
                row++;
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

        int worldCol = 0;
        int worldRow = 0;


        while (worldCol < gamePanel.maxWorldCol && worldRow < gamePanel.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gamePanel.tileSize;
            int worldY = worldRow * gamePanel.tileSize;
            int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
            int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

            if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX && worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX && worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY && worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            worldCol++;

            if (worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
