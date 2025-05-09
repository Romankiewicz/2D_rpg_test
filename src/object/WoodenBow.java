package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.BOW;

public class WoodenBow extends Entity {

    public WoodenBow(GamePanel gamePanel) {

        super(gamePanel);

        type = BOW;

        name = "Wooden Bow";

        solidArea.x = 16;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        down[0] = setup("objects/weapons", "Wooden_Bow", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA Hunting-Bow\nmade of Wood.";
    }

}
