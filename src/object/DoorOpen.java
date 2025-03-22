package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class DoorOpen extends SuperObject {


    public DoorOpen() {

        name = "DoorOpen";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/Door_Open.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = false;
    }

}
