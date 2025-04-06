package object;

import entity.Projectile;
import main.GamePanel;

public class Arrow extends Projectile {

    GamePanel gamePanel;

    public Arrow(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        name = "Arrow";

        speed = 7;
        maxHp = 60;
        hp = maxHp;
        attack = 2;
        isAlive = false;

        solidArea.x = 26;
        solidArea.y = 26;
        solidArea.width = 20;
        solidArea.height = 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getImage();
    }

    public void getImage() {
        up[0] = setup("objects/projectiles/arrow", "Wooden_Arrow_Up", gamePanel.tileSize, gamePanel.tileSize);
        down[0] = setup("objects/projectiles/arrow", "Wooden_Arrow_Down", gamePanel.tileSize, gamePanel.tileSize);
        left[0] = setup("objects/projectiles/arrow", "Wooden_Arrow_Left", gamePanel.tileSize, gamePanel.tileSize);
        right[0] = setup("objects/projectiles/arrow", "Wooden_Arrow_Right", gamePanel.tileSize, gamePanel.tileSize);
    }
}
