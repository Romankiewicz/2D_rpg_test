package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {

        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth/2 - gamePanel.tileSize/2;
        screenY = gamePanel.screenHeight/2 - gamePanel.tileSize/2;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gamePanel.tileSize * 10;
        worldY = gamePanel.tileSize * 12;
        speed = 4;
        direction = "standing";
        lastDirection = "down";
    }

    public void getPlayerImage() {

        try {

            standingUp = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/standing/back" +
                    "/Link_Back.png")));

            for (int i = 0; i < 10; i++) {
                standingDown[i] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/standing/front/Link_Front_" +
                        (i + 1) + ".png")));
            }

            for (int i = 0; i < 10; i++) {
                standingLeft[i] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/standing" +
                        "/left/Link_Left_" +
                        (i + 1) + ".png")));
            }

            for (int i = 0; i < 10; i++) {
                standingRight[i] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/standing" +
                        "/right/Link_Right_" +
                        (i + 1) + ".png")));
            }

            for (int i = 0; i < 10; i++) {
                up[i] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walking/up" +
                        "/Link_Walk_Up_" + (i + 1) + ".png")));
            }

            for (int i = 0; i < 10; i++) {
                down[i] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walking/down" +
                        "/Link_Walk_Down_" + (i + 1) + ".png")));
            }

            for (int i = 0; i < 10; i++) {
                left[i] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walking/left" +
                        "/Link_Walk_Left_" + (i + 1) + ".png")));
            }

            for (int i = 0; i < 10; i++) {
                right[i] = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/player/walking/right" +
                        "/Link_Walk_Right_" + (i + 1) + ".png")));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyHandler.upPressed) {
            direction = "up";
            lastDirection = "up";
            worldY -= speed;
        } else if (keyHandler.downPressed) {
            direction = "down";
            lastDirection = "down";
            worldY += speed;
        } else if (keyHandler.leftPressed) {
            direction = "left";
            lastDirection = "left";
            worldX -= speed;
        } else if (keyHandler.rightPressed) {
            direction = "right";
            lastDirection = "right";
            worldX += speed;
        } else if (keyHandler.upReleased || keyHandler.downReleased || keyHandler.leftReleased || keyHandler.rightReleased) {
            direction = "standing";
        }

        spriteCounter++;
        if (spriteCounter > 5) {
            switch(spriteNum) {
                case 1 -> spriteNum = 2;
                case 2 -> spriteNum = 3;
                case 3 -> spriteNum = 4;
                case 4 -> spriteNum = 5;
                case 5 -> spriteNum = 6;
                case 6 -> spriteNum = 7;
                case 7 -> spriteNum = 8;
                case 8 -> spriteNum = 9;
                case 9 -> spriteNum = 10;
                case 10 -> spriteNum = 1;
            }
            spriteCounter = 0;
        }

        moveCounter++;
        if (moveCounter > 5) {
            switch (movingSpriteNum) {
                case 1 -> movingSpriteNum = 2;
                case 2 -> movingSpriteNum = 3;
                case 3 -> movingSpriteNum = 4;
                case 4 -> movingSpriteNum = 5;
                case 5 -> movingSpriteNum = 6;
                case 6 -> movingSpriteNum = 7;
                case 7 -> movingSpriteNum = 8;
                case 8 -> movingSpriteNum = 9;
                case 9 -> movingSpriteNum = 10;
                case 10 -> movingSpriteNum = 1;
            }
            moveCounter = 0;
        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        if (direction.equals("standing")) {
            image = switch (lastDirection) {
                case "up" -> standingUp;
                case "down" -> standingDown[spriteNum - 1];
                case "left" -> standingLeft[spriteNum - 1];
                case "right" -> standingRight[spriteNum - 1];
                default -> image;
            };
        }

        image = switch (direction) {
            case "up" -> up[movingSpriteNum - 1];
            case "down" -> down[movingSpriteNum - 1];
            case "left" -> left[movingSpriteNum - 1];
            case "right" -> right[movingSpriteNum - 1];
            default -> image;
        };


        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
