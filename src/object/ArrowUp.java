package object;

import entity.Projectile;
import main.GamePanel;

public class ArrowUp extends Projectile {

    public ArrowUp(GamePanel gamePanel) {

        super(gamePanel);

        name = "Arrow";

        speed = 5;
        maxHp = 80;
        hp = maxHp;
        attackValue = 2;

    }
}
