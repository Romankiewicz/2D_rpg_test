package object;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class SilverKey extends SuperObject {

    public SilverKey() {

        name = "SilverKey";

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/Key_Silver.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
