package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Projectile extends Entity {

    Entity user;

    public Projectile(GamePanel gamePanel) {
        super(gamePanel);
    }

    public void set(int worldX, int worldY, String direction, boolean isAlive, Entity user) {

        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.isAlive = isAlive;
        this.user = user;
        this.hp = maxHp;
    }


    public void update() {

        if (user == gamePanel.player) {

            int enemyIndex = gamePanel.collisionChecker.checkEntityCollision(this, gamePanel.enemies);
            int npcIndex = gamePanel.collisionChecker.checkEntityCollision(this, gamePanel.npcs);

            if (enemyIndex != 999) {
                gamePanel.player.damageEnemy(enemyIndex, this.attack);
                isAlive = false;
            }
            if (npcIndex != 999) {
                isAlive = false;
            }
        }
        if (user != gamePanel.player) {

            boolean contactPlayer = gamePanel.collisionChecker.checkPlayerCollision(this);
            if (contactPlayer && !gamePanel.player.invincible) {
                damagePlayer(attack);
                isAlive = false;
            }
        }

        switch (direction) {
            case "up", "standingUp" -> worldY -= speed;
            case "down", "standingDown" -> worldY += speed;
            case "left", "standingLeft" -> worldX -= speed;
            case "right", "standingRight" -> worldX += speed;
        }

        hp--;
        if (hp <= 0) {
            isAlive = false;
        }

        projectileSpriteCounter++;
        if (projectileSpriteCounter > 6) {
            switch (projectileSpriteNum) {
                case 0 -> projectileSpriteNum = 1;
                case 1 -> projectileSpriteNum = 2;
                case 2 -> projectileSpriteNum = 0;
            }
            projectileSpriteCounter = 0;

        }
    }

    public void draw(Graphics2D g2) {

        BufferedImage image;

        int screenX = worldX - gamePanel.player.worldX + gamePanel.player.screenX;
        int screenY = worldY - gamePanel.player.worldY + gamePanel.player.screenY;

        if (worldX + gamePanel.tileSize > gamePanel.player.worldX - gamePanel.player.screenX &&
                worldX - gamePanel.tileSize < gamePanel.player.worldX + gamePanel.player.screenX &&
                worldY + gamePanel.tileSize > gamePanel.player.worldY - gamePanel.player.screenY &&
                worldY - gamePanel.tileSize < gamePanel.player.worldY + gamePanel.player.screenY) {

            if (threeSprites) {
                image = switch (direction) {
                    case "up", "standingUp" -> up[projectileSpriteNum];
                    case "down", "standingDown" -> down[projectileSpriteNum];
                    case "left", "standingLeft" -> left[projectileSpriteNum];
                    case "right", "standingRight" -> right[projectileSpriteNum];
                    default -> null;
                };
            } else {
                image = switch (direction) {
                    case "up", "standingUp" -> up[0];
                    case "down", "standingDown" -> down[0];
                    case "left", "standingLeft" -> left[0];
                    case "right", "standingRight" -> right[0];
                    default -> null;
                };
            }

            g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }

    public boolean haveResource(Entity user) {
        return false;
    }

    public void useResource(Entity user) {}
}
