package entity;

import main.GamePanel;
import main.KeyHandler;
import object.BlueKey;
import object.ChestOpen;
import object.DoorOpen;
import object.SilverKey;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;


public class Player extends Entity {

    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    int haveSilverKey = 0;
    int haveBlueKey = 0;
    boolean haveSword = false;

    public ArrayList<Entity> inventory = new ArrayList<>();
    public final int inventorySize = 20;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {

        super(gamePanel);

        this.keyHandler = keyHandler;

        screenX = gamePanel.screenWidth / 2 - gamePanel.tileSize / 2;
        screenY = gamePanel.screenHeight / 2 - gamePanel.tileSize / 2;

        solidArea.x = 16;
        solidArea.y = 30;
        solidAreaDefaultX = 16;
        solidAreaDefaultY = 30;
        solidArea.width = 40;
        solidArea.height = 40;

        attackArea.width = 45;
        attackArea.height = 45;

        setDefaultValues();
        getPlayerImage();
        getPlayerHandAttackImage();
        getPlayerSwordAttackImage();
        setItem();
    }

    public void setDefaultValues() {

        worldX = gamePanel.tileSize * 10;
        worldY = gamePanel.tileSize * 12;
        speed = 4;
        direction = "standingDown";
        lastDirection = "standingDown";
        maxHp = 6;
        hp = maxHp;

        level = 1;
        strength = 1;
        dexterity = 1;
        xp = 0;
        nextLevelXp = 10;
        coin = 0;
        currentWeapon = null;
        currentShield = null;
        attack = getAttack();
        defense = getDefense();
    }

