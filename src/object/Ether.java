package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.CONSUMABLE;

public class Ether extends Entity {

    GamePanel gamePanel;
    int value = 1;

    public Ether(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        type = CONSUMABLE;

        name = "Ether";
        down[0] = setup("objects", "Ether", gamePanel.tileSize, gamePanel.tileSize);

        description = "[" + name + "]\nA mysterious liquid\nbrewed by a Witch.\nHP: +" + value;
    }

    public void use(Entity entity) {

        entity.mp += value;
        if(gamePanel.player.mp > gamePanel.player.maxMp) {
            gamePanel.player.mp = gamePanel.player.maxMp;
        }
        gamePanel.playSFX(9);
    }

}
