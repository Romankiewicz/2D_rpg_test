package main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings
    //
    private final int originalTileSize = 24;
    private final int scale = 2;

    final int tileSize = originalTileSize * scale; // ==> 48x48 pixels
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // ==> 768 pixels
    public final int screenHeight = tileSize * maxScreenRow; // ==> 576 pixels

    public final int fps = 60;

    KeyHandler keyHandler = new KeyHandler();

    Thread gameThread;

    Player player = new Player(this, keyHandler);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 3;

    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = (double) 1000000000 / fps;
        double delta = 0;
        long lastTIme = System.nanoTime();
        long currentTime;

        // Game Loop
        while (gameThread != null) {

            currentTime = System.nanoTime();
            delta += (currentTime - lastTIme) / drawInterval;
            lastTIme = currentTime;

            if (delta >= 1) {

                update();
                repaint();
                delta--;
            }

        }
    }

    public void update() {

        if (keyHandler.upPressed) {
            playerY -= playerSpeed;
        }
        if (keyHandler.downPressed) {
            playerY += playerSpeed;
        }
        if (keyHandler.leftPressed) {
            playerX -= playerSpeed;
        }
        if (keyHandler.rightPressed) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.dispose();
    }
}
