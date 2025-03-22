package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class BlueKey extends SuperObject {


    public BlueKey() {

        name = "BlueKey";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/Key_Blue.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
