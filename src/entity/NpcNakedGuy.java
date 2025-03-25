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
        setDialogue();
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

    public void speak() {

        if (dialogues[dialogueCounter] == null) {
            dialogueCounter = 0;
            gamePanel.gameState = gamePanel.playState;
        }
        gamePanel.ui.currentDialogue = dialogues[dialogueCounter];
        dialogueCounter++;

        switch (gamePanel.player.direction) {
            case "up":
                direction = "down";
                break;
            case "down":
                direction = "up";
                break;
            case "left":
                direction = "right";
                break;
            case "right":
                direction = "left";
                break;
        }
    }

    public void setDialogue() {

        dialogues[0] = "Oh hello Adventurer!";
        dialogues[1] = "Seems like you visiting our beautiful country";
        dialogues[2] = "Oh I mean it´s used to be beautiful but as you can see I´m totally naked";
        dialogues[3] = "A view years ago Underpants Gnomes come to our Land...";
        dialogues[4] = "... and as you can see they took all our clothing I mean not just the Underpants like they once used to...";
        dialogues[5] = "can you find them and bring back at least our Panties?";
        ;
    }
}
