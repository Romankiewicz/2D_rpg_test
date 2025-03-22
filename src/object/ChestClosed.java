package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class ChestClosed extends SuperObject{

    public ChestClosed() {

        name = "Chest";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/Chest.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        collision = true;
    }
}
