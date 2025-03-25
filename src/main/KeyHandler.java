package main;


import entity.Entity;
import entity.NpcNakedGuy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed;
    public boolean upReleased, downReleased, leftReleased, rightReleased;
    GamePanel gamePanel;


    public KeyHandler(GamePanel gamePanel) {

        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        //Play State
        if (gamePanel.gameState == gamePanel.playState) {

            if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                upPressed = true;
                upReleased = false;
            }
            if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                downPressed = true;
                downReleased = false;
            }
            if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                leftPressed = true;
                leftReleased = false;
            }
            if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                rightPressed = true;
                rightReleased = false;
            }
            if (key == KeyEvent.VK_P) {
                gamePanel.gameState = gamePanel.pauseState;
            }
            if (key == KeyEvent.VK_SPACE) {
                spacePressed = true;
            }
        }
        //Pause State
        else if (gamePanel.gameState == gamePanel.pauseState) {
            if (key == KeyEvent.VK_P) {
                gamePanel.gameState = gamePanel.playState;
            }
        }
        //Dialogue State
        else if (gamePanel.gameState == gamePanel.dialogueState) {
            if (key == KeyEvent.VK_SPACE) {
                gamePanel.gameState = gamePanel.playState;
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
            upPressed = false;
            upReleased = true;
        }
        if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
            downPressed = false;
            downReleased = true;

        }
        if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
            leftPressed = false;
            leftReleased = true;
        }
        if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
            rightPressed = false;
            rightReleased = true;
        }
    }
}
