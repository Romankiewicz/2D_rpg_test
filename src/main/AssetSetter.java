package main;

import entity.NpcNakedGuy;
import object.BlueKey;
import object.ChestClosed;
import object.Door;
import object.SilverKey;

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

    }

    public void setNpc() {

        gamePanel.npc[0] = new NpcNakedGuy(gamePanel);
        gamePanel.npc[0].worldX = gamePanel.tileSize * 11;
        gamePanel.npc[0].worldY = gamePanel.tileSize * 16;

        gamePanel.npc[1] = new NpcNakedGuy(gamePanel);
        gamePanel.npc[1].worldX = gamePanel.tileSize * 15;
        gamePanel.npc[1].worldY = gamePanel.tileSize * 12;

        gamePanel.npc[2] = new NpcNakedGuy(gamePanel);
        gamePanel.npc[2].worldX = gamePanel.tileSize * 20;
        gamePanel.npc[2].worldY = gamePanel.tileSize * 18;
    }
}
