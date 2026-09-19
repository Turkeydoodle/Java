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
    public int coinSide = 50;
    private Coin[] coins = { new Coin(600, 300) };

    public Platformer() {
        timer = new Timer(20, this);
        timer.start();
        playerX = 50;
        playerY = 300;
        playerWidth = 50;
        playerHeight = 50;
        velocityX = 0;
        velocityY = 0;
        onGround = true;

        setFocusable(true);
        addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.CYAN);
        g.fillRect(0, 0, getWidth(), getHeight()); // Background
        g.setColor(Color.GREEN);
        g.fillRect(0, 350, getWidth(), 50); // Ground
        g.setColor(Color.RED);
        g.fillRect(playerX, playerY, playerWidth, playerHeight); // Player
        g.setColor(Color.yellow);
        for (Coin coin : coins) {
            g.fillOval(coin.getX(), coin.getY(), coinSide, coinSide);
        } // Coin
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
    }if(coinX=playerX&&coinY==playerY)

    {

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}
