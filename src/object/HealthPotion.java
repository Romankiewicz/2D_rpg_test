package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.CONSUMABLE;

public class HealthPotion extends Entity {

    GamePanel gamePanel;

    public HealthPotion(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        type = CONSUMABLE;

        name = "Health Potion";
        value = 2;

        solidArea.x = 16;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        down[0] = setup("objects", "Health_Potion", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA mysterious liquid\nbrewed by a Witch.\nHP: +" + value;
    }

    public void use(Entity entity) {

        entity.hp += value;
        gamePanel.playSFX(9);
    }
}
