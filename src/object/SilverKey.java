package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.OBJECT;


public class SilverKey extends Entity {

    public SilverKey(GamePanel gamePanel) {

        super(gamePanel);

        type = OBJECT;

        name = "SilverKey";
        down[0] = setup("objects", "Key_Silver", gamePanel.tileSize, gamePanel.tileSize);
    }
}
