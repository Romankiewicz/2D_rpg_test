package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ChestClosed extends Entity {

    public ChestClosed(GamePanel gamePanel) {

        super(gamePanel);

        name = "Chest";
        down[0] = setup("objects", "Chest");
        collision = true;
    }
}
