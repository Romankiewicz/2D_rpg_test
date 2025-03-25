package main;

import entity.Player;
import object.SuperObject;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    //Screen settings

    private final int originalTileSize = 24;
    private final int scale = 3;

    public final int tileSize = originalTileSize * scale; // ==> 72x72 pixels
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol; // ==> 1152 pixels
    public final int screenHeight = tileSize * maxScreenRow;// ==> 864 pixels

    public final int maxWorldCol = 25;
    public final int maxWorldRow = 25;

    public final int fps = 60;

    //Sound
    Sound music = new Sound();
    Sound sfx = new Sound();

    //System
    TileManager tileManager = new TileManager(this);

    KeyHandler keyHandler = new KeyHandler(this);

    Thread gameThread;

    UI ui = new UI(this);

    //Player and Objects
    public Player player = new Player(this, keyHandler);

    public SuperObject[] superObject = new SuperObject[10];

    public AssetSetter assetSetter = new AssetSetter(this);

    public CollisionChecker collisionChecker = new CollisionChecker(this);

    //Game State
    public int gameState;
    public int playState = 1;
    public final int pauseState = 2;



    public GamePanel() {

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupGame(){

        assetSetter.setObject();
        playMusic(0);
        gameState = playState;
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

        if (gameState == playState) {
            player.update();
        }
        if (gameState == pauseState) {
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        tileManager.draw(g2);

        for (SuperObject object : superObject) {

            if (object != null) {

                object.draw(g2, this);
            }
        }

        player.draw(g2);

        ui.draw(g2);

        g2.dispose();
    }

    public void playMusic(int i) {

        music.setFile(i);
        music.play();
        music.loop();
    }

    public void stopMusic() {

        music.stop();
    }

    public void playSFX(int i){

        sfx.setFile(i);
        sfx.play();
    }
}
