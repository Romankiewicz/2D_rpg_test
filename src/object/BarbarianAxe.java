package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.AXE;

public class BarbarianAxe extends Entity {

    public BarbarianAxe(GamePanel gamePanel) {

        super(gamePanel);

        type = AXE;

        name = "Barbarian Axe";

        down[0] = setup("objects", "Barbarian_Axe", gamePanel.tileSize, gamePanel.tileSize);

        attackValue = 4;
        attackArea.width = 50;
        attackArea.height = 50;

        description = "[" + name + "]\n\nATK: " + attackValue;
    }
}
