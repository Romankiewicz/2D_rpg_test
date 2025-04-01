package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.DOOR;


public class Door extends Entity {

    public Door(GamePanel gamePanel) {

        super(gamePanel);

        type = DOOR;

        name = "Door";
        down[0] = setup("objects", "Door", gamePanel.tileSize, gamePanel.tileSize);
        collision = true;
    }
}
