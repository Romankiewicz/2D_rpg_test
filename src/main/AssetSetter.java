package main;

import enemy.BlueOctorok;
import enemy.RedOctorok;
import entity.NpcNakedGuy;
import object.*;

public class AssetSetter {

    GamePanel gamePanel;

    public AssetSetter(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
    }

    public void setObject() {

        int i = 0;
        gamePanel.objects[i] = new SilverKey(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize * 13;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 23;
        i++;

        gamePanel.objects[i] = new BlueKey(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize * 13;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 4;
        i++;

        gamePanel.objects[i] = new Door(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize * 3;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 5;
        i++;

        gamePanel.objects[i] = new ChestClosed(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize * 3;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 2;
        i++;

        gamePanel.objects[i] = new OldSword(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize * 23;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 23;
        i++;

        gamePanel.objects[i] = new WoodenShield(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize * 23;
        gamePanel.objects[i].worldY = gamePanel.tileSize;
        i++;

        gamePanel.objects[i] = new WoodcutterAxe(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 10;
        i++;

        gamePanel.objects[i] = new BarbarianAxe(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 23;
        i++;

        gamePanel.objects[i] = new BlueShield(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize * 7;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 2;
        i++;

        gamePanel.objects[i] = new HealthPotion(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize * 12;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 2;
        i++;

        gamePanel.objects[i] = new HealthPotion(gamePanel);
        gamePanel.objects[i].worldX = gamePanel.tileSize;
        gamePanel.objects[i].worldY = gamePanel.tileSize * 15;
    }

    public void setNpc() {

        int i = 0;
        gamePanel.npcs[i] = new NpcNakedGuy(gamePanel);
        gamePanel.npcs[i].worldX = gamePanel.tileSize * 11;
        gamePanel.npcs[i].worldY = gamePanel.tileSize * 16;
        i++;

        gamePanel.npcs[i] = new NpcNakedGuy(gamePanel);
        gamePanel.npcs[i].worldX = gamePanel.tileSize * 15;
        gamePanel.npcs[i].worldY = gamePanel.tileSize * 12;
    }

    public void setEnemies() {

        int i = 0;

        gamePanel.enemies[i] = new BlueOctorok(gamePanel);
        gamePanel.enemies[i].worldX = gamePanel.tileSize * 3;
        gamePanel.enemies[i].worldY = gamePanel.tileSize * 4;
        i++;

        gamePanel.enemies[i] = new BlueOctorok(gamePanel);
        gamePanel.enemies[i].worldX = gamePanel.tileSize * 5;
        gamePanel.enemies[i].worldY = gamePanel.tileSize * 23;
        i++;

        gamePanel.enemies[i] = new BlueOctorok(gamePanel);
        gamePanel.enemies[i].worldX = gamePanel.tileSize * 21;
        gamePanel.enemies[i].worldY = gamePanel.tileSize * 5;
        i++;

        gamePanel.enemies[i] = new RedOctorok(gamePanel);
        gamePanel.enemies[i].worldX = gamePanel.tileSize * 4;
        gamePanel.enemies[i].worldY = gamePanel.tileSize * 4;
        i++;

        gamePanel.enemies[i] = new RedOctorok(gamePanel);
        gamePanel.enemies[i].worldX = gamePanel.tileSize * 21;
        gamePanel.enemies[i].worldY = gamePanel.tileSize * 12;
        i++;

        gamePanel.enemies[i] = new RedOctorok(gamePanel);
        gamePanel.enemies[i].worldX = gamePanel.tileSize * 5;
        gamePanel.enemies[i].worldY = gamePanel.tileSize * 21;
    }
}
