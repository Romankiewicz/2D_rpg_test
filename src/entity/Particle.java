package entity;

import main.GamePanel;

import java.awt.*;

public class Particle extends Entity {

    Entity generator;
    Color color;
    int size;
    int xd;
    int yd;

    public Particle(GamePanel gamePanel, Entity generator, Color color, int size, int speed, int maxHp, int xd, int yd) {

        super(gamePanel);
        this.generator = generator;
        this.color = color;
        this.size = size;
        this.speed = speed;
        this.maxHp = maxHp;
        this.xd = xd;
        this.yd = yd;

        hp = maxHp;
        worldX = generator.worldX;
        worldY = generator.worldY;

    }
}
