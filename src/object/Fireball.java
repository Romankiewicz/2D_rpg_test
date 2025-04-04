package object;

import entity.Projectile;
import main.GamePanel;

public class Fireball extends Projectile {

    public GamePanel gamePanel;

    public Fireball(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        name = "Fireball";

        speed = 5;
        maxHp = 80;
        hp = maxHp;
        attackValue = 2;
        useCost = 1;
        isAlive = false;
        threeSprites = true;

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
}
