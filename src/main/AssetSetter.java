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

        gamePanel.superObject[0] = new SilverKey();
        gamePanel.superObject[0].worldX = gamePanel.tileSize * 13;
        gamePanel.superObject[0].worldY = gamePanel.tileSize * 23;

        gamePanel.superObject[1] = new BlueKey();
        gamePanel.superObject[1].worldX = gamePanel.tileSize * 13;
        gamePanel.superObject[1].worldY = gamePanel.tileSize * 4;

        gamePanel.superObject[2] = new Door();
        gamePanel.superObject[2].worldX = gamePanel.tileSize * 3;
        gamePanel.superObject[2].worldY = gamePanel.tileSize * 5;

        gamePanel.superObject[3] = new ChestClosed();
        gamePanel.superObject[3].worldX = gamePanel.tileSize * 3;
        gamePanel.superObject[3].worldY = gamePanel.tileSize * 2;

    }

    public void setNpc() {

        gamePanel.npc[0] = new NpcNakedGuy(gamePanel);
        gamePanel.npc[0].worldX = gamePanel.tileSize * 11;
        gamePanel.npc[0].worldY = gamePanel.tileSize * 16;
    }
}
