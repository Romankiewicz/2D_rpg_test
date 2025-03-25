package main;

import java.awt.*;

public class UI {

    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_30, arial_40, arial_80;

    Color translucentBlack = new Color(0, 0, 0, 200);
    Color translucentWhite = new Color(255, 255, 255, 200);

    public boolean messageOn = false;
    public String message = "";
    public String currentDialogue = "";
    public int messageCounter = 0;
    public boolean gameOver = false;
    public boolean gameFinished = false;

    public UI(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
        arial_30 = new Font("Arial", Font.PLAIN, 30);
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80 = new Font("Arial", Font.PLAIN, 80);
    }

    public void showMessage(String text) {

        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(arial_40);
        g2.setColor(Color.white);

        if (gamePanel.gameState == gamePanel.playState) {

        } else if (gamePanel.gameState == gamePanel.pauseState) {
            drawPauseScreen();
        } else if (gamePanel.gameState == gamePanel.dialogueState) {
            drawDialogueScreen();
        }
    }

    public void drawPauseScreen() {

        String text = "PAUSE";
        int x = getXForCenteredText(text);
        int y = gamePanel.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public void drawDialogueScreen() {

        int x = gamePanel.tileSize * 2;
        int y = gamePanel.tileSize * 8 - gamePanel.tileSize / 2;
        int width = gamePanel.screenWidth - (gamePanel.tileSize * 4);
        int height = gamePanel.tileSize * 4;

        int textX = x + gamePanel.tileSize;
        int textY = y + gamePanel.tileSize;

        drawDialogueWindow(x, y, width, height);
        g2.setFont(arial_30);
        g2.drawString(currentDialogue, textX, textY);
    }

    public void drawDialogueWindow(int x, int y, int width, int height) {

        g2.setColor(translucentBlack);
        g2.fillRoundRect(x, y, width, height, 20, 20);
        g2.setColor(translucentWhite);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(x + 4, y + 4, width - 8, height - 8, 18, 18);
    }

    public int getXForCenteredText(String text) {

        int textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        return gamePanel.screenWidth / 2 - textLength / 2;
    }
}
