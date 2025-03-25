package entity;

import main.GamePanel;

import java.awt.*;
import java.util.Random;

public class NpcNakedGuy extends Entity {

    public NpcNakedGuy(GamePanel gamePanel) {

        super(gamePanel);
        direction = "down";
        speed = 1;
        solidArea.x = 10;
        solidArea.y = 10;
        solidAreaDefaultX = 10;
        solidAreaDefaultY = 10;
        solidArea.width = 50;
        solidArea.height = 48;
        getNpcImage();
    }

    public void getNpcImage() {

        for (int i = 0; i < 3; i++) {
            up[i] = setup("npc/nakedGuy", "Naked_Guy_Up_" + (i + 1));
        }

        for (int i = 0; i < 3; i++) {
            down[i] = setup("npc/nakedGuy", "Naked_Guy_Down_" + (i + 1));
        }

        for (int i = 0; i < 3; i++) {
            left[i] = setup("npc/nakedGuy", "Naked_Guy_Left_" + (i + 1));
        }

        for (int i = 0; i < 3; i++) {
            right[i] = setup("npc/nakedGuy", "Naked_Guy_Right_" + (i + 1));
        }
    }

    public void setAction() {

        actionCounter++;

        if (actionCounter == 120) {
            Random random = new Random();
            int i = random.nextInt(100) + 1;

            if (i <= 25) {
                direction = "up";
            }
            if (i > 25 && i <= 50) {
                direction = "down";
            }
            if (i > 50 && i <= 75) {
                direction = "left";
            }
            if (i > 75) {
                direction = "right";
            }
            actionCounter = 0;
        }
    }
}
