package enemy;

import entity.Entity;
import entity.EntityType;
import main.GamePanel;

import java.util.Random;

import static entity.EntityType.ENEMY;

public class RedOctorok extends Entity {

    GamePanel gamePanel;

    public RedOctorok(GamePanel gamePanel) {

        super(gamePanel);
        this.gamePanel = gamePanel;

        type = ENEMY;
        typeNum = 2;

        name = "RedOctorok";
        speed = 1;
        maxHp = 6;
        hp = maxHp;
        attack = 4;
        defense = 2;
        xp = 2;

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
            up[i] = setup("enemies/redOctorok", "Octorok_Red_Up_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
        for (int i = 0; i < 2; i++) {
            down[i] = setup("enemies/redOctorok", "Octorok_Red_Down_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
        for (int i = 0; i < 2; i++) {
            left[i] = setup("enemies/redOctorok", "Octorok_Red_Left_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
        for (int i = 0; i < 2; i++) {
            right[i] = setup("enemies/redOctorok", "Octorok_Red_Right_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
    }

    public void setAction() {

        actionCounter++;

        if (actionCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(40) + 1;

            if (i <= 10) {
                direction = "up";
            }
            if (i > 10 && i <= 20) {
                direction = "down";
            }
            if (i > 20 && i <= 30) {
                direction = "left";
            }
            if (i > 30) {
                direction = "right";
            }
            actionCounter = 0;
        }
    }
    public void damageReaction() {

        actionCounter = 0;
        switch (gamePanel.player.direction) {
            case "up", "standingUp" -> direction = "up";
            case "down", "standingDown" -> direction = "down";
            case "left", "standingLeft" -> direction = "left";
            case "right", "standingRight" -> direction = "right";
        }
    }
}
