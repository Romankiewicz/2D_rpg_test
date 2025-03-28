package main;

import entity.Entity;
import object.Heart;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI {

    GamePanel gamePanel;
    Graphics2D g2;
    Font courier_30, courier_40, courier_80, courier_30B, courier_40B, courier_80B;

    BufferedImage heartFull, heartHalf, heartEmpty;

    Color translucentBlack = new Color(0, 0, 0, 200);
    Color translucentWhite = new Color(255, 255, 255, 200);
    Color translucentWhite_1 = new Color(255, 255, 255, 100);

    public String currentDialogue = "";
    public int commandNum = 0;
    public int musicSelectorNum = 100;
    public int sfxSelectorNum = 100;
    public int titleScreenState = 0;


    public UI(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

        courier_30 = new Font("Courier New", Font.PLAIN, 30);
        courier_30B = new Font("Courier New", Font.BOLD, 30);
        courier_40 = new Font("Courier New", Font.PLAIN, 40);
        courier_40B = new Font("Courier New", Font.BOLD, 40);
        courier_80 = new Font("Courier New", Font.PLAIN, 80);
        courier_80B = new Font("Courier New", Font.BOLD, 80);

        Entity heart = new Heart(gamePanel);
        heartFull = heart.image;
        heartHalf = heart.image1;
        heartEmpty = heart.image2;
    }

    public void draw(Graphics2D g2) {

        this.g2 = g2;

        g2.setFont(courier_80);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);

        if (gamePanel.gameState == gamePanel.titleState) {
            drawTitleScreen();
        } else if (gamePanel.gameState == gamePanel.playState) {
            drawPlayerHp();
        } else if (gamePanel.gameState == gamePanel.pauseState) {
            drawPlayerHp();
            drawPauseScreen();
        } else if (gamePanel.gameState == gamePanel.dialogueState) {
            drawPlayerHp();
            drawDialogueScreen();
        }
    }

    public void drawPlayerHp() {

        int x = gamePanel.tileSize / 2;
        int y = gamePanel.tileSize / 2;
        int i = 0;

        while (i < gamePanel.player.maxHp / 2) {
            g2.drawImage(heartEmpty, x, y, null);
            i++;
            x += gamePanel.tileSize;
        }
        x = gamePanel.tileSize / 2;
        i = 0;

        while (i < gamePanel.player.hp) {
            g2.drawImage(heartHalf, x, y, null);
            i++;
            if (i < gamePanel.player.hp) {
                g2.drawImage(heartFull, x, y, null);
            }
            i++;
            x += gamePanel.tileSize;
        }
    }

    public void drawTitleScreen() {

        //Title
        if (titleScreenState == 0) {
            g2.setFont(courier_30);
            String prefix = "(a not that much)";
            int x = getXForCenteredText(prefix);
            int y = gamePanel.tileSize * 3;
            g2.setColor(Color.white);
            g2.drawString(prefix, x, y);

            g2.setFont(courier_80B);
            String title = "ZELDA-like RPG";
            x = getXForCenteredText(title);
            y += gamePanel.tileSize;
            g2.setColor(translucentWhite_1);
            g2.drawString(title, x + 5, y + 4);
            g2.setColor(Color.white);
            g2.drawString(title, x, y);

            //Menu
            g2.setFont(courier_40B);

            String text = "New Game";
            x = getXForCenteredText(text);
            y += gamePanel.tileSize * 4;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString("<", x - gamePanel.tileSize, y);
                g2.drawString(">", getXForEndOfText(text) + gamePanel.tileSize / 2, y);
            }

            text = "Load Game";
            x = getXForCenteredText(text);
            y += gamePanel.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString("<", x - gamePanel.tileSize, y);
                g2.drawString(">", getXForEndOfText(text) + gamePanel.tileSize / 2, y);
            }

            text = "Options";
            x = getXForCenteredText(text);
            y += gamePanel.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString("<", x - gamePanel.tileSize, y);
                g2.drawString(">", getXForEndOfText(text) + gamePanel.tileSize / 2, y);
            }

            text = "Exit";
            x = getXForCenteredText(text);
            y += gamePanel.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 3) {
                g2.drawString("<", x - gamePanel.tileSize, y);
                g2.drawString(">", getXForEndOfText(text) + gamePanel.tileSize / 2, y);
            }
        } else if (titleScreenState == 1) {

            g2.setFont(courier_80B);
            String text = "Options";
            int x = getXForCenteredText(text);
            int y = gamePanel.tileSize * 3;
            g2.setColor(Color.white);
            g2.drawString(text, x, y);

            g2.setFont(courier_40B);

            text = "Music volume";
            x = getXForCenteredText(text);
            y += gamePanel.tileSize * 3;
            g2.drawString(text, x, y);
            if (commandNum == 0) {
                g2.drawString(">", x - gamePanel.tileSize, y);
            }
            text = "|................|";
            int selectorX = getXForCenteredText(text);
            int selectorY = y - gamePanel.tileSize;
            g2.drawString(text, selectorX, selectorY);

            g2.drawString("°", selectorX + musicSelectorNum * 4, selectorY - gamePanel.tileSize / 4);

            text = "SFX volume";
            x = getXForCenteredText(text);
            y += gamePanel.tileSize * 3;
            g2.drawString(text, x, y);
            if (commandNum == 1) {
                g2.drawString(">", x - gamePanel.tileSize, y);
            }
            text = "|................|";
            selectorX = getXForCenteredText(text);
            selectorY = y - gamePanel.tileSize;
            g2.drawString(text, selectorX, selectorY);

            g2.drawString("°", selectorX + sfxSelectorNum * 4, selectorY - gamePanel.tileSize / 4);

            text = "Go Back";
            x = getXForCenteredText(text);
            y += gamePanel.tileSize;
            g2.drawString(text, x, y);
            if (commandNum == 2) {
                g2.drawString(">", x - gamePanel.tileSize, y);
            }
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

        for (String line : currentDialogue.split("\n")) {

            g2.setFont(courier_30);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.drawString(line, textX, textY);
            textY += 34;
        }
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

    public int getXForEndOfText(String text) {

        int textLength = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return gamePanel.screenWidth / 2 + textLength / 2;
    }
}
