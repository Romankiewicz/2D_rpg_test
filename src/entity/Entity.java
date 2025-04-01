package entity;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static entity.EntityType.ENEMY;

public class Entity {

    public int worldX, worldY;
    public int speed;
    public int maxHp;
    public int hp;
    public int level;
    public int strength;
    public int dexterity;
    public int attack;
    public int defense;
    public int xp;
    public int nextLevelXp;
    public int coin;
    public Entity currentWeapon;
    public Entity currentShield;

    GamePanel gamePanel;

    public BufferedImage image, image1, image2;
    public String name;
    public boolean collision = false;
    public EntityType type;

    public int attackValue;
    public int defenseValue;
    public String description = "";

    public BufferedImage standingUp;
    public BufferedImage[] standingDown = new BufferedImage[10];
    public BufferedImage[] standingLeft = new BufferedImage[10];
    public BufferedImage[] standingRight = new BufferedImage[10];


    public BufferedImage[] up = new BufferedImage[10];
    public BufferedImage[] down = new BufferedImage[10];
    public BufferedImage[] left = new BufferedImage[10];
    public BufferedImage[] right = new BufferedImage[10];

    public BufferedImage[] handAttackUp = new BufferedImage[5];
    public BufferedImage[] handAttackDown = new BufferedImage[5];
    public BufferedImage[] handAttackLeft = new BufferedImage[5];
    public BufferedImage[] handAttackRight = new BufferedImage[5];

    public BufferedImage[] swordAttackUp = new BufferedImage[5];
    public BufferedImage[] swordAttackDown = new BufferedImage[5];
    public BufferedImage[] swordAttackLeft = new BufferedImage[5];
    public BufferedImage[] swordAttackRight = new BufferedImage[5];

    public BufferedImage[] axeAttackUp = new BufferedImage[5];
    public BufferedImage[] axeAttackDown = new BufferedImage[5];
    public BufferedImage[] axeAttackLeft = new BufferedImage[5];
    public BufferedImage[] axeAttackRight = new BufferedImage[5];

    public String direction = "down";
    public String lastDirection;

    public int spriteCounter = 0;
    public int spriteNum = 0;
    public int moveCounter = 0;
    public int movingSpriteNum = 0;
    public int attackSpriteNum = 0;
    public int attackSpriteCounter = 0;

    public int npcSpriteNum = 0;
    public int npcSpriteCounter = 0;
    public boolean twoSprites = false;
    public boolean threeSprites = false;

    public int actionCounter = 0;
    public static int dialogueCounter = 0;

    public boolean invincible = false;
    public int invincibleCounter = 0;
    public boolean attacking = false;
    public boolean isAlive = true;
    public boolean isDying = false;
    public int dyingCounter = 0;
    public boolean hpBarOn = false;
    public int hpBarCounter = 0;

    public Rectangle solidArea = new Rectangle(0, 0, 72, 72);
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;

    public Rectangle attackArea = new Rectangle(0, 0, 0, 0);

    public static String[] dialogues = new String[20];

    public Entity(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
    }

    public BufferedImage setup(String packageName, String imageName, int width, int height) {

        UtilityTool utilityTool = new UtilityTool();
        BufferedImage image = null;

        try {

            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/" + packageName + "/" + imageName + ".png")));
            image = utilityTool.scaleImage(image, width, height);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public void speak() {

        if (dialogues[dialogueCounter] == null) {
            gamePanel.gameState = gamePanel.playState;
            dialogueCounter = 0;

        } else if (dialogues[dialogueCounter] != null) {
            gamePanel.ui.currentDialogue = dialogues[dialogueCounter];
            dialogueCounter++;
        }

        switch (gamePanel.player.direction) {
            case "up", "standingUp" -> direction = "down";
            case "down", "standingDown" -> direction = "up";
            case "left", "standingLeft" -> direction = "right";
            case "right", "standingRight" -> direction = "left";
        }
    }

    public void setAction() {}

    public void damageReaction(){}

    public void dyingAnimation(Graphics2D g2) {

        dyingCounter++;

        int i = 5;

        if (dyingCounter <= i) {
            changeAlpha(g2, 0.1f);
            gamePanel.playSFX(7);
        }
        if (dyingCounter > i && dyingCounter <= i * 2) {
            changeAlpha(g2, 0.8f);
        }
        if (dyingCounter > i * 2 && dyingCounter <= i * 3) {
            changeAlpha(g2, 0.1f);
        }
        if (dyingCounter > i * 3 && dyingCounter <= i * 4) {
            changeAlpha(g2, 0.8f);
        }
        if (dyingCounter > i * 4 && dyingCounter <= i * 5) {
            changeAlpha(g2, 0.1f);
        }
        if (dyingCounter > i * 5 && dyingCounter <= i * 6) {
            changeAlpha(g2, 0.8f);
        }
        if (dyingCounter > i * 6 && dyingCounter <= i * 7) {
            changeAlpha(g2, 0.1f);
        }
        if (dyingCounter > i * 7 && dyingCounter <= i * 8) {
            changeAlpha(g2, 0.8f);
        }
        if (dyingCounter > i * 8) {
            isAlive = false;
            isDying = false;
        }
    }

    public void changeAlpha(Graphics2D g2, float alpha) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    }

    public void update() {

        setAction();

        collisionOn = false;
        gamePanel.collisionChecker.checkTile(this);
        gamePanel.collisionChecker.checkObjectCollision(this, false);
        gamePanel.collisionChecker.checkEntityCollision(this, gamePanel.enemies);
        gamePanel.collisionChecker.checkEntityCollision(this, gamePanel.npcs);
        boolean contactsPlayer = gamePanel.collisionChecker.checkPlayerCollision(this);

        if (type == ENEMY && contactsPlayer) {
            if (!gamePanel.player.invincible) {

                int damage = attack - gamePanel.player.defense;

                if (damage<0){
                    damage = 0;
                }

                gamePanel.player.hp -= damage;

                gamePanel.playSFX(8);

                gamePanel.player.invincible = true;
            }
        }
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
        if (threeSprites) {
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
        if (twoSprites) {
            npcSpriteCounter++;
            if (npcSpriteCounter > 15) {
                switch (npcSpriteNum) {
                    case 0 -> npcSpriteNum = 1;
                    case 1 -> npcSpriteNum = 0;
                }
                npcSpriteCounter = 0;
            }
        }

        if (invincible) {
            invincibleCounter++;
            if (invincibleCounter > 40) {
                invincible = false;
                invincibleCounter = 0;
            }
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

            if (type == ENEMY && hpBarOn && isAlive) {
                double scale = (double) gamePanel.tileSize / maxHp;
                double hpValue = scale * hp;

                g2.setColor(new Color(0, 0, 0, 180));
                g2.fillRect(screenX - 2, screenY - 14, gamePanel.tileSize + 4, 14);
                g2.setColor(new Color(255, 0, 100, 255));
                g2.fillRect(screenX, screenY - 12, (int)hpValue, 10);

                hpBarCounter++;

                if (hpBarCounter > 300) {
                    hpBarCounter = 0;
                    hpBarOn = false;
                }
            }

            if (invincible) {
                changeAlpha(g2, 0.4f);
                hpBarCounter = 0;
                hpBarOn = true;
            }

            if (isDying) {
                dyingAnimation(g2);
            }

            g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);

            changeAlpha(g2, 1f);
        }
    }
}
