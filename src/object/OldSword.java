package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SWORD;

public class OldSword extends Entity {

    public OldSword(GamePanel gamePanel) {

        super(gamePanel);

        type = SWORD;

        name = "Old Sword";

        solidArea.x = 20;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        attackValue = 3;
        attackArea.width = 43;
        attackArea.height = 43;

        down[0] = setup("objects/weapons", "Old_Sword", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA old and rusty Sword.\nATK: +" + attackValue +
                "\nScale STR";
    }
}
