import javax.swing.*;
import java.awt.*;

public class Coin extends JComponent {
    public int coinX;
    public int coinY;
    public int coinSide;

    public Coin(int coinX, int coinY) {
        coinSide = 50;
        this.coinX = coinX;
        this.coinY = coinY;
    }

    public int getX() {
        return coinX;
    }

    public int getY() {
        return coinY;
    }
}
