package interactiveTile;

import entity.Entity;
import main.GamePanel;


public class Door extends InteractiveTile {

    GamePanel gamePanel;

    public Door(GamePanel gamePanel, int col, int row) {

        super(gamePanel, col, row);
        this.gamePanel = gamePanel;

        this.worldX = gamePanel.tileSize * col;
        this.worldY = gamePanel.tileSize * row;

        name = "Door";
        down[0] = setup("objects/interactiveTiles", "Interactive_Door", gamePanel.tileSize, gamePanel.tileSize);
        interactive = true;
        destructible = true;
    }
    public boolean isRequiredItem(Entity entity) {

        boolean isRequiredItem = false;
        return isRequiredItem;
    }

    public void playSFX() {
        gamePanel.playSFX(4);
    }

    public InteractiveTile getInteractedTile() {

        playSFX();
        return new DoorOpen(gamePanel, worldX / gamePanel.tileSize, worldY / gamePanel.tileSize);
    }
}
