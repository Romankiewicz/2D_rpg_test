package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Door extends Entity {

    public Door(GamePanel gamePanel) {

        super(gamePanel);

        name = "Door";
        down[0] = setup("objects", "Door");
        collision = true;
    }
}
