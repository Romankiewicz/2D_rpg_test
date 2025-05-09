package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SHIELD;

public class BlueShield extends Entity {

    public BlueShield(GamePanel gamePanel) {

        super(gamePanel);

        type = SHIELD;

        name = "Blue Shield";

        solidArea.x = 16;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        defenseValue = 3;

        down[0] = setup("objects/shields", "Blue_Shield", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA Shield \nmade of Metal.\nDEF: +" + defenseValue +
                "\nScale DEX";
    }
}
