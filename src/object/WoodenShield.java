package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SHIELD;


public class WoodenShield extends Entity {

    public WoodenShield(GamePanel gamePanel) {

        super(gamePanel);

        type = SHIELD;

        name = "Wooden Shield";

        solidArea.x = 16;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        defenseValue = 2;

        down[0] = setup("objects/shields", "Wooden_Shield", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA Shield \nmade of Wood.\nDEF: +" + defenseValue +
                "\nScale DEX";
    }

}
