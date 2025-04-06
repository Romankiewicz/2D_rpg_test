package object;

import entity.Projectile;
import main.GamePanel;

public class Pebble extends Projectile {

    GamePanel gamePanel;

    public Pebble(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        name = "Pebble+";

        speed = 7;
        maxHp = 60;
        hp = maxHp;
        attack = 2;
        isAlive = false;

        solidArea.x = 26;
        solidArea.y = 26;
        solidArea.width = 30;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {

        up[0] = setup("objects/projectiles", "Pebble", gamePanel.tileSize, gamePanel.tileSize);
        down[0] = setup("objects/projectiles", "Pebble", gamePanel.tileSize, gamePanel.tileSize);
        left[0] = setup("objects/projectiles", "Pebble", gamePanel.tileSize, gamePanel.tileSize);
        right[0] = setup("objects/projectiles", "Pebble", gamePanel.tileSize, gamePanel.tileSize);
    }
}
