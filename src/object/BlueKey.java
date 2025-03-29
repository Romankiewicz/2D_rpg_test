package object;

import entity.Entity;
import main.GamePanel;


public class BlueKey extends Entity {


    public BlueKey(GamePanel gamePanel) {

        super(gamePanel);

        name = "BlueKey";
        down[0] = setup("objects", "Key_Blue",
                gamePanel.tileSize, gamePanel.tileSize);
    }

}
