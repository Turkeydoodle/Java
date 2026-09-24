import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Platformer extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    public int playerX, playerY;
    public int playerWidth, playerHeight;
    private int velocityX, velocityY;
    private boolean onGround;
    private final int gravity = 1;
    private final int moveSpeed = 5;
    private final int jumpStrength = 15;
    private int numCoins = 1;
    public int coinSide = 25;
    private Player player = new Player();
    private Obstacle obstacle = new Obstacle(250, 250, 40, 150);
    private Coin coin = new Coin(600, 300);
    private int levelnum = 1;

    public Platformer() {
        timer = new Timer(20, this);
        timer.start();
        playerX = 50;
        playerY = 300;
        playerWidth = 25;
        playerHeight = 25;
        velocityX = 0;
        velocityY = 0;
        onGround = true;

        setFocusable(true);
        addKeyListener(this);
    }

    private void checkCoinCollision() {
        int playerLeft = playerX;
        int playerRight = playerX + playerWidth;
        int playerTop = playerY;
        int playerBottom = playerY + playerHeight;

        int coinLeft = coin.getX();
        int coinRight = coin.getX() + coinSide;
        int coinTop = coin.getY();
        int coinBottom = coin.getY() + coinSide;

        if (playerRight > coinLeft && playerLeft < coinRight && playerBottom > coinTop && playerTop < coinBottom) {
            System.out.println("Coin Collison detected.");
            levelnum += 1;
            if (levelnum % 2 == 0) {
                coin.changeX(50);
            } else {
                coin.changeX(600);
            }
        }
    }

    public void checkObstacleCollision(int levelnum) {
        int playerLeft = playerX;
        int playerRight = playerX + playerWidth;
        int playerTop = playerY;
        int playerBottom = playerY + playerHeight;

        int obLeft = obstacle.getX();
        int obRight = obstacle.getX() + obstacle.getWidth();
        int obTop = obstacle.getY();
        int obBottom = obstacle.getY() + obstacle.getHeight();
        if (levelnum != 1) {
            if (playerRight > obLeft && playerLeft < obRight && playerBottom > obTop && playerTop < obBottom) {
                System.out.println("Obstacle Collison detected.");
                if (levelnum == 2) {
                    player.changeX(600);
                    playerX = player.getX();
                } else {
                    player.changeX(50);
                    playerX = player.getX();
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (levelnum == 1) {
            super.paintComponent(g);
            g.setColor(Color.CYAN);
            g.fillRect(0, 0, getWidth(), getHeight()); // Background
            g.setColor(Color.GREEN);
            g.fillRect(0, 350, getWidth(), 50); // Ground
            g.setColor(Color.RED);
            g.fillRect(playerX, playerY, playerWidth, playerHeight); // Player
            g.setColor(Color.yellow);
            g.fillOval(coin.getX(), coin.getY(), coinSide, coinSide); // Coin
            g.setColor(Color.BLACK);
            g.drawString("Level 1", 20, 30);
        } else if (levelnum == 2) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillRect(0, 0, getWidth(), getHeight()); // Background
            g.setColor(Color.BLACK);
            g.fillRect(0, 350, getWidth(), 50); // Ground
            g.setColor(Color.RED);
            g.fillRect(playerX, playerY, playerWidth, playerHeight); // Player
            g.setColor(Color.yellow);
            g.fillOval(coin.coinX, coin.getY(), coinSide, coinSide); // Coin
            g.setColor(Color.ORANGE);
            g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
            g.setColor(Color.WHITE);
            g.drawString("Level 2", 20, 30);
        } else if (levelnum == 3) {
            super.paintComponent(g);
            g.setColor(Color.RED);
            g.fillRect(0, 0, getWidth(), getHeight()); // Background
            g.setColor(Color.BLUE);
            g.fillRect(0, 350, getWidth(), 50); // Ground
            g.setColor(Color.GREEN);
            g.fillRect(playerX, playerY, playerWidth, playerHeight); // Player
            g.setColor(Color.yellow);
            g.fillOval(coin.getX(), coin.getY(), coinSide, coinSide); // Coin
            g.setColor(Color.BLACK);
            g.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
            g.setColor(Color.WHITE);
            g.drawString("Level 3", 20, 30);
        } else {
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.WHITE);
            g.drawString("The End!", 400, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        checkCoinCollision();
        checkObstacleCollision(levelnum);
        update();
        repaint();
    }

    private void update() {
        playerX += velocityX;
        playerY += velocityY;

        if (playerY + playerHeight >= 350) { // Ground collision
            playerY = 350 - playerHeight;
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
