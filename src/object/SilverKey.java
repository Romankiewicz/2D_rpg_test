package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class SilverKey extends Entity {

    public SilverKey(GamePanel gamePanel) {

        super(gamePanel);

        name = "SilverKey";
        down[0] = setup("objects", "Key_Silver");
    }
}
