package main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int worldX, worldY;
    public int speed;


    public BufferedImage standingUp;
    public BufferedImage[] standingDown = new BufferedImage[10];
    public BufferedImage[] standingLeft = new BufferedImage[10];
    public BufferedImage[] standingRight = new BufferedImage[10];


    public BufferedImage[] up = new BufferedImage[10];
    public BufferedImage[] down = new BufferedImage[10];
    public BufferedImage[] left = new BufferedImage[10];
    public BufferedImage[] right = new BufferedImage[10];

    public String direction;
    public String lastDirection;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public int moveCounter = 0;
    public int movingSpriteNum = 1;

    public Rectangle solidArea;
    public boolean collisionOn = false;
}
