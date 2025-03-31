package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.OBJECT;

public class Shield extends Entity {

    public Shield(GamePanel gamePanel) {

        super(gamePanel);

        type = OBJECT;

        name = "Shield";

        down[0] = setup("objects", "Shield_1", gamePanel.tileSize, gamePanel.tileSize);

        defenseValue = 2;
    }

}
