package entity;

import main.GamePanel;
import main.KeyHandler;
import object.ChestOpen;
import object.DoorOpen;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Player extends Entity {

    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    int haveSilverKey = 0;
    int haveBlueKey = 0;
    int haveSword = 0;
    int haveShield = 0;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {

        super(gamePanel);

        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2;
        screenY = gamePanel.screenHeight / 2 - gamePanel.tileSize / 2;

        solidArea.x = 16;
        solidArea.y = 30;
        solidAreaDefaultX = 16;
        solidAreaDefaultY = 30;
        solidArea.width = 40;
        solidArea.height = 40;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {

        worldX = gamePanel.tileSize * 10;
        worldY = gamePanel.tileSize * 12;
        speed = 4;
        direction = "standing";
        lastDirection = "standingDown";
        maxHp = 6;
        hp = maxHp;
    }

    public void getPlayerImage() {

        standingUp = setup("player/standing/back", "Link_Back");

        for (int i = 0; i < 10; i++) {
            standingDown[i] = setup("player/standing/front", "Link_Front_" + (i + 1));
        }

        for (int i = 0; i < 10; i++) {
            standingLeft[i] = setup("player/standing/left", "Link_Left_" + (i + 1));
        }

        for (int i = 0; i < 10; i++) {
            standingRight[i] = setup("player/standing/right", "Link_Right_" + (i + 1));
        }

        for (int i = 0; i < 10; i++) {
            up[i] = setup("player/walking/up", "Link_Walk_Up_" + (i + 1));
        }

        for (int i = 0; i < 10; i++) {
            down[i] = setup("player/walking/down", "Link_Walk_Down_" + (i + 1));
        }

        for (int i = 0; i < 10; i++) {
            left[i] = setup("player/walking/left", "Link_Walk_Left_" + (i + 1));
        }

        for (int i = 0; i < 10; i++) {
            right[i] = setup("player/walking/right", "Link_Walk_Right_" + (i + 1));
        }
    }

    public void update() {

        //MOVE PLAYER
        if (keyHandler.upPressed) {
            direction = "up";
            lastDirection = "standingUp";
        } else if (keyHandler.downPressed) {
            direction = "down";
            lastDirection = "standingDown";
        } else if (keyHandler.leftPressed) {
            direction = "left";
            lastDirection = "standingLeft";
        } else if (keyHandler.rightPressed) {
            direction = "right";
            lastDirection = "standingRight";
        } else if (keyHandler.upReleased || keyHandler.downReleased || keyHandler.leftReleased || keyHandler.rightReleased) {
            direction = "standing";
        }

        //COLLISION CHECKING
        collisionOn = false;
        gamePanel.collisionChecker.checkTile(this);

        int objectIndex = gamePanel.collisionChecker.checkObjectCollision(this, true);
        objectInteract(objectIndex);

        int npcIndex = gamePanel.collisionChecker.checkEntityCollision(this, gamePanel.npc);
        npcInteract(npcIndex);

        gamePanel.eventHandler.checkEvent();

        gamePanel.keyHandler.spacePressed = false;

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


        //SPRITE CHANGER
        spriteCounter++;
        if (spriteCounter > 5) {
            switch (spriteNum) {
                case 0 -> spriteNum = 1;
                case 1 -> spriteNum = 2;
                case 2 -> spriteNum = 3;
                case 3 -> spriteNum = 4;
                case 4 -> spriteNum = 5;
                case 5 -> spriteNum = 6;
                case 6 -> spriteNum = 7;
                case 7 -> spriteNum = 8;
                case 8 -> spriteNum = 9;
                case 9 -> spriteNum = 0;
            }
            spriteCounter = 0;
        }

        moveCounter++;
        if (moveCounter > 5) {
            switch (movingSpriteNum) {
                case 0 -> movingSpriteNum = 1;
                case 1 -> movingSpriteNum = 2;
                case 2 -> movingSpriteNum = 3;
                case 3 -> movingSpriteNum = 4;
                case 4 -> movingSpriteNum = 5;
                case 5 -> movingSpriteNum = 6;
                case 6 -> movingSpriteNum = 7;
                case 7 -> movingSpriteNum = 8;
                case 8 -> movingSpriteNum = 9;
                case 9 -> movingSpriteNum = 0;
            }
            moveCounter = 0;
        }
    }

    public void objectInteract(int i) {

        if (i != 999) {

            String objectName = gamePanel.superObject[i].name;
            switch (objectName) {
                case "SilverKey":
                    gamePanel.playSFX(3);
                    haveSilverKey++;
                    gamePanel.superObject[i] = null;
                    break;
                case "BlueKey":
                    gamePanel.playSFX(3);
                    haveBlueKey++;
                    gamePanel.superObject[i] = null;
                    break;
                case "Door":
                    if (haveSilverKey > 0) {
                        gamePanel.playSFX(4);
                        int x = gamePanel.superObject[i].worldX;
                        int y = gamePanel.superObject[i].worldY;
                        gamePanel.superObject[i] = new DoorOpen();
                        gamePanel.superObject[i].worldX = x;
                        gamePanel.superObject[i].worldY = y;
                        haveSilverKey--;
                    }
                    break;
                case "Chest":
                    if (haveBlueKey > 0) {
                        gamePanel.playSFX(4);
                        int x = gamePanel.superObject[i].worldX;
                        int y = gamePanel.superObject[i].worldY;
                        gamePanel.superObject[i] = new ChestOpen();
                        gamePanel.superObject[i].worldX = x;
                        gamePanel.superObject[i].worldY = y;
                        haveBlueKey--;
                        break;
                    }
            }
        }
    }

    public void npcInteract(int i) {

        if (i != 999) {
            if (gamePanel.keyHandler.spacePressed) {
                gamePanel.gameState = gamePanel.dialogueState;
                gamePanel.npc[i].speak();
            }
        }

    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;

        if (direction.equals("standing")) {
            image = switch (lastDirection) {
                case "standingUp" -> standingUp;
                case "standingDown" -> standingDown[spriteNum];
                case "standingLeft" -> standingLeft[spriteNum];
                case "standingRight" -> standingRight[spriteNum];
                default -> image;
            };
        }

        image = switch (direction) {
            case "up" -> up[movingSpriteNum];
            case "down" -> down[movingSpriteNum];
            case "left" -> left[movingSpriteNum];
            case "right" -> right[movingSpriteNum];
            default -> image;
        };


        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
