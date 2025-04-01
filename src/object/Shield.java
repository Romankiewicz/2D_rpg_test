package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SHIELD;


public class Shield extends Entity {

    public Shield(GamePanel gamePanel) {

        super(gamePanel);

        type = SHIELD;

        name = "Wooden Shield";

        down[0] = setup("objects", "Shield_1", gamePanel.tileSize, gamePanel.tileSize);

        defenseValue = 2;

        description = "[" + name + "]\n\nDEF: " + defenseValue;
    }

}
