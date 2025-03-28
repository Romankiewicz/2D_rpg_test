package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class DoorOpen extends Entity {


    public DoorOpen(GamePanel gamePanel) {

        super(gamePanel);

        name = "DoorOpen";
        down[0] = setup("objects", "Door_Open");
        collision = false;
    }

}
