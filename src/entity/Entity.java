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
    public int npcSpriteNum = 0;
    public int npcSpriteCounter = 0;
    public int actionCounter = 0;
    public int dialogueCounter = 0;

    public Rectangle solidArea = new Rectangle(0, 0, 72, 72);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public String[] dialogues = new String[20];

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

    public void speak() {}

    public void setAction() {}

    public void update() {

        setAction();

        collisionOn = false;
        gamePanel.collisionChecker.checkTile(this);
        gamePanel.collisionChecker.checkObjectCollision(this, false);
        gamePanel.collisionChecker.checkPlayerCollision(this);

        if (!collisionOn) {
            switch (direction) {
                case "up":
                    worldY -= speed;
                    break;
                case "down":
                    worldY += speed;
                    break;
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
        }
        npcSpriteCounter++;
        if (npcSpriteCounter > 8) {
            switch (npcSpriteNum) {
                case 0 -> npcSpriteNum = 1;
                case 1 -> npcSpriteNum = 2;
                case 2 -> npcSpriteNum = 0;
            }
            npcSpriteCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

        if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {

            image = switch (direction) {
                case "up" -> up[npcSpriteNum];
                case "down" -> down[npcSpriteNum];
                case "left" -> left[npcSpriteNum];
                case "right" -> right[npcSpriteNum];
                default -> null;
            };


            g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}
