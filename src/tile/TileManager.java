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

        try {

            //GRASS
            tile[10] = new Tile();
            tile[10].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass" +
                    "/Grass_0.png")));
            tile[11] = new Tile();
            tile[11].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass" +
                    "/Grass_1.png")));
            tile[12] = new Tile();
            tile[12].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass" +
                    "/Grass_2.png")));
            tile[13] = new Tile();
            tile[13].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles/grass" +
                    "/Grass_3.png")));

            //ROADS
            tile[20] = new Tile();
            tile[20].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/road/Road_Horizontal.png")));

            tile[21] = new Tile();
            tile[21].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/road/Road_Vertical.png")));

            tile[22] = new Tile();
            tile[22].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/road/T-Cross_Up.png")));

            tile[23] = new Tile();
            tile[23].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/road/T-Cross_Down.png")));

            tile[24] = new Tile();
            tile[24].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/road/T-Cross_Left.png")));

            tile[25] = new Tile();
            tile[25].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/road/T-Cross_Right.png")));

            //WALLS
            tile[30] = new Tile();
            tile[30].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/wall/Wall_Horizontal.png")));
            tile[30].collision = true;

            tile[31] = new Tile();
            tile[31].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/wall/Door.png")));
            tile[31].collision = true;

            tile[32] = new Tile();
            tile[32].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/wall/Door_Open.png")));


            //WATER
            tile[40] = new Tile();
            tile[40].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Center_1.png")));
            tile[40].collision = true;

            tile[41] = new Tile();
            tile[41].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Center_2.png")));
            tile[41].collision = true;

            tile[42] = new Tile();
            tile[42].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Top.png")));
            tile[42].collision = true;

            tile[43] = new Tile();
            tile[43].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Left.png")));
            tile[43].collision = true;

            tile[44] = new Tile();
            tile[44].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Bottom.png")));
            tile[44].collision = true;

            tile[45] = new Tile();
            tile[45].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Right.png")));
            tile[45].collision = true;

            tile[46] = new Tile();
            tile[46].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Top_Left.png")));
            tile[46].collision = true;

            tile[47] = new Tile();
            tile[47].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Top_Right.png")));
            tile[47].collision = true;

            tile[48] = new Tile();
            tile[48].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Bottom_Left.png")));
            tile[48].collision = true;

            tile[49] = new Tile();
            tile[49].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Bottom_Right.png")));
            tile[49].collision = true;

            tile[50] = new Tile();
            tile[50].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Top_Left_1.png")));
            tile[50].collision = true;

            tile[51] = new Tile();
            tile[51].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Top_Right_1.png")));
            tile[51].collision = true;

            tile[52] = new Tile();
            tile[52].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Bottom_Left_1.png")));
            tile[52].collision = true;

            tile[53] = new Tile();
            tile[53].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/water/Water_Bottom_Right_1.png")));
            tile[53].collision = true;


            //TREES
            tile[60] = new Tile();
            tile[60].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/tree/Tree_1.png")));
            tile[60].collision = true;

            tile[61] = new Tile();
            tile[61].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/tree/Stump.png")));
            tile[61].collision = true;

            tile[62] = new Tile();
            tile[62].image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/tiles" +
                    "/tree/Bush_1.png")));
            tile[62].collision = true;

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

            if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                    worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                    worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                    worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {

                g2.drawImage(tile[tileNum].image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
            }

            worldCol++;

            if (worldCol == gamePanel.maxWorldCol) {
                worldCol = 0;
                worldRow++;
            }
        }
    }
}
