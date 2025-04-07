package interactiveTile;

import entity.Entity;
import main.GamePanel;

public class InteractiveTile extends Entity {

    GamePanel gamePanel;
    public boolean interactive = false;
    public boolean destructible = false;


    public InteractiveTile(GamePanel gamePanel, int col, int row) {

        super(gamePanel);
        this.gamePanel = gamePanel;
    }

    public boolean isRequiredItem(Entity entity) {
        return false;
    }

    public void playSFX() {}

    public InteractiveTile getInteractedTile() {
        return null;
    }

    public void update() {
    }
}
