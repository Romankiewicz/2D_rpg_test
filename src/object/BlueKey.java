package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.OBJECT;


public class BlueKey extends Entity {


    public BlueKey(GamePanel gamePanel) {

        super(gamePanel);

        type = OBJECT;

        name = "Blue Key";
        down[0] = setup("objects", "Key_Blue", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\n\nA Blue Key";
    }

}
