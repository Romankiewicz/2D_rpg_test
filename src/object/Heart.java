package object;

import main.GamePanel;
import main.UtilityTool;

import javax.imageio.ImageIO;
import java.io.IOException;
import java.util.Objects;

public class Heart extends SuperObject {

    GamePanel gamePanel;

    public Heart(GamePanel gamePanel) {

        this.gamePanel = gamePanel;

        name = "heart";

        UtilityTool utilityTool = new UtilityTool();

        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/Heart_Full.png")));
            image1 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/Heart_Half.png")));
            image2 = ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/objects/Heart_Empty.png")));

            image = utilityTool.scaleImage(image, gamePanel.tileSize, gamePanel.tileSize);
            image1 = utilityTool.scaleImage(image1, gamePanel.tileSize, gamePanel.tileSize);
            image2 = utilityTool.scaleImage(image2, gamePanel.tileSize, gamePanel.tileSize);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
