package object;

import entity.Entity;
import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Heart extends Entity {

    public Heart(GamePanel gamePanel) {

        super(gamePanel);

        name = "heart";
        image = setup("objects", "Heart_Full");
        image1 = setup("objects", "Heart_Half");
        image2 = setup("objects", "Heart_Empty");

    }
}
