package interactiveTile;

import entity.Entity;
import main.GamePanel;

public class InteractiveTile extends Entity {

    GamePanel gamePanel;
    public boolean interactive = false;


    public InteractiveTile(GamePanel gamePanel, int col, int row) {

        super(gamePanel);
        this.gamePanel = gamePanel;
    }

    public void update() {
    }
}
