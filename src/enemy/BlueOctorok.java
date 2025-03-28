package enemy;

import entity.Entity;
import main.GamePanel;

import java.util.Random;

public class BlueOctorok extends Entity {

    public BlueOctorok(GamePanel gamePanel) {

        super(gamePanel);

        name = "BlueOctorok";
        speed = 3;
        maxHp = 4;
        hp = maxHp;

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
            up[i] = setup("enemies/blueOctorok", "Octorok_Blue_Up_" + (i + 1));
        }
        for (int i = 0; i < 2; i++) {
            down[i] = setup("enemies/blueOctorok", "Octorok_Blue_Down_" + (i + 1));
        }
        for (int i = 0; i < 2; i++) {
            left[i] = setup("enemies/blueOctorok", "Octorok_Blue_Left_" + (i + 1));
        }
        for (int i = 0; i < 2; i++) {
            right[i] = setup("enemies/blueOctorok", "Octorok_Blue_Right_" + (i + 1));
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
}
