package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.AXE;

public class WoodcutterAxe extends Entity {

    public WoodcutterAxe(GamePanel gamePanel) {

        super(gamePanel);

        type = AXE;

        name = "Woodcutter Axe";

        solidArea.x = 16;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        attackValue = 2;
        attackArea.width = 50;
        attackArea.height = 50;

        down[0] = setup("objects/weapons", "Woodcutter_Axe", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA Axe to cut trees.\nATK: +" + attackValue +
                "\nScale STR";
    }
}
