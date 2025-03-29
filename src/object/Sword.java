package object;

import entity.Entity;
import main.GamePanel;

public class Sword extends Entity {

    public Sword(GamePanel gamePanel) {

        super(gamePanel);

        name = "Sword";

        down[0] = setup("objects", "Sword_1", gamePanel.tileSize, gamePanel.tileSize);
    }

}
