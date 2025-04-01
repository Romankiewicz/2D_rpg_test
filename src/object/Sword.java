package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SWORD;

public class Sword extends Entity {

    public Sword(GamePanel gamePanel) {

        super(gamePanel);

        type = SWORD;

        name = "Normal Sword";

        down[0] = setup("objects", "Sword_1", gamePanel.tileSize, gamePanel.tileSize);

        attackValue = 3;
        attackArea.width = 43;
        attackArea.height = 43;

        description = "[" + name + "]\n\nATK: " + attackValue;
    }
}
