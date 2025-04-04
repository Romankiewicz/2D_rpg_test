package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SWORD;

public class OldSword extends Entity {

    public OldSword(GamePanel gamePanel) {

        super(gamePanel);

        type = SWORD;

        name = "Old Sword";

        down[0] = setup("objects/weapons", "Old_Sword", gamePanel.tileSize, gamePanel.tileSize);

        attackValue = 3;
        attackArea.width = 43;
        attackArea.height = 43;

        description = "[" + name + "]\nA old and rusty Sword.\nATK: +" + attackValue +
                "\nScale STR";
    }
}
