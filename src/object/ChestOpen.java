package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.CHEST;



public class ChestOpen extends Entity {

    public ChestOpen(GamePanel gamePanel) {

        super(gamePanel);

        type = CHEST;

        name = "OpenChest";
        down[0] = setup("objects", "Chest_Open", gamePanel.tileSize, gamePanel.tileSize);
        collision = true;
    }
}
