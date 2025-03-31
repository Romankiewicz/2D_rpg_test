package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean upPressed, downPressed, leftPressed, rightPressed, spacePressed, enterPressed;
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

        //Title State
        if (gamePanel.gameState == gamePanel.titleState) {

            if (gamePanel.ui.titleScreenState == 0) {
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                    gamePanel.ui.commandNum--;
                    if (gamePanel.ui.commandNum < 0) {
                        gamePanel.ui.commandNum = 3;
                    }
                }
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                    gamePanel.ui.commandNum++;
                    if (gamePanel.ui.commandNum > 3) {
                        gamePanel.ui.commandNum = 0;
                    }
                }
                if (key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE) {
                    if (gamePanel.ui.commandNum == 0) {
                        gamePanel.gameState = gamePanel.playState;
                        gamePanel.stopMusic();
                        gamePanel.playMusic(6);
                    }
                    if (gamePanel.ui.commandNum == 1) {

                    }
                    if (gamePanel.ui.commandNum == 2) {
                        gamePanel.ui.titleScreenState = 1;
                    }
                    if (gamePanel.ui.commandNum == 3) {
                        System.exit(0);
                    }
                }
            }

            //Options Screen
            else if (gamePanel.ui.titleScreenState == 1) {
                if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP) {
                    gamePanel.ui.commandNum--;
                    if (gamePanel.ui.commandNum < 0) {
                        gamePanel.ui.commandNum = 2;
                    }
                }
                if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN) {
                    gamePanel.ui.commandNum++;
                    if (gamePanel.ui.commandNum > 2) {
                        gamePanel.ui.commandNum = 0;
                    }
                }
                if (gamePanel.ui.commandNum == 0) {
                    if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                        if (gamePanel.ui.musicSelectorNum > 0 && gamePanel.ui.musicSelectorNum <= 100) {
                            gamePanel.ui.musicSelectorNum--;
                            gamePanel.defaultMusicVolume -= 0.5f;
                            gamePanel.music.setVolume(gamePanel.defaultMusicVolume);
                        }
                    }
                    if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                        if (gamePanel.ui.musicSelectorNum >= 0 && gamePanel.ui.musicSelectorNum < 100) {
                            gamePanel.ui.musicSelectorNum++;
                            gamePanel.defaultMusicVolume += 0.5f;
                            gamePanel.music.setVolume(gamePanel.defaultMusicVolume);
                        }
                    }
                }

                if (gamePanel.ui.commandNum == 1) {
                    if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT) {
                        if (gamePanel.ui.sfxSelectorNum > 0 && gamePanel.ui.sfxSelectorNum <= 100) {
                            gamePanel.ui.sfxSelectorNum--;
                            gamePanel.defaultSfxVolume -= 0.5f;
                        }
                    }
                    if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT) {
                        if (gamePanel.ui.sfxSelectorNum >= 0 && gamePanel.ui.sfxSelectorNum < 100) {
                            gamePanel.ui.sfxSelectorNum++;
                            gamePanel.defaultSfxVolume += 0.5f;
                        }
                    }
                }

                if (key == KeyEvent.VK_ENTER || key == KeyEvent.VK_SPACE) {
                    if (gamePanel.ui.commandNum == 2) {
                        gamePanel.ui.titleScreenState = 0;
                    }
                }
            }
        }
        //Play State
        else if (gamePanel.gameState == gamePanel.playState) {

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
            if (key == KeyEvent.VK_ENTER) {
                enterPressed = true;
            }
            if ( key == KeyEvent.VK_C) {
                gamePanel.gameState = gamePanel.statsState;
            }
            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        }
        //Pause State
        else if (gamePanel.gameState == gamePanel.pauseState) {
            if (key == KeyEvent.VK_P) {
                gamePanel.gameState = gamePanel.playState;
                gamePanel.playMusic(6);
            }
            if (key == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        }
        //Dialogue State
        else if (gamePanel.gameState == gamePanel.dialogueState) {
            if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
                gamePanel.gameState = gamePanel.playState;
            }
        }

        //Stats State
        else if (gamePanel.gameState == gamePanel.statsState) {
            if (key == KeyEvent.VK_C) {
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
