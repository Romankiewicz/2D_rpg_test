package object;

import entity.Entity;
import main.GamePanel;


public class ChestClosed extends Entity {

    public ChestClosed(GamePanel gamePanel) {

        super(gamePanel);

        name = "Chest";
        down[0] = setup("objects", "Chest", gamePanel.tileSize, gamePanel.tileSize);
        collision = true;
    }
}
