import java.awt.event.KeyEvent;

public class Player {
    public int playerX, playerY;
    public int playerWidth, playerHeight;
    private int velocityX, velocityY;
    private boolean onGround;
    private final int gravity = 1;
    private final int moveSpeed = 5;
    private final int jumpStrength = 15;
    private int numCoins = 1;
    public int coinSide = 50;
    private Coin[] coins = { new Coin(600, 300) };

    public Player() {
        this.playerX = 50;
        this.playerY = 300;
        playerWidth = 25;
        playerHeight = 25;
        velocityX = 0;
        velocityY = 0;
        onGround = true;
    }

    public int getX() {
        return playerX;
    }

    public int getY() {
        return playerY;
    }

    public void changeX(int x) {
        playerX = x;
    }

    public void changeY(int y) {
        playerY = y;
    }

    private void update() {
        playerX += velocityX;
        playerY += velocityY;

        if (playerY + playerHeight >= 325) { // Ground collision
            playerY = 325 - playerHeight;
            velocityY = 0;
            onGround = true;
        } else {
            velocityY += gravity;
            onGround = false;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            velocityX = -moveSpeed;
        }

        if (key == KeyEvent.VK_RIGHT) {
            velocityX = moveSpeed;
        }

        if (key == KeyEvent.VK_UP && onGround) {
            velocityY = -jumpStrength;
            onGround = false;
        }

        if (key == KeyEvent.VK_SPACE && onGround) {
            velocityY = -jumpStrength;
            onGround = false;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            velocityX = 0;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
