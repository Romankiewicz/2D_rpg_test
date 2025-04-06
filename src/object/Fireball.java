package object;

import entity.Entity;
import entity.Projectile;
import main.GamePanel;

public class Fireball extends Projectile {

    public GamePanel gamePanel;

    public Fireball(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        name = "Fireball";

        speed = 6;
        maxHp = 80;
        hp = maxHp;
        attack = 2;
        useCost = 1;
        isAlive = false;
        threeSprites = true;

        solidArea.x = 21;
        solidArea.y = 21;
        solidArea.width = 30;
        solidArea.height = 30;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        getProjectileImage();
    }

    public void getProjectileImage() {

        for ( int i = 0 ; i < 3 ; i++ ) {
            up[i] = setup("objects/projectiles/fireball", "Fireball_Up_" + (i+1), gamePanel.tileSize, gamePanel.tileSize);
        }
        for ( int i = 0 ; i < 3 ; i++ ) {
            down[i] = setup("objects/projectiles/fireball", "Fireball_Down_" + (i+1), gamePanel.tileSize,
                    gamePanel.tileSize);
        }
        for ( int i = 0 ; i < 3 ; i++ ) {
            left[i] = setup("objects/projectiles/fireball", "Fireball_Left_" + (i+1), gamePanel.tileSize,
                    gamePanel.tileSize);
        }
        for ( int i = 0 ; i < 3 ; i++ ) {
            right[i] = setup("objects/projectiles/fireball", "Fireball_Right_" + (i+1), gamePanel.tileSize,
                    gamePanel.tileSize);
        }
    }

    public boolean haveResource(Entity user) {

        return user.mp >= useCost;
    }

    public void useResource(Entity user) {

        user.mp -= useCost;
    }
}
