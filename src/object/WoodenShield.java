package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SHIELD;


public class WoodenShield extends Entity {

    public WoodenShield(GamePanel gamePanel) {

        super(gamePanel);

        type = SHIELD;

        name = "Wooden Shield";

        down[0] = setup("objects/shields", "Wooden_Shield", gamePanel.tileSize, gamePanel.tileSize);

        defenseValue = 2;

        description = "[" + name + "]\nA Shield \nmade of Wood.\nDEF: +" + defenseValue +
                "\nScale DEX";
    }

}
