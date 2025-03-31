package enemy;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

import static entity.EntityType.ENEMY;

public class BlueOctorok extends Entity {

    GamePanel gamePanel;

    public BlueOctorok(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        type = ENEMY;
        typeNum = 2;
        
        name = "BlueOctorok";
        speed = 1;
        maxHp = 10;
        hp = maxHp;
        attack = 6;
        defense = 1;

        solidArea.x = 12;
        solidArea.y = 18;
        solidArea.width = 48;
        solidArea.height = 42;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        twoSprites = true;
        getImage();
    }

    public void getImage() {

        for (int i = 0; i < 2; i++) {
            up[i] = setup("enemies/blueOctorok", "Octorok_Blue_Up_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
        for (int i = 0; i < 2; i++) {
            down[i] = setup("enemies/blueOctorok", "Octorok_Blue_Down_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
        for (int i = 0; i < 2; i++) {
            left[i] = setup("enemies/blueOctorok", "Octorok_Blue_Left_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
        for (int i = 0; i < 2; i++) {
            right[i] = setup("enemies/blueOctorok", "Octorok_Blue_Right_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
    }

    public void setAction() {

        actionCounter++;

        if (actionCounter == 80) {
            Random random = new Random();
            int i = random.nextInt(200) + 1;

            if (i <= 50) {
                direction = "up";
            }
            if (i > 50 && i <= 100) {
                direction = "down";
            }
            if (i > 100 && i <= 150) {
                direction = "left";
            }
            if (i > 150) {
                direction = "right";
            }
            actionCounter = 0;
        }
    }
    public void damageReaction() {

        actionCounter = 0;
        switch (gamePanel.player.direction) {
            case "up", "standingUp" -> direction = "down";
            case "down", "standingDown" -> direction = "up";
            case "left", "standingLeft" -> direction = "right";
            case "right", "standingRight" -> direction = "left";
        }
    }
}
