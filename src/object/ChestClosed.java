package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.CHEST;


public class ChestClosed extends Entity {

    public ChestClosed(GamePanel gamePanel) {

        super(gamePanel);

        type = CHEST;

        name = "Chest";
        down[0] = setup("objects", "Chest", gamePanel.tileSize, gamePanel.tileSize);
        collision = true;
    }
}
