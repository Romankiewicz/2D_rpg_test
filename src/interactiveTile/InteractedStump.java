package interactiveTile;

import main.GamePanel;

public class InteractedStump extends InteractiveTile{

    GamePanel gamePanel;

    public InteractedStump(GamePanel gamePanel, int col, int row) {

        super(gamePanel, col, row);
        this.gamePanel = gamePanel;

        this.worldX = gamePanel.tileSize * col;
        this.worldY = gamePanel.tileSize * row;

        name = "Stump";
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 0;
        solidArea.height = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        down[0] = setup("objects/interactiveTiles", "Interactive_Tree_Stump", gamePanel.tileSize, gamePanel.tileSize);
    }
}
