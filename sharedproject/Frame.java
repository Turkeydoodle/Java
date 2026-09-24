import javax.swing.JFrame;

public class Frame {
    public static void start() {
        JFrame frame = new JFrame("Catch the Coin!");
        Platformer game = new Platformer();
        frame.add(game);
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
