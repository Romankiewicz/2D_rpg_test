package object;

import entity.Entity;
import main.GamePanel;


public class BlueKey extends Entity {


    public BlueKey(GamePanel gamePanel) {

        super(gamePanel);

        name = "Blue Key";

        solidArea.x = 20;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        down[0] = setup("objects", "Key_Blue", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA Blue Key\nwonder what this does.";
    }

}
