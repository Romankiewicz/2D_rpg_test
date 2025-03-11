package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;


public class Player extends Entity {

    GamePanel gamePanel;
    KeyHandler keyHandler;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {

        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        x = 100;
        y = 100;
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
            y -= speed;
        } else if (keyHandler.downPressed) {
            direction = "down";
            lastDirection = "down";
            y += speed;
        } else if (keyHandler.leftPressed) {
            direction = "left";
            lastDirection = "left";
            x -= speed;
        } else if (keyHandler.rightPressed) {
            direction = "right";
            lastDirection = "right";
            x += speed;
        } else if (keyHandler.upReleased || keyHandler.downReleased || keyHandler.leftReleased || keyHandler.rightReleased) {
            direction = "standing";
        }

        spriteCounter++;
        if (spriteCounter > 8) {
            if (spriteNum == 1) {
                spriteNum = 2;
            }else if (spriteNum == 2) {
                spriteNum = 3;
            }else if (spriteNum == 3) {
                spriteNum = 4;
            }else if (spriteNum == 4) {
                spriteNum = 5;
            }else if (spriteNum == 5) {
                spriteNum = 6;
            }else if (spriteNum == 6) {
                spriteNum = 7;
            }else if (spriteNum == 7) {
                spriteNum = 8;
            }else if (spriteNum == 8) {
                spriteNum = 9;
            }else if (spriteNum == 9) {
                spriteNum = 10;
            }else if (spriteNum == 10) {
                spriteNum = 1;
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
            switch (lastDirection) {
                case "up":
                    image = standingUp;
                    break;
                case "down":
                    image = standingDown[spriteNum - 1];
                    break;
                case "left":
                    image = standingLeft[spriteNum - 1];
                    break;
                case "right":
                    image = standingRight[spriteNum - 1];
                    break;
            }
        }

        switch (direction) {
            case "up":
                image = up[movingSpriteNum - 1];
                break;

            case "down":
                image = down[movingSpriteNum - 1];
                break;

            case "left":
                image = left[movingSpriteNum - 1];
                break;

            case "right":
                image = right[movingSpriteNum - 1];
                break;
        }


        g2.drawImage(image, x, y, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
