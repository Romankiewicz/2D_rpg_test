package entity;

import main.GamePanel;

public class NpcNakedGuy extends Entity {

    public NpcNakedGuy(GamePanel gamePanel) {

        super(gamePanel);
        direction = "down";
        speed = 1;
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


}
