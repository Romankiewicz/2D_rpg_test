package object;

import entity.Entity;
import main.GamePanel;


public class DoorOpen extends Entity {


    public DoorOpen(GamePanel gamePanel) {

        super(gamePanel);

        name = "DoorOpen";
        down[0] = setup("objects", "Door_Open", gamePanel.tileSize, gamePanel.tileSize);
        collision = false;
    }

}
