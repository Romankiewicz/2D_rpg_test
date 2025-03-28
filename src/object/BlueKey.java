package object;

import entity.Entity;
import main.GamePanel;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class BlueKey extends Entity {


    public BlueKey(GamePanel gamePanel) {

        super(gamePanel);

        name = "BlueKey";
        down[0] = setup("objects", "Key_Blue");
    }

}
