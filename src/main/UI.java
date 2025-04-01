package main;

import entity.Entity;
import object.Heart;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class UI {

    GamePanel gamePanel;
    Graphics2D g2;
    Font courier_30, courier_40, courier_80, courier_30B, courier_40B, courier_80B;

    BufferedImage heartFull, heartHalf, heartEmpty;

    ArrayList<String> message = new ArrayList<>();
    ArrayList<Integer> messageCounter = new ArrayList<>();

    public Color translucentBlack = new Color(0, 0, 0, 200);
    public Color translucentWhite = new Color(255, 255, 255, 200);
    public Color translucentWhite_1 = new Color(255, 255, 255, 100);

    public String currentDialogue = "";
    public int commandNum = 0;
    public int musicSelectorNum = 100;
    public int sfxSelectorNum = 100;
    public int titleScreenState = 0;
    public int slotCol = 0;
    public int slotRow = 0;


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
            drawMessage();
        } else if (gamePanel.gameState == gamePanel.pauseState) {
            drawPlayerHp();
            drawPauseScreen();
        } else if (gamePanel.gameState == gamePanel.dialogueState) {
            drawPlayerHp();
            drawDialogueScreen();
        } else if (gamePanel.gameState == gamePanel.statsState) {
            drawPlayerHp();
            drawStatsScreen();
            drawInventory();
        }
    }

    public void addMessage(String text) {

        message.add(text);
        messageCounter.add(0);
    }

    public void drawMessage() {

        int messageX = gamePanel.tileSize * 13;
        int messageY = gamePanel.tileSize * 10;

        g2.setFont(courier_30B);

        for (int i = 0; i < message.size(); i++) {
            if (message.get(i) != null) {
                g2.setColor(translucentBlack);
                g2.drawString(message.get(i), messageX + 2, messageY + 2);
                g2.setColor(translucentWhite);
                g2.drawString(message.get(i), messageX, messageY);

                int counter = messageCounter.get(i) + 1;
                messageCounter.set(i, counter);
                messageY += 40;

                if (messageCounter.get(i) > 180) {
                    message.remove(i);
                    messageCounter.remove(i);
                }
            }
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

    public void drawStatsScreen() {

        final int frameX = gamePanel.tileSize / 2;
        final int frameY = gamePanel.tileSize * 2;
        final int frameWidth = gamePanel.tileSize * 5;
        final int frameHeight = gamePanel.tileSize * 8;

        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        g2.setColor(translucentWhite);
        g2.setFont(courier_30);

        int textX = frameX + gamePanel.tileSize / 3;
        int textY = frameY + gamePanel.tileSize;
        final int lineHeight = 47;

        g2.drawString("Level", textX, textY);
        textY += lineHeight;
        g2.drawString("Strength", textX, textY);
        textY += lineHeight;
        g2.drawString("Dexterity", textX, textY);
        textY += lineHeight;
        g2.drawString("Attack", textX, textY);
        textY += lineHeight;
        g2.drawString("Defense", textX, textY);
        textY += lineHeight;
        g2.drawString("EXP", textX, textY);
        textY += lineHeight;
        g2.drawString("Next LVL", textX, textY);
        textY += lineHeight;
        g2.drawString("Coin", textX, textY);
        textY += lineHeight + 10;
        g2.drawString("Weapon", textX, textY);
        textY += gamePanel.tileSize;
        g2.drawString("Shield", textX, textY);

        int rightX = (frameX + frameWidth) - 30;
        textY = frameY + gamePanel.tileSize;
        String value;

        value = String.valueOf(gamePanel.player.level);
        textX = getXForAlignedText(value, rightX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gamePanel.player.strength);
        textX = getXForAlignedText(value, rightX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gamePanel.player.dexterity);
        textX = getXForAlignedText(value, rightX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gamePanel.player.attack);
        textX = getXForAlignedText(value, rightX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gamePanel.player.defense);
        textX = getXForAlignedText(value, rightX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gamePanel.player.xp);
        textX = getXForAlignedText(value, rightX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gamePanel.player.nextLevelXp);
        textX = getXForAlignedText(value, rightX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        value = String.valueOf(gamePanel.player.coin);
        textX = getXForAlignedText(value, rightX);
        g2.drawString(value, textX, textY);
        textY += lineHeight;

        if (gamePanel.player.currentWeapon != null) {
            g2.drawImage(gamePanel.player.currentWeapon.down[0], (rightX - 50), textY - gamePanel.tileSize / 2, null);
        }
        if (gamePanel.player.currentWeapon == null) {
            g2.setStroke(new BasicStroke(1));
            g2.drawRoundRect(rightX - 50, textY - gamePanel.tileSize / 2, 50, 50, 10, 10);
        }
        textY += gamePanel.tileSize;

        if (gamePanel.player.currentShield != null) {
            g2.drawImage(gamePanel.player.currentShield.down[0], (rightX - 50),
                    textY - gamePanel.tileSize / 2, null);
        }
        if (gamePanel.player.currentShield == null) {
            g2.setStroke(new BasicStroke(1));
            g2.drawRoundRect(rightX - 50, textY - gamePanel.tileSize / 2, 50, 50, 10, 10);
        }
    }

    public void drawInventory(){

        final int frameX = gamePanel.tileSize*9;
        final int frameY = gamePanel.tileSize * 2;
        final int frameWidth = gamePanel.tileSize * 6;
        final int frameHeight = gamePanel.tileSize * 5;
        drawSubWindow(frameX, frameY, frameWidth, frameHeight);

        final int slotXStart = frameX + 35;
        final int slotYStart = frameY + 35;
        int slotX = slotXStart;
        int slotY = slotYStart;

        int cursorX = slotXStart +(gamePanel.tileSize*slotCol);
        int cursorY = slotYStart +(gamePanel.tileSize*slotRow);
        int cursorWidth = gamePanel.tileSize;
        int cursorHeight = gamePanel.tileSize;

        g2.setColor(translucentWhite);
        g2.setStroke(new BasicStroke(2));
        g2.drawRoundRect(cursorX, cursorY, cursorWidth, cursorHeight, 10, 10);

    }

    public void drawDialogueScreen() {

        int x = gamePanel.tileSize * 2;
        int y = gamePanel.tileSize * 8 - gamePanel.tileSize / 2;
        int width = gamePanel.screenWidth - (gamePanel.tileSize * 4);
        int height = gamePanel.tileSize * 4;

        int textX = x + gamePanel.tileSize;
        int textY = y + gamePanel.tileSize;

        drawSubWindow(x, y, width, height);

        for (String line : currentDialogue.split("\n")) {

            g2.setColor(translucentWhite);
            g2.setFont(courier_30);
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.drawString(line, textX, textY);
            textY += 34;
        }
    }

    public void drawSubWindow(int x, int y, int width, int height) {

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

    public int getXForAlignedText(String text, int rightX) {

        int length = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        return rightX - length;
    }
}
