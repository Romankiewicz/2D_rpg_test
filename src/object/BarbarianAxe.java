package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.AXE;

public class BarbarianAxe extends Entity {

    public BarbarianAxe(GamePanel gamePanel) {

        super(gamePanel);

        type = AXE;

        name = "Barbarian Axe";

        solidArea.x = 16;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        attackValue = 4;
        attackArea.width = 50;
        attackArea.height = 50;

        down[0] = setup("objects/weapons", "Barbarian_Axe", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA Axe that look like \nit´s been used in \nbattle.\nATK:" + attackValue +
                "\nScale STR";
    }
}
