package interactiveTile;

import main.GamePanel;

import static entity.EntityType.DOOR;

public class Door extends InteractiveTile {

    GamePanel gamePanel;

    public Door(GamePanel gamePanel, int col, int row) {

        super(gamePanel, col, row);
        this.gamePanel = gamePanel;

        this.worldX = gamePanel.tileSize * col;
        this.worldY = gamePanel.tileSize * row;

        type = DOOR;

        name = "Door";
        down[0] = setup("objects", "Door", gamePanel.tileSize, gamePanel.tileSize);
        interactive = true;
    }

}
