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

        gamePanel.objects[0] = new SilverKey(gamePanel);
        gamePanel.objects[0].worldX = gamePanel.tileSize * 13;
        gamePanel.objects[0].worldY = gamePanel.tileSize * 23;

        gamePanel.objects[1] = new BlueKey(gamePanel);
        gamePanel.objects[1].worldX = gamePanel.tileSize * 13;
        gamePanel.objects[1].worldY = gamePanel.tileSize * 4;

        gamePanel.objects[2] = new Door(gamePanel);
        gamePanel.objects[2].worldX = gamePanel.tileSize * 3;
        gamePanel.objects[2].worldY = gamePanel.tileSize * 5;

        gamePanel.objects[3] = new ChestClosed(gamePanel);
        gamePanel.objects[3].worldX = gamePanel.tileSize * 3;
        gamePanel.objects[3].worldY = gamePanel.tileSize * 2;

        gamePanel.objects[4] = new Sword(gamePanel);
        gamePanel.objects[4].worldX = gamePanel.tileSize * 23;
        gamePanel.objects[4].worldY = gamePanel.tileSize * 23;

        gamePanel.objects[5] = new ChestClosed(gamePanel);
        gamePanel.objects[5].worldX = gamePanel.tileSize * 10;
        gamePanel.objects[5].worldY = gamePanel.tileSize * 10;
    }

    public void setNpc() {

        gamePanel.npcs[0] = new NpcNakedGuy(gamePanel);
        gamePanel.npcs[0].worldX = gamePanel.tileSize * 11;
        gamePanel.npcs[0].worldY = gamePanel.tileSize * 16;

        gamePanel.npcs[1] = new NpcNakedGuy(gamePanel);
        gamePanel.npcs[1].worldX = gamePanel.tileSize * 15;
        gamePanel.npcs[1].worldY = gamePanel.tileSize * 12;
    }

    public void setEnemies() {

        gamePanel.enemies[0] = new BlueOctorok(gamePanel);
        gamePanel.enemies[0].worldX = gamePanel.tileSize * 3;
        gamePanel.enemies[0].worldY = gamePanel.tileSize * 4;

        gamePanel.enemies[1] = new BlueOctorok(gamePanel);
        gamePanel.enemies[1].worldX = gamePanel.tileSize * 5;
        gamePanel.enemies[1].worldY = gamePanel.tileSize * 23;

        gamePanel.enemies[2] = new RedOctorok(gamePanel);
        gamePanel.enemies[2].worldX = gamePanel.tileSize * 4;
        gamePanel.enemies[2].worldY = gamePanel.tileSize * 4;

        gamePanel.enemies[3] = new RedOctorok(gamePanel);
        gamePanel.enemies[3].worldX = gamePanel.tileSize * 21;
        gamePanel.enemies[3].worldY = gamePanel.tileSize * 12;
    }
}
