package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SHIELD;

public class BlueShield extends Entity {

    public BlueShield(GamePanel gamePanel) {

        super(gamePanel);

        type = SHIELD;

        name = "Blue Shield";

        down[0] = setup("objects", "Blue_Shield", gamePanel.tileSize, gamePanel.tileSize);

        defenseValue = 3;

        description = "[" + name + "]\nA Shield \nmade of Metal.\nDEF: +" + defenseValue +
                "\nScale DEX";
    }
}
