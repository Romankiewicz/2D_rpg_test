package entity;

import main.GamePanel;

import java.util.Random;

import static entity.EntityType.NPC;

public class NpcNakedGuy extends Entity {

    public NpcNakedGuy(GamePanel gamePanel) {

        super(gamePanel);

        type = NPC;

        direction = "down";
        speed = 1;
        solidArea.x = 10;
        solidArea.y = 10;
        solidAreaDefaultX = 10;
        solidAreaDefaultY = 10;
        solidArea.width = 50;
        solidArea.height = 48;
        threeSprites = true;
        getNpcImage();
        setDialogue();
    }

    public void getNpcImage() {

        for (int i = 0; i < 3; i++) {
            up[i] = setup("npc/nakedGuy", "Naked_Guy_Up_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }

        for (int i = 0; i < 3; i++) {
            down[i] = setup("npc/nakedGuy", "Naked_Guy_Down_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }

        for (int i = 0; i < 3; i++) {
            left[i] = setup("npc/nakedGuy", "Naked_Guy_Left_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }

        for (int i = 0; i < 3; i++) {
            right[i] = setup("npc/nakedGuy", "Naked_Guy_Right_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
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

    public void speak() {

        super.speak();
    }

    public void setDialogue() {

        dialogues[0] = "Oh hello Adventurer!";
        dialogues[1] = "Seems like you visiting \nour beautiful country \n\n...";
        dialogues[2] = "...\nOh I mean it´s used to be beautiful \nbut as you can see I´m totally naked \n\n...";
        dialogues[3] = "...\nA view years ago \nUnderpants Gnomes come \nto our Land\n\n...";
        dialogues[4] = "...\nand as you can see \nthey took all our clothing \nI mean not just the Underpants \nlike they once used to \n...";
        dialogues[5] = "...\ncan you find them \nand bring back at least our Panties?";
    }
}
