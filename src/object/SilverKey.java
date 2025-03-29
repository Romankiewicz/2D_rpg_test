package object;

import entity.Entity;
import main.GamePanel;


public class SilverKey extends Entity {

    public SilverKey(GamePanel gamePanel) {

        super(gamePanel);

        name = "SilverKey";
        down[0] = setup("objects", "Key_Silver", gamePanel.tileSize, gamePanel.tileSize);
    }
}
