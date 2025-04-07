package interactiveTile;

import main.GamePanel;



public class DoorOpen extends InteractiveTile{

    GamePanel gamePanel;

    public DoorOpen(GamePanel gamePanel, int col, int row) {

        super(gamePanel, col, row);
        this.gamePanel = gamePanel;

        this.worldX = gamePanel.tileSize * col;
        this.worldY = gamePanel.tileSize * row;


        name = "Door Open";
        solidArea.x = 0;
        solidArea.y = 0;
        solidArea.width = 0;
        solidArea.height = 0;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;

        down[0] = setup("objects/interactiveTiles", "Interactive_Door_Open", gamePanel.tileSize, gamePanel.tileSize);
    }
}
