package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.AXE;

public class WoodcutterAxe extends Entity {

    public WoodcutterAxe(GamePanel gamePanel) {

        super(gamePanel);

        type = AXE;

        name = "Woodcutter Axe";

        down[0] = setup("objects", "Woodcutter_Axe", gamePanel.tileSize, gamePanel.tileSize);

        attackValue = 2;
        attackArea.width = 50;
        attackArea.height = 50;

        description = "[" + name + "]\n\nATK: " + attackValue;
    }
}
