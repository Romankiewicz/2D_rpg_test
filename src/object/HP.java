package object;

import entity.Entity;
import main.GamePanel;


public class HP extends Entity {

    public HP(GamePanel gamePanel) {

        super(gamePanel);

        name = "Heart";
        image = setup("objects", "Heart_Full", gamePanel.tileSize, gamePanel.tileSize);
        image1 = setup("objects", "Heart_Half", gamePanel.tileSize, gamePanel.tileSize);
        image2 = setup("objects", "Heart_Empty", gamePanel.tileSize, gamePanel.tileSize);

    }
}