    public void getPlayerImage() {

        standingUp = setup("player/standing/back", "Link_Back", gamePanel.tileSize, gamePanel.tileSize);

        for (int i = 0; i < 10; i++) {
            standingDown[i] = setup("player/standing/front", "Link_Front_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }

        for (int i = 0; i < 10; i++) {
            standingLeft[i] = setup("player/standing/left", "Link_Left_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }

        for (int i = 0; i < 10; i++) {
            standingRight[i] = setup("player/standing/right", "Link_Right_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }

        for (int i = 0; i < 10; i++) {
            up[i] = setup("player/walking/up", "Link_Walk_Up_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }

        for (int i = 0; i < 10; i++) {
            down[i] = setup("player/walking/down", "Link_Walk_Down_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }

        for (int i = 0; i < 10; i++) {
            left[i] = setup("player/walking/left", "Link_Walk_Left_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }

        for (int i = 0; i < 10; i++) {
            right[i] = setup("player/walking/right", "Link_Walk_Right_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
    }

    public void getPlayerHandAttackImage() {

        for (int i = 0; i < 5; i++) {
            handAttackUp[i] = setup("player/attacking/handAttack", "HandAttack_Up_" + (i + 1), gamePanel.tileSize,
                    gamePanel.tileSize);
        }
        for (int i = 0; i < 5; i++) {
            handAttackDown[i] = setup("player/attacking/handAttack", "HandAttack_Down_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
        for (int i = 0; i < 5; i++) {
            handAttackLeft[i] = setup("player/attacking/handAttack", "HandAttack_Left_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
        for (int i = 0; i < 5; i++) {
            handAttackRight[i] = setup("player/attacking/handAttack", "HandAttack_Right_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize);
        }
    }

    public void getPlayerSwordAttackImage() {

        for (int i = 0; i < 5; i++) {
            swordAttackUp[i] = setup("player/attacking/swordAttack", "SwordAttack_Up_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize * 2);
        }
        for (int i = 0; i < 5; i++) {
            swordAttackDown[i] = setup("player/attacking/swordAttack", "SwordAttack_Down_" + (i + 1), gamePanel.tileSize, gamePanel.tileSize * 2);
        }
        for (int i = 0; i < 5; i++) {
            swordAttackLeft[i] = setup("player/attacking/swordAttack", "SwordAttack_Left_" + (i + 1), gamePanel.tileSize * 2, gamePanel.tileSize);
        }
        for (int i = 0; i < 5; i++) {
            swordAttackRight[i] = setup("player/attacking/swordAttack", "SwordAttack_Right_" + (i + 1), gamePanel.tileSize * 2, gamePanel.tileSize);
        }
    }

    public void setItem() {

        if (currentWeapon != null) {
            inventory.add(currentWeapon);
        }
        if (currentShield != null) {
            inventory.add(currentShield);
        }
    }

    public int getAttack() {
        if (currentWeapon == null) {
            return attack = strength;
        } else {
            return attack = strength * currentWeapon.attackValue;
        }
    }

    public int getDefense() {
        if (currentShield == null) {
            return defense = dexterity;
        } else {
            return defense = dexterity * currentShield.defenseValue;
        }
    }

    public void update() {

        if (attacking) {
            attack();
        } else {
            //MOVE PLAYER
            if (keyHandler.upPressed) {
                direction = "up";
                lastDirection = "standingUp";
            } else if (keyHandler.downPressed) {
                direction = "down";
                lastDirection = "standingDown";
            } else if (keyHandler.leftPressed) {
                direction = "left";
                lastDirection = "standingLeft";
            } else if (keyHandler.rightPressed) {
                direction = "right";
                lastDirection = "standingRight";
            } else if (keyHandler.upReleased || keyHandler.downReleased || keyHandler.leftReleased || keyHandler.rightReleased) {
                direction = lastDirection;
            }

            //COLLISION CHECKING
            collisionOn = false;
            gamePanel.collisionChecker.checkTile(this);

            int objectIndex = gamePanel.collisionChecker.checkObjectCollision(this, true);
            objectInteract(objectIndex);

            int npcIndex = gamePanel.collisionChecker.checkEntityCollision(this, gamePanel.npcs);
            npcInteract(npcIndex);

            int enemyIndex = gamePanel.collisionChecker.checkEntityCollision(this, gamePanel.enemies);
            enemyInteract(enemyIndex);

            gamePanel.eventHandler.checkEvent();

            if (!collisionOn && !keyHandler.spacePressed && !keyHandler.enterPressed) {
                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }
            }

            gamePanel.keyHandler.spacePressed = false;
            gamePanel.keyHandler.enterPressed = false;

            //SPRITE CHANGER
            spriteCounter++;
            if (spriteCounter > 5) {
                switch (spriteNum) {
                    case 0 -> spriteNum = 1;
                    case 1 -> spriteNum = 2;
                    case 2 -> spriteNum = 3;
                    case 3 -> spriteNum = 4;
                    case 4 -> spriteNum = 5;
                    case 5 -> spriteNum = 6;
                    case 6 -> spriteNum = 7;
                    case 7 -> spriteNum = 8;
                    case 8 -> spriteNum = 9;
                    case 9 -> spriteNum = 0;
                }
                spriteCounter = 0;
            }

            moveCounter++;
            if (moveCounter > 5) {
                switch (movingSpriteNum) {
                    case 0 -> movingSpriteNum = 1;
                    case 1 -> movingSpriteNum = 2;
                    case 2 -> movingSpriteNum = 3;
                    case 3 -> movingSpriteNum = 4;
                    case 4 -> movingSpriteNum = 5;
                    case 5 -> movingSpriteNum = 6;
                    case 6 -> movingSpriteNum = 7;
                    case 7 -> movingSpriteNum = 8;
                    case 8 -> movingSpriteNum = 9;
                    case 9 -> movingSpriteNum = 0;
                }
                moveCounter = 0;
            }

            if (invincible) {
                invincibleCounter++;
                if (invincibleCounter > 60) {
                    invincible = false;
                    invincibleCounter = 0;
                }
            }
        }
    }

    public void attack() {

        attackSpriteCounter++;

        if (attackSpriteCounter <= 3) {
            attackSpriteNum = 0;
        }
        if (attackSpriteCounter > 3 && attackSpriteCounter <= 6) {
            attackSpriteNum = 1;
        }
        if (attackSpriteCounter > 6 && attackSpriteCounter <= 9) {
            attackSpriteNum = 2;
        }
        if (attackSpriteCounter > 9 && attackSpriteCounter <= 12) {
            attackSpriteNum = 3;
        }
        if (attackSpriteCounter > 12 && attackSpriteCounter <= 20) {
            attackSpriteNum = 4;

            int currentWorldX = worldX;
            int currentWorldY = worldY;
            int solidAreaWidth = solidArea.width;
            int solidAreaHeight = solidArea.height;

            switch (lastDirection) {
                case "standingUp":
                    worldY -= attackArea.height;
                    break;
                case "standingDown":
                    worldY += attackArea.height;
                    break;
                case "standingLeft":
                    worldX -= attackArea.width;
                    break;
                case "standingRight":
                    worldX += attackArea.width;
                    break;
            }
            if (!haveSword) {
                solidArea.width = attackArea.width - 20;
                solidArea.height = attackArea.height - 20;
            }

            if (haveSword) {
                solidArea.width = attackArea.width;
                solidArea.height = attackArea.height;
            }

            int enemyIndex = gamePanel.collisionChecker.checkEntityCollision(this, gamePanel.enemies);
            damageEnemy(enemyIndex);

            worldX = currentWorldX;
            worldY = currentWorldY;
            solidArea.width = solidAreaWidth;
            solidArea.height = solidAreaHeight;
        }
        if (attackSpriteCounter > 20) {
            attackSpriteNum = 0;
            attackSpriteCounter = 0;
            attacking = false;
        }

    }

    public void objectInteract(int i) {

        if (i != 999) {

            String objectName = gamePanel.objects[i].name;
            switch (objectName) {
                case "Silver Key":
                    gamePanel.playSFX(3);
                    haveSilverKey++;
                    inventory.add(gamePanel.objects[i]);
                    gamePanel.objects[i] = null;
                    break;
                case "Blue Key":
                    gamePanel.playSFX(3);
                    haveBlueKey++;
                    inventory.add(gamePanel.objects[i]);
                    gamePanel.objects[i] = null;
                    break;
                case "Door":
                    if (haveSilverKey > 0) {
                        gamePanel.playSFX(4);
                        int x = gamePanel.objects[i].worldX;
                        int y = gamePanel.objects[i].worldY;
                        gamePanel.objects[i] = new DoorOpen(gamePanel);
                        gamePanel.objects[i].worldX = x;
                        gamePanel.objects[i].worldY = y;
                        haveSilverKey--;
                    }
                    break;
                case "Chest":
                    if (haveBlueKey > 0) {
                        gamePanel.playSFX(4);
                        int x = gamePanel.objects[i].worldX;
                        int y = gamePanel.objects[i].worldY;
                        gamePanel.objects[i] = new ChestOpen(gamePanel);
                        gamePanel.objects[i].worldX = x;
                        gamePanel.objects[i].worldY = y;
                        Random random = new Random();
                        int reward = random.nextInt(100) + 1;
                        coin += reward;
                        gamePanel.ui.addMessage("You found");
                        gamePanel.ui.addMessage("" + reward);
                        gamePanel.ui.addMessage("coins.");
                        haveBlueKey--;
                    }
                    break;
                case "Normal Sword":
                    gamePanel.playSFX(3);
                    haveSword = true;
                    currentWeapon = gamePanel.objects[i];
                    attack = getAttack();
                    inventory.add(gamePanel.objects[i]);
                    gamePanel.objects[i] = null;
                    break;
                case "Wooden Shield":
                    gamePanel.playSFX(3);
                    currentShield = gamePanel.objects[i];
                    defense = getDefense();
                    inventory.add(gamePanel.objects[i]);
                    gamePanel.objects[i] = null;
                    break;
            }
        }
    }

    public void npcInteract(int i) {

        if (gamePanel.keyHandler.spacePressed) {
            if (i != 999) {

                gamePanel.gameState = gamePanel.dialogueState;
                gamePanel.npcs[i].speak();
            } else {
                attacking = true;
                gamePanel.playSFX(10);
            }
        }

    }

    public void enemyInteract(int i) {

        if (i != 999) {
            if (!invincible) {

                int damage = gamePanel.enemies[i].attack - defense;

                if (damage < 0) {
                    damage = 0;
                }

                hp -= damage;

                invincible = true;
                gamePanel.playSFX(8);
            }
        }
    }

    public void damageEnemy(int i) {

        if (i != 999) {

            if (!gamePanel.enemies[i].invincible) {

                int damage = attack - gamePanel.enemies[i].defense;

                if (damage < 0) {
                    damage = 0;
                }

                gamePanel.enemies[i].hp -= damage;

                gamePanel.enemies[i].invincible = true;
                gamePanel.playSFX(8);
                gamePanel.enemies[i].damageReaction();

                if (gamePanel.enemies[i].hp <= 0) {
                    gamePanel.enemies[i].isDying = true;

                    xp += getEnemiesXp(i);
                    gamePanel.ui.addMessage("+ " + getEnemiesXp(i) + " XP");
                    checkLevelUp();
                }
            }
        }
    }

    public void checkLevelUp() {

        if (xp >= nextLevelXp) {
            level++;
            nextLevelXp = (nextLevelXp + 6) * level;
            maxHp += 2;
            strength++;
            dexterity++;
            getAttack();
            getDefense();
            gamePanel.gameState = gamePanel.dialogueState;
            gamePanel.ui.currentDialogue = "\n\nCongratulations!\nyou reached level " + level;
            gamePanel.playSFX(1);
        }
    }

    private int getEnemiesXp(int i) {
        return gamePanel.enemies[i].xp;
    }

    public void draw(Graphics2D g2) {

        BufferedImage image = null;
        int tempScreenX = screenX;
        int tempScreenY = screenY;

        if (!attacking) {
            if (Objects.equals(direction, lastDirection)) {
                image = switch (lastDirection) {
                    case "standingUp" -> standingUp;
                    case "standingDown" -> standingDown[spriteNum];
                    case "standingLeft" -> standingLeft[spriteNum];
                    case "standingRight" -> standingRight[spriteNum];
                    default -> image;
                };
            }

            image = switch (direction) {
                case "up" -> up[movingSpriteNum];
                case "down" -> down[movingSpriteNum];
                case "left" -> left[movingSpriteNum];
                case "right" -> right[movingSpriteNum];
                default -> image;
            };
        }

        if (attacking) {
            if (haveSword) {
                image = switch (lastDirection) {
                    case "standingUp" -> {
                        tempScreenY = screenY - gamePanel.tileSize;
                        yield swordAttackUp[attackSpriteNum];
                    }
                    case "standingDown" -> swordAttackDown[attackSpriteNum];
                    case "standingLeft" -> {
                        tempScreenX = screenX - gamePanel.tileSize;
                        yield swordAttackLeft[attackSpriteNum];
                    }
                    case "standingRight" -> swordAttackRight[attackSpriteNum];
                    default -> image;
                };
            }

            if (!haveSword) {
                image = switch (lastDirection) {
                    case "standingUp" -> handAttackUp[attackSpriteNum];
                    case "standingDown" -> handAttackDown[attackSpriteNum];
                    case "standingLeft" -> handAttackLeft[attackSpriteNum];
                    case "standingRight" -> handAttackRight[attackSpriteNum];
                    default -> image;
                };
            }
        }

        if (invincible) {
            g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.3f));
        }

        assert image != null;
        g2.drawImage(image, tempScreenX, tempScreenY, null);

        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0f));

    }
}
