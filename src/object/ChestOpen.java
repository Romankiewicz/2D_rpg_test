package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ChestOpen extends Entity {


    public ChestOpen(GamePanel gamePanel) {

        super(gamePanel);

        name = "OpenChest";
        down[0] = setup("objects", "Chest_Open");
        collision = true;
    }
}
