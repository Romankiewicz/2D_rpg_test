package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.CONSUMABLE;

public class Ether extends Entity {

    GamePanel gamePanel;


    public Ether(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        type = CONSUMABLE;

        name = "Ether";
        value = 1;

        solidArea.x = 16;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        down[0] = setup("objects", "Ether", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA mysterious liquid\nbrewed by a Witch.\nMP: +" + value;
    }

    public void use(Entity entity) {

        entity.mp += value;
        gamePanel.playSFX(9);
    }

}
