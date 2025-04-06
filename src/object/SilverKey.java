package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SILVER_KEY;


public class SilverKey extends Entity {

    public SilverKey(GamePanel gamePanel) {

        super(gamePanel);

        type = SILVER_KEY;

        name = "Silver Key";

        solidArea.x = 20;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        down[0] = setup("objects", "Key_Silver", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA Silver Key\nmaybe open´s a Door.";
    }
}
