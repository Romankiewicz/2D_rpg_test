package main;

import entity.Entity;
import entity.Player;
import interactiveTile.InteractiveTile;
import tile.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

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
    float defaultMusicVolume = 0.0f;
    float defaultSfxVolume = 0.0f;

    //System
    TileManager tileManager = new TileManager(this);
    public KeyHandler keyHandler = new KeyHandler(this);
    public EventHandler eventHandler = new EventHandler(this);
    Thread gameThread;
    public UI ui = new UI(this);

    //Entity and Objects
    public Player player = new Player(this, keyHandler);
    public Entity[] objects = new Entity[30];
    public Entity[] npcs = new Entity[10];
    public Entity[] enemies = new Entity[20];
    public InteractiveTile[] interactiveTiles = new InteractiveTile[10];
    public ArrayList<Entity> entities = new ArrayList<>();
    public ArrayList<Entity> projectiles = new ArrayList<>();
    public ArrayList<Entity> particles = new ArrayList<>();
    public AssetSetter assetSetter = new AssetSetter(this);
    public CollisionChecker collisionChecker = new CollisionChecker(this);

    //Game State
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    public final int statsState = 4;


    public GamePanel() {


        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void setupGame() {

        assetSetter.setObject();
        assetSetter.setNpc();
        assetSetter.setEnemies();
        assetSetter.setInteractiveTiles();
        playMusic(5);
        gameState = titleState;
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
            for (Entity npc : npcs) {
                if (npc != null) {
                    npc.update();
                }
            }

            for (int i = 0; i < enemies.length; i++) {
                if (enemies[i] != null) {
                    if (enemies[i].isAlive && !enemies[i].isDying) {
                        enemies[i].update();
                    }
                    if (!enemies[i].isAlive) {
                        enemies[i].checkDrop();
                        enemies[i] = null;
                    }
                }
            }

            for (int i = 0; i < projectiles.size(); i++) {
                if (projectiles.get(i) != null) {
                    if (projectiles.get(i).isAlive) {
                        projectiles.get(i).update();
                    }
                }
                if (!projectiles.get(i).isAlive) {
                    projectiles.remove(i);
                }
            }
            for (InteractiveTile interactiveTile : interactiveTiles) {
                if (interactiveTile != null) {
                    interactiveTile.update();
                }
            }
        }
        if (gameState == pauseState) {
            music.stop();
        }
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        long drawStart = 0;
        if (keyHandler.showDebugText) {
            drawStart = System.nanoTime();
        }

        if (gameState == titleState) {
            ui.draw(g2);
        } else {

            tileManager.draw(g2);

            for (InteractiveTile interactiveTile : interactiveTiles) {
                if (interactiveTile != null) {
                    interactiveTile.draw(g2);
                }
            }

            entities.add(player);

            for (Entity npc : npcs) {
                if (npc != null) {
                    entities.add(npc);
                }
            }

            for (Entity object : objects) {
                if (object != null) {
                    entities.add(object);
                }
            }

            for (Entity enemy : enemies) {
                if (enemy != null) {
                    entities.add(enemy);
                }
            }

            for (Entity projectile : projectiles) {
                if (projectile != null) {
                    entities.add(projectile);
                }
            }
        }

        entities.sort(Comparator.comparingInt(o -> o.worldY));

        for (Entity entity : entities) {
            entity.draw(g2);
        }

        entities.clear();


        ui.draw(g2);

        if (keyHandler.showDebugText) {
            long drawEnd = System.nanoTime();
            long deltaTime = drawEnd - drawStart;
            int x = 10;
            int y = tileSize * 10;
            int lineHeight = 20;


            g2.setColor(Color.orange);
            g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g2.drawString("WorldX: " + player.worldX, x, y);
            y += lineHeight;
            g2.drawString("WorldY: " + player.worldY, x, y);
            y += lineHeight;
            g2.drawString("Col: " + (player.worldX + player.solidArea.x) / tileSize, x, y);
            y += lineHeight;
            g2.drawString("Row: " + (player.worldY + player.solidArea.y) / tileSize, x, y);
            y += lineHeight;
            g2.drawString("Draw Time: " + deltaTime, x, y);
            y += lineHeight;
            g2.drawString("Direction: " + player.direction, x, y);
            y += lineHeight;
            g2.drawString("Last Direction: " + player.lastDirection, x, y);
        }

        g2.dispose();
    }

    public void playMusic(int i) {

        music.setFile(i);
        music.setVolume(defaultMusicVolume);
        music.play();
        music.loop();
    }

    public void stopMusic() {

        music.stop();
    }

    public void playSFX(int i) {

        sfx.setFile(i);
        sfx.setVolume(defaultSfxVolume);
        sfx.play();
    }
}

