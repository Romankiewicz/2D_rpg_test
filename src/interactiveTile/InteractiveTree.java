package interactiveTile;

import entity.Entity;
import main.GamePanel;

import static entity.EntityType.AXE;
import static entity.EntityType.WOODCUTTER_AXE;

public class InteractiveTree extends InteractiveTile {

    GamePanel gamePanel;

    public InteractiveTree(GamePanel gamePanel, int col, int row) {

        super(gamePanel, col, row);
        this.gamePanel = gamePanel;

        this.worldX = gamePanel.tileSize * col;
        this.worldY = gamePanel.tileSize * row;

        name = "Tree";
        down[0] = setup("objects/interactiveTiles", "Interactive_Tree", gamePanel.tileSize, gamePanel.tileSize);
        interactive = true;
        destructible = true;
    }
    public boolean isRequiredItem(Entity entity) {

        boolean isRequiredItem = false;

        if (entity.currentWeapon != null) {
            if (entity.currentWeapon.type == WOODCUTTER_AXE) {
                isRequiredItem = true;
            }
        }
        return isRequiredItem;
    }

    public void playSFX() {
        gamePanel.playSFX(4);
    }

    public InteractiveTile getInteractedTile() {

        playSFX();
        return new InteractedStump(gamePanel, worldX / gamePanel.tileSize, worldY / gamePanel.tileSize);
    }

}
