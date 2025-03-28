package object;

import entity.Entity;
import main.GamePanel;


public class Door extends Entity {

    public Door(GamePanel gamePanel) {

        super(gamePanel);

        name = "Door";
        down[0] = setup("objects", "Door");
        collision = true;
    }
}
