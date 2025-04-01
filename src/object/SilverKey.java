package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.SILVER_KEY;


public class SilverKey extends Entity {

    public SilverKey(GamePanel gamePanel) {

        super(gamePanel);

        type = SILVER_KEY;

        name = "Silver Key";
        down[0] = setup("objects", "Key_Silver", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\n\nA Silver Key";
    }
}
