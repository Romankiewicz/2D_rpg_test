package main;

import java.awt.*;
import java.text.DecimalFormat;

public class UI {

    GamePanel gamePanel;
    Graphics2D g2;
    Font arial_40, arial_80;
    public boolean messageOn = false;
    public String message = "";
    public int messageCounter = 0;
    public boolean gameOver = false;
    public boolean gameFinished = false;

    public UI(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
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

        }
        if (gamePanel.gameState == gamePanel.pauseState) {
            drawPauseScreen();
        }
    }

    public void drawPauseScreen(){

        String text = "PAUSE";
        int x = getXForCenteredText(text);
        int y = gamePanel.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public int getXForCenteredText(String text) {

        int textLength = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();

        return gamePanel.screenWidth /2 - textLength/2;
    }
}
