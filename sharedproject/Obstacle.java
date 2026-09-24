public class Obstacle {
    public int ObX;
    public int ObY;
    public int ObWidth;
    public int ObHeight;

    public Obstacle(int x, int y, int width, int height) {
        this.ObX = x;
        this.ObY = y;
        this.ObWidth = width;
        this.ObHeight = height;
    }

    public int getX() {
        return ObX;
    }

    public int getY() {
        return ObY;
    }

    public int getWidth() {
        return ObWidth;
    }

    public int getHeight() {
        return ObHeight;
    }

    public void changeX(int x) {
        ObX = x;
    }

    public void changeY(int y) {
        ObY = y;
    }
}
