package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Entity {

    public int worldX, worldY;
    public int speed;

    GamePanel gamePanel;

    public BufferedImage standingUp;
    public BufferedImage[] standingDown = new BufferedImage[10];
    public BufferedImage[] standingLeft = new BufferedImage[10];
    public BufferedImage[] standingRight = new BufferedImage[10];


    public BufferedImage[] up = new BufferedImage[10];
    public BufferedImage[] down = new BufferedImage[10];
    public BufferedImage[] left = new BufferedImage[10];
    public BufferedImage[] right = new BufferedImage[10];

    public String direction;
    public String lastDirection;

    public int spriteCounter = 0;
    public int spriteNum = 0;
    public int moveCounter = 0;
    public int movingSpriteNum = 0;

    public Rectangle solidArea = new Rectangle(0, 0, 72, 72);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public Entity(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
    }

    public BufferedImage setup(String packageName, String imageName) {

        UtilityTool utilityTool = new UtilityTool();
        BufferedImage image = null;

        try {

            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/" + packageName + "/" + imageName + ".png")));
            image = utilityTool.scaledImage(image, gamePanel.tileSize, gamePanel.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
