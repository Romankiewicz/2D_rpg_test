package object;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.COIN;

public class Coin extends Entity {

    GamePanel gamePanel;

    public Coin(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        type = COIN;
        name = "Coin";
        value = 10;

        solidArea.x = 16;
        solidArea.y = 16;
        solidArea.width = 40;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        down[0] = setup("objects", "Coin", gamePanel.tileSize, gamePanel.tileSize);
    }

    public void use(Entity user) {

        gamePanel.playSFX(3);
        gamePanel.player.gold += value;
    }
}
