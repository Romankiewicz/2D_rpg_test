package object;

import entity.Entity;
import entity.EntityType;
import main.GamePanel;

import static entity.EntityType.OBJECT;


public class ChestOpen extends Entity {

    public ChestOpen(GamePanel gamePanel) {

        super(gamePanel);

        type = OBJECT;

        name = "OpenChest";
        down[0] = setup("objects", "Chest_Open", gamePanel.tileSize, gamePanel.tileSize);
        collision = true;
    }
}
