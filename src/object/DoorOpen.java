package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.OBJECT;


public class DoorOpen extends Entity {


    public DoorOpen(GamePanel gamePanel) {

        super(gamePanel);

        type = OBJECT;

        name = "DoorOpen";
        down[0] = setup("objects", "Door_Open", gamePanel.tileSize, gamePanel.tileSize);
        collision = false;
    }

}
