package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.OBJECT;


public class ChestClosed extends Entity {

    public ChestClosed(GamePanel gamePanel) {

        super(gamePanel);

        type = OBJECT;

        name = "Chest";
        down[0] = setup("objects", "Chest", gamePanel.tileSize, gamePanel.tileSize);
        collision = true;
    }
}
