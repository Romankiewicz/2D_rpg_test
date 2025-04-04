package entity;

import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Objects;

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
                case "up", "standingUp" -> up[projectileSpriteNum];
                case "down", "standingDown" -> down[projectileSpriteNum];
                case "left", "standingLeft" -> left[projectileSpriteNum];
                case "right", "standingRight" -> right[projectileSpriteNum];
                default -> image;
            };

            g2.drawImage(image, screenX, screenY, gamePanel.tileSize, gamePanel.tileSize, null);
        }
    }
}
