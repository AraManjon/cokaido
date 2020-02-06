import java.util.Objects;

public class MarsRover {

    private int positionX;
    private int positionY;
    private char orientation;

    public MarsRover() {
        this.positionX = 0;
        this.positionY = 0;
        this.orientation = 'N';
    }

    public MarsRover(int positionX, int positionY, char orientation) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.orientation = orientation;
    }

    public void navigate(char movement) {
        if (this.orientation == 'N') this.positionY += 1;
        if (this.orientation == 'E') this.positionX += 1;
        if (this.orientation == 'S') this.positionY -= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MarsRover marsRover = (MarsRover) o;
        return positionX == marsRover.positionX &&
                positionY == marsRover.positionY &&
                orientation == marsRover.orientation;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionX, positionY, orientation);
    }
}
