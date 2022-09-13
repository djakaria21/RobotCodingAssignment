package robotParts;

public class Position { // this is a class
    private int width;
    private int height;
    public Position(int width, int height) { // this is a constructor
        this.width = width;
        this.height = height;
    }
    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

}
