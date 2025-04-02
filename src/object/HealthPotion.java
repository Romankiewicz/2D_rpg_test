package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.CONSUMABLE;

public class HealthPotion extends Entity {

    GamePanel gamePanel;
    int value = 2;

    public HealthPotion(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        type = CONSUMABLE;

        name = "Health Potion";
        down[0] = setup("objects", "Health_Potion", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA mysterious liquid\nbrewed by a Witch.\nHP: +" + value;
    }

    public void use(Entity entity) {

        entity.hp += value;
        if(gamePanel.player.hp > gamePanel.player.maxHp) {
            gamePanel.player.hp = gamePanel.player.maxHp;
        }
        gamePanel.playSFX(9);
    }
}
