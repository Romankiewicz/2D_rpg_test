package main;

import java.awt.*;

public class EventHandler {

    GamePanel gamePanel;
    Rectangle eventRect;
    int eventRectDefaultX, eventRectDefaultY;

    public EventHandler(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

        eventRect = new Rectangle();
        eventRect.x = 35;
        eventRect.y = 35;
        eventRect.height = 2;
        eventRect.width = 2;
        eventRectDefaultX = eventRect.x;
        eventRectDefaultY = eventRect.y;
    }

    public void checkEvent() {

        if (hit(21, 4, "right")) {
            damage(gamePanel.dialogueState);
        }
        if (hit(13, 22, "standingUp")) {
            healing(gamePanel.dialogueState);
        }
        if (hit(2, 2, "up")) {
            teleport();
        }
    }

    public boolean hit(int eventCol, int eventRow, String reqDirection) {

        boolean hit = false;

        gamePanel.player.solidArea.x = gamePanel.player.worldX + gamePanel.player.solidArea.x;
        gamePanel.player.solidArea.y = gamePanel.player.worldY + gamePanel.player.solidArea.y;
        eventRect.x = eventCol *gamePanel.tileSize + eventRect.x;
        eventRect.y = eventRow *gamePanel.tileSize + eventRect.y;

        if (gamePanel.player.solidArea.intersects(eventRect)) {
            if (gamePanel.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")
            ||gamePanel.player.lastDirection.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;
            }
        }

        gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
        gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;
        eventRect.x = eventRectDefaultX;
        eventRect.y = eventRectDefaultY;

        return hit;
    }

    public void damage(int gameState) {

        gamePanel.gameState = gameState;
        gamePanel.ui.currentDialogue = "\n\nGOTCHA";
        gamePanel.player.hp -= 1;
    }

    public void healing(int gameState) {

        if (gamePanel.keyHandler.spacePressed) {
            gamePanel.gameState = gameState;
            gamePanel.ui.currentDialogue = "\nYou take a rest\n\nYou feel refreshed";
            gamePanel.player.hp = gamePanel.player.maxHp;
        }
    }

    public void teleport () {

        gamePanel.player.worldX = gamePanel.tileSize * 10;
        gamePanel.player.worldY = gamePanel.tileSize * 12;
    }
}