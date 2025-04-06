package object;

import entity.Entity;
import main.GamePanel;

public class MP extends Entity {

    public MP(GamePanel gamePanel) {

        super(gamePanel);

        name = "Mana Crystal";
        image = setup("objects", "MP_Full", gamePanel.tileSize, gamePanel.tileSize);
        image1 = setup("objects", "MP_Empty", gamePanel.tileSize, gamePanel.tileSize);

    }
}
