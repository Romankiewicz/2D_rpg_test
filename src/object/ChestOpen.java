package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ChestOpen extends SuperObject {


    public ChestOpen() {

        name = "OpenChest";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/Chest_Open.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    collision = true;
    }
}
