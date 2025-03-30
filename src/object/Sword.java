package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.OBJECT;

public class Sword extends Entity {

    public Sword(GamePanel gamePanel) {

        super(gamePanel);

        type = OBJECT;

        name = "Sword";

        down[0] = setup("objects", "Sword_1", gamePanel.tileSize, gamePanel.tileSize);
    }

}
