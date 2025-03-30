package main;

public class EventHandler {

    GamePanel gamePanel;
    EventRect[][] eventRect;

    int previousEventX, previousEventY;
    boolean eventCoolDownDone = true;

    public EventHandler(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

        eventRect = new EventRect[gamePanel.maxWorldCol][gamePanel.maxWorldRow];

        int col = 0;
        int row = 0;

        while (col < gamePanel.maxWorldCol && row < gamePanel.maxWorldRow) {

            eventRect[col][row] = new EventRect();
            eventRect[col][row].x = 35;
            eventRect[col][row].y = 35;
            eventRect[col][row].height = 2;
            eventRect[col][row].width = 2;
            eventRect[col][row].eventRectDefaultX = eventRect[col][row].x;
            eventRect[col][row].eventRectDefaultY = eventRect[col][row].y;

            col++;
            if (col == gamePanel.maxWorldCol) {
                col = 0;
                row++;
            }
        }
    }

    public void checkEvent() {

        int xDistance = Math.abs(gamePanel.player.worldX - previousEventX);
        int yDistance = Math.abs(gamePanel.player.worldY - previousEventY);
        int distance = Math.max(xDistance, yDistance);

        if(distance > gamePanel.tileSize) {
            eventCoolDownDone = true;
        }

        if(eventCoolDownDone) {
            if (hit(21, 4, "any")) {
                damage(gamePanel.dialogueState);
            }
            if (hit(13, 22, "standingUp")) {
                healing(gamePanel.dialogueState);
            }
            if (hit(2, 2, "up")) {
                teleport();
            }
        }
    }

    public boolean hit(int col, int row, String reqDirection) {

        boolean hit = false;

        gamePanel.player.solidArea.x = gamePanel.player.worldX + gamePanel.player.solidArea.x;
        gamePanel.player.solidArea.y = gamePanel.player.worldY + gamePanel.player.solidArea.y;
        eventRect[col][row].x = col *gamePanel.tileSize + eventRect[col][row].x;
        eventRect[col][row].y = row *gamePanel.tileSize + eventRect[col][row].y;

        if (gamePanel.player.solidArea.intersects(eventRect[col][row]) && !eventRect[col][row].eventDone) {
            if (gamePanel.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")
            ||gamePanel.player.lastDirection.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
                hit = true;

                previousEventX = gamePanel.player.worldX;
                previousEventY = gamePanel.player.worldY;
            }
        }

        gamePanel.player.solidArea.x = gamePanel.player.solidAreaDefaultX;
        gamePanel.player.solidArea.y = gamePanel.player.solidAreaDefaultY;
        eventRect[col][row].x = eventRect[col][row].eventRectDefaultX;
        eventRect[col][row].y = eventRect[col][row].eventRectDefaultY;

        return hit;
    }

    public void damage(int gameState) {

        gamePanel.gameState = gameState;
        gamePanel.ui.currentDialogue = "\nGOTCHA\nLandmine ;)";
        gamePanel.player.hp -= 1;
        eventCoolDownDone = false;
        gamePanel.playSFX(11);
    }

    public void healing(int gameState) {

        if (gamePanel.keyHandler.spacePressed) {
            gamePanel.player.attacking = false;
            gamePanel.gameState = gameState;
            gamePanel.ui.currentDialogue = "\nYou take a rest\n\nYou feel refreshed";
            gamePanel.player.hp = gamePanel.player.maxHp;
            gamePanel.playSFX(9);

        }
    }

    public void teleport () {

        gamePanel.player.worldX = gamePanel.tileSize * 10;
        gamePanel.player.worldY = gamePanel.tileSize * 12;
    }
}