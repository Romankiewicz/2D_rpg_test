package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.BLUE_KEY;


public class BlueKey extends Entity {


    public BlueKey(GamePanel gamePanel) {

        super(gamePanel);

        type = BLUE_KEY;

        name = "Blue Key";
        down[0] = setup("objects", "Key_Blue", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA Blue Key\nwonder what this does.";
    }

}
